package com.MowItNow.mower.parser;

import com.MowItNow.mower.enumeration.Instruction;
import com.MowItNow.mower.enumeration.Orientation;

public class Parser {
    /**
     * parser la position de la tondeuse et son orientation
     * La position et l'orientation sont fournies sous la forme de 2 chiffres et une lettre,
     * séparés par un espace
     * @param mower
     * @return true si la ligne des positions est correcte, false sinon
     */
    public static boolean mower(String mower){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(Orientation.NORTH.getCode())
                .append("|").append(Orientation.SOUTH.getCode())
                .append("|").append(Orientation.EAST.getCode())
                .append("|").append(Orientation.WEST.getCode());
        return mower.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
    }

    /**
     * parser la ligne des instructions
     * les instructions sont une suite de caractères(G, D, A) sans espaces
     * @param instructions
     * @return true si la ligne des instructions est correcte, false sinon
     */
    public static boolean instructions(String instructions){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("(").append(Instruction.AVANCER.getCodeInstruction())
                .append("|").append(Instruction.DROITE.getCodeInstruction())
                .append("|").append(Instruction.GAUCHE.getCodeInstruction())
                .append(")+");

        return instructions.matches(stringBuilder.toString());
    }

    /**
     * parser la position de la pelouse
     * la position de la pelouse est sous forme de 2 chiffres séparés par espace
     * @param lawn
     * @return true si la ligne des instructions est correcte, false sinon
     */
    public static boolean lawn(String lawn){
        return lawn.matches("(\\d+) (\\d+)");
    }
}
