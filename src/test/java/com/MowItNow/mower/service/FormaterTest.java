package com.MowItNow.mower.service;

import com.MowItNow.mower.entities.Coordonnees;
import com.MowItNow.mower.entities.Lawn;
import com.MowItNow.mower.enumeration.Instruction;
import com.MowItNow.mower.enumeration.Orientation;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FormaterTest {
    @Test
    public void formater_ligne_tondeuse() {
        Assertions.assertThat(Formater.tondeuse("10 15 N").getCoordonnees()).isEqualTo(new Coordonnees(10, 15));
        Assertions.assertThat(Formater.tondeuse("10 15 N").getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void formater_ligne_pelouse() {
        Assertions.assertThat(Formater.lawn("10 15")).isEqualTo(new Lawn(new Coordonnees(10, 15)));
    }

    @Test
    public void formater_ligne_instruction() {
        Assertions.assertThat(Formater.instructions("DGAD")).hasSize(4)
                .contains(Instruction.DROITE)
                .contains(Instruction.GAUCHE)
                .contains(Instruction.AVANCER);
    }

    @Test
    public void recuperer_orientation() {
        Assertions.assertThat(Formater.getOrientation('E')).isEqualTo(Orientation.EAST);
        Assertions.assertThat(Formater.getOrientation('N')).isEqualTo(Orientation.NORTH);
        Assertions.assertThat(Formater.getOrientation('S')).isEqualTo(Orientation.SOUTH);
        Assertions.assertThat(Formater.getOrientation('W')).isEqualTo(Orientation.WEST);
        Assertions.assertThat(Formater.getOrientation('a')).isNull();
    }

    @Test
    public void testGetInstruction() {
        Assertions.assertThat(Formater.getInstruction('A')).isEqualTo(Instruction.AVANCER);
        Assertions.assertThat(Formater.getInstruction('D')).isEqualTo(Instruction.DROITE);
        Assertions.assertThat(Formater.getInstruction('G')).isEqualTo(Instruction.GAUCHE);
        Assertions.assertThat(Formater.getInstruction(' ')).isNull();
    }
}
