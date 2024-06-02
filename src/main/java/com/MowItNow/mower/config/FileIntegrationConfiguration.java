package com.MowItNow.mower.config;

import com.MowItNow.mower.service.MowerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.handler.LoggingHandler;

import java.io.File;

@Configuration
public class FileIntegrationConfiguration {

    @Value("${file.path}")
    private String optimFilesPath;

    private final MowerService mowerService;

    public FileIntegrationConfiguration(MowerService mowerService) {
        this.mowerService = mowerService;
    }

    @Bean
    public IntegrationFlow fileIntegrationFlow() {
        return IntegrationFlows.from(Files.inboundAdapter(new File(optimFilesPath)) // Read Files
                , e -> e.poller(Pollers.fixedDelay(500)))
                .log(LoggingHandler.Level.INFO, m -> "New File Received : " + m.getPayload())
                .transform(mowerService, "lancerTraitementsTondeuses")
                .handle(result -> System.out.println(result))
                .get();
    }
}
