package com.MowItNow.mower.entities;

import com.MowItNow.mower.enumeration.Instruction;
import com.MowItNow.mower.enumeration.Orientation;
import com.MowItNow.mower.exception.ExceptionTondeuse;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreatmentTest {
    Coordonnees coordonnesMax = new Coordonnees(5, 5);

    @Test
    public void executer_instruction_aucune_instruction() throws ExceptionTondeuse {
        int x = 0;
        int y = 0;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees, Orientation.NORTH);

        Treatment traitemet = new Treatment(new Lawn(coordonnesMax),mower,new ArrayList<>());
        traitemet.executerInstructions();
        Assertions.assertThat(traitemet.toString()).isEqualTo("0 0 N");
    }

    @Test
    public void executer_instruction_unitaire() throws ExceptionTondeuse{
        List<Instruction> listInstruction = new ArrayList<Instruction>();
        listInstruction.add(Instruction.AVANCER);
        int x = 1;
        int y = 1;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees, Orientation.NORTH);
        Treatment traitemet = new Treatment(new Lawn(coordonnesMax),mower,listInstruction);
        traitemet.executerInstructions();
        Assertions.assertThat(traitemet.toString()).isEqualTo("1 2 N");
    }

    @Test
    public void executer_instruction_plusieurs() throws ExceptionTondeuse{
        List<Instruction> listInstruction = new ArrayList<Instruction>();
        listInstruction.add(Instruction.GAUCHE);
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.GAUCHE);
        listInstruction.add(Instruction.AVANCER);
        int x = 3;
        int y = 2;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees, Orientation.NORTH);
        Treatment traitemet = new Treatment(new Lawn(coordonnesMax),mower,listInstruction);
        traitemet.executerInstructions();
        Assertions.assertThat(traitemet.toString()).isEqualTo("2 1 S");
    }

    @Test
    public void executer_instruction_cas_reel_1() throws ExceptionTondeuse{
        List<Instruction> listInstruction = new ArrayList<Instruction>();
        listInstruction.add(Instruction.GAUCHE);
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.GAUCHE);
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.GAUCHE);
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.GAUCHE);
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.AVANCER);
        int x = 1;
        int y = 2;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees, Orientation.NORTH);
        Treatment traitemet = new Treatment(new Lawn(coordonnesMax),mower,listInstruction);
        traitemet.executerInstructions();
        Assertions.assertThat(traitemet.toString()).isEqualTo("1 3 N");
    }
    @Test
    public void executer_instruction_cas_reel_2() throws ExceptionTondeuse{
        List<Instruction> listInstruction = new ArrayList<Instruction>();
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.DROITE);
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.DROITE);
        listInstruction.add(Instruction.AVANCER);
        listInstruction.add(Instruction.DROITE);
        listInstruction.add(Instruction.DROITE);
        listInstruction.add(Instruction.AVANCER);
        int x = 3;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees, Orientation.EAST);
        Treatment traitemet = new Treatment(new Lawn(coordonnesMax),mower,listInstruction);
        traitemet.executerInstructions();
        Assertions.assertThat(traitemet.toString()).isEqualTo("5 1 E");
    }
}
