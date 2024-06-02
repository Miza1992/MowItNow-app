package com.MowItNow.mower.service;

import com.MowItNow.mower.entities.Treatment;
import com.MowItNow.mower.enumeration.Instruction;
import com.MowItNow.mower.exception.ExceptionTondeuse;
import com.MowItNow.mower.entities.FileInstruction;
import com.MowItNow.mower.utils.constants;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class MowerService {


    public List<String> lancerTraitementsTondeuses(File fichier)
            throws ExceptionTondeuse, IOException {
        if (!fichier.isFile()) {
            throw new ExceptionTondeuse(constants.ERREUR_FICHIER_INEXISTANT);
        } else {
            FileInstruction parser = new FileInstruction();
            Scanner scanner = new Scanner(fichier);
            try {
                traiterPremiereLigne(parser, scanner);
                return traiterLignesSuivantes(parser, scanner);
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }
    }

    private void traiterPremiereLigne(FileInstruction parser, Scanner scanner)
            throws ExceptionTondeuse {
        if (scanner.hasNext()) {
            parser.setPelouse(scanner.nextLine());
        }
        if (!scanner.hasNext()) {
            throw new ExceptionTondeuse(
                    constants.ERREUR_DONNEES_INCORRECTES);
        }
    }

    private List<String> traiterLignesSuivantes(FileInstruction parser,
                                                Scanner scanner) throws ExceptionTondeuse {
        List<String> listePositions = new ArrayList<>();
        while (scanner.hasNext()) {
            // lecture de la positon initiale de la tondeuse
            parser.setTondeuse(scanner.nextLine());

            if (scanner.hasNext()) {
                parser.setInstructions(scanner.nextLine());
                listePositions.add(parserEtLancerTraitement(parser));
            } else {
                throw new ExceptionTondeuse(constants.ERREUR_DONNEES_INCORRECTES);
            }
        }
        return listePositions;
    }

    /**
     * Parser et executer le traitement de la tondeuse
     *
     * @param parser : l'objet contenant les informations de la tondeuse
     * @throws ExceptionTondeuse
     */
    private String parserEtLancerTraitement(FileInstruction parser)
            throws ExceptionTondeuse {
        if (!parser.isValid()) {
            throw new ExceptionTondeuse(constants.ERREUR_DONNEES_INCORRECTES);
        } else {
            Treatment traitement = new Treatment(
                    Formater.lawn(parser.getPelouse()),
                    Formater.tondeuse(parser.getTondeuse()),
                    Formater.instructions(parser.getInstructions()));

            traitement.executerInstructions();
            System.out.println(traitement);
            return traitement.toString();
        }
    }

}
