package com.MowItNow.mower.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Coordonnees {
    private int x;
    private int y;


    /**
     * vérifier si les coordonnées de la tondeuse après mouvement sont en dehors de celles
     * de la pelouse
     *
     * @param pCoordonnees
     * @return true si les coordonnées de la tondeuse sont à l'intérieur de la pelouse
     */
    public boolean isHorsCoordonnesMax(Coordonnees pCoordonnees) {
        return pCoordonnees.getX() >= 0
                && pCoordonnees.getY() >= 0
                && pCoordonnees.getX() <= this.x
                && pCoordonnees.getY() <= this.y;
    }
}
