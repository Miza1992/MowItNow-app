package com.MowItNow.mower.service;

import com.MowItNow.mower.entities.Coordonnees;
import com.MowItNow.mower.entities.Lawn;
import com.MowItNow.mower.entities.Mower;
import com.MowItNow.mower.enumeration.Instruction;
import com.MowItNow.mower.enumeration.Orientation;

import java.util.ArrayList;
import java.util.List;

public class Formater {
    private static final String CHAINE_ESPACE = " ";

    /**
     * récuperer la position de la tondeuse qui est définit par ses coordonnées et son orientation
     * @param ligneTondeuse : ligne de la position de la tondeuse ( ex : 2 3 G)
     * @return l'objet qui définit la position dela tondeuse
     */
    public static Mower tondeuse(String ligneTondeuse){
        String[] elts = ligneTondeuse.split(CHAINE_ESPACE);
        Coordonnees pCoordonneesTondeuse = new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
        Orientation orientationTondeuse = getOrientation(elts[2].charAt(0));
        return new Mower(pCoordonneesTondeuse, orientationTondeuse);
    }

    /**
     * récuperer l'objet Pelouse contenant les coordonnées limites de la pelouse
     * @param ligne : ligne de la pelouse ( ex : 2 3)
     * @return l'objet qui définit la limite de la pelouse
     */

    public static Lawn lawn(String ligne){
        String[] elts = ligne.split(CHAINE_ESPACE);
        return new Lawn(new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
    }

    /**
     * récuperer une liste d'enum InstructionTondeuse correspondante à la ligne d'instruction
     * @param ligne : suite d'instruction ( ex : GDAGD)
     * @return une liste d'enum InstrctionTondeuse
     */
    public static List<Instruction> instructions(String ligne){
        List<Instruction> listInstruction = new ArrayList<>();
        for(char instruction :ligne.toCharArray()){
            listInstruction.add(getInstruction(instruction));
        }
        return listInstruction;
    }

    /**
     * récuperer un enum Orientation correspondant au caractère de l'orientation
     * @param cOrientation : caractère de l'orientation (E, W, N, S)
     * @return l'enum correspondant à l'orientation
     */
    public static Orientation getOrientation(char cOrientation){
        for(Orientation orientation : Orientation.values()) {
            if (orientation.getCode() == cOrientation){
                return orientation;
            }
        }
        return null;
    }

    /**
     * récuperer un enum InstructionTondeuse correspondant au caractère d'instrction
     * @param cInstruction : caractère de l'instruction (A, G, D)
     * @return l'enum correspondant à l'instruction
     */
    public static Instruction getInstruction(char cInstruction){
        for(Instruction instruction : Instruction.values()) {
            if (instruction.getCodeInstruction() == cInstruction) {
                return instruction;
            }
        }
        return null;
    }
}
