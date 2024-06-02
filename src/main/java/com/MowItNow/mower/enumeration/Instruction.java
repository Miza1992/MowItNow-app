package com.MowItNow.mower.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Instruction {
    DROITE('D', "Pivoter à droite"),
    GAUCHE('G', "Pivoter à gauche"),
    AVANCER('A', "Avancer");

    private char codeInstruction;
    private String libelleInstruction;

}
