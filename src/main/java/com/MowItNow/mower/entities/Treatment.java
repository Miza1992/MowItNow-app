package com.MowItNow.mower.entities;

import com.MowItNow.mower.enumeration.Instruction;
import com.MowItNow.mower.exception.ExceptionTondeuse;
import com.MowItNow.mower.service.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Treatment {
    private Lawn lawn;
    private Mower mower;
    private List<Instruction> listeInstruction = new ArrayList<>();

    /**
     * executer l'ensemble des insctructions par une tondeuse
     *
     * @throws ExceptionTondeuse
     */
    public void executerInstructions() throws ExceptionTondeuse {
        for (Instruction instruction : listeInstruction) {
            Order.executer(mower,
                    instruction, lawn.getPositionMax());
        }
    }

    public String toString() {
        return mower.getCoordonnees().getX()
                + " "
                + mower.getCoordonnees().getY()
                + " "
                + mower.getOrientation().getCode();
    }
}
