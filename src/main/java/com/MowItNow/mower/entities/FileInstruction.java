package com.MowItNow.mower.entities;

import com.MowItNow.mower.parser.Parser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileInstruction {
    private String pelouse ;
    private String tondeuse ;
    private String instructions ;
    /**
     * @return true si les informations de la tondeuse sont correctes, false sinon
     */
    public boolean isValid(){
        return Parser.mower(tondeuse)
                && Parser.lawn(pelouse)
                && Parser.instructions(instructions);
    }
}
