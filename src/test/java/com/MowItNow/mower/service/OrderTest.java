package com.MowItNow.mower.service;

import com.MowItNow.mower.entities.Coordonnees;
import com.MowItNow.mower.entities.Mower;
import com.MowItNow.mower.enumeration.Instruction;
import com.MowItNow.mower.enumeration.Orientation;
import com.MowItNow.mower.exception.ExceptionTondeuse;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OrderTest {
    Coordonnees coordonnesMax = new Coordonnees(5, 5);
    @Test
    public void coordonnees_x_y_south_instruction_Tourner_Droite() throws ExceptionTondeuse {
        Coordonnees coordonnesMax = new Coordonnees(5, 5);
        int x = 2;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees, Orientation.SOUTH);
        Order.executer(mower, Instruction.DROITE, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.WEST);
    }


    @Test
    public void pivoter_a_droite() throws ExceptionTondeuse{

        Orientation orientationSuivante = Order.pivoterDroite(Orientation.EAST);
        Assertions.assertThat(orientationSuivante).isEqualTo(Orientation.SOUTH);

        orientationSuivante = Order.pivoterDroite(Orientation.WEST);
        Assertions.assertThat(orientationSuivante).isEqualTo(Orientation.NORTH);

        orientationSuivante = Order.pivoterDroite(Orientation.NORTH);
        Assertions.assertThat(orientationSuivante).isEqualTo(Orientation.EAST);

        orientationSuivante = Order.pivoterDroite(Orientation.SOUTH);
        Assertions.assertThat(orientationSuivante).isEqualTo(Orientation.WEST);
    }

    @Test
    public void pivoter_a_gauche() throws ExceptionTondeuse{
        Orientation orientationSuivante = Order.pivoterGauche(Orientation.EAST);
        Assertions.assertThat(orientationSuivante).isEqualTo(Orientation.NORTH);

        orientationSuivante = Order.pivoterGauche(Orientation.WEST);
        Assertions.assertThat(orientationSuivante).isEqualTo(Orientation.SOUTH);

        orientationSuivante = Order.pivoterGauche(Orientation.NORTH);
        Assertions.assertThat(orientationSuivante).isEqualTo(Orientation.WEST);

        orientationSuivante = Order.pivoterGauche(Orientation.SOUTH);
        Assertions.assertThat(orientationSuivante).isEqualTo(Orientation.EAST);
    }
    @Test
    public void coordonnees_x_y_north_instruction_avancer() throws ExceptionTondeuse {
        int x = 0;
        int y = 0;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.NORTH);
        Order.executer(mower, Instruction.AVANCER, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y+1));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void coordonnees_x_y_East_instruction_avancer() throws ExceptionTondeuse {
        int x = 0;
        int y = 0;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.EAST);
        Order.executer(mower, Instruction.AVANCER, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x+1, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.EAST);
    }

    @Test
    public void coordonnees_x_y_South_instruction_avancer() throws ExceptionTondeuse {
        int x = 5;
        int y = 5;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.SOUTH);
        Order.executer(mower, Instruction.AVANCER, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y-1));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.SOUTH);
    }

    @Test
    public void coordonnees_x_y_West_instruction_avancer() throws ExceptionTondeuse {
        int x = 5;
        int y = 5;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.WEST);
        Order.executer(mower, Instruction.AVANCER, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x-1, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.WEST);
    }
    @Test
    public void coordonnees_x_y_West_instruction_Tourner_gauche() throws ExceptionTondeuse {
        int x = 2;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.WEST);
        Order.executer(mower, Instruction.GAUCHE, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.SOUTH);
    }
    @Test
    public void coordonnees_x_y_east_instruction_Tourner_gauche() throws ExceptionTondeuse {
        int x = 2;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.EAST);
         Order.executer(mower, Instruction.GAUCHE, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void coordonnees_x_y_west_instruction_Tourner_gauche() throws ExceptionTondeuse {
        int x = 2;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.WEST);
         Order.executer(mower, Instruction.GAUCHE, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.SOUTH);
    }
    @Test
    public void coordonnees_x_y_south_instruction_Tourner_gauche() throws ExceptionTondeuse {
        int x = 2;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.SOUTH);
         Order.executer(mower, Instruction.GAUCHE, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.EAST);
    }

    @Test
    public void coordonnees_x_y_north_instruction_Tourner_Droite() throws ExceptionTondeuse {
        int x = 2;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.NORTH);
         Order.executer(mower, Instruction.DROITE, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.EAST);
    }

    @Test
    public void coordonnees_x_y_east_instruction_Tourner_Droite() throws ExceptionTondeuse {
        int x = 2;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.EAST);
         Order.executer(mower, Instruction.DROITE, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.SOUTH);
    }

    @Test
    public void coordonnees_x_y_west_instruction_Tourner_Droite() throws ExceptionTondeuse {
        int x = 2;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        Mower mower = new Mower(coordonnees,Orientation.WEST);
         Order.executer(mower, Instruction.DROITE, coordonnesMax);
        Assertions.assertThat(mower.getCoordonnees()).isEqualTo(new Coordonnees(x, y));
        Assertions.assertThat(mower.getOrientation()).isEqualTo(Orientation.NORTH);
    }
}
