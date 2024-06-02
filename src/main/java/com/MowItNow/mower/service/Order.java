package com.MowItNow.mower.service;

import com.MowItNow.mower.entities.Coordonnees;
import com.MowItNow.mower.entities.Mower;
import com.MowItNow.mower.enumeration.Orientation;
import com.MowItNow.mower.exception.ExceptionTondeuse;
import com.MowItNow.mower.utils.constants;

public class Order {
    /**
     * faire avancer la tondeuse
     * @param mower : position initiale de la tondeuse
     * @param coordonnesMax : coordonnees de la pelouse - coin superieur droit de la pelouse
     * @return coordonnees : nouvelles coordonnees de la tondeuse
     * @throws ExceptionTondeuse
     */
    public static Coordonnees avancer(Mower mower, Coordonnees coordonnesMax) throws ExceptionTondeuse{
        Coordonnees coordonneesSuivantes = null;
        int x, y;
        switch (mower.getOrientation()) {
            case NORTH:
                x = mower.getCoordonnees().getX();
                y = mower.getCoordonnees().getY() + 1;
                break;
            case EAST:
                x = mower.getCoordonnees().getX() + 1;
                y = mower.getCoordonnees().getY();
                break;
            case SOUTH:
                x = mower.getCoordonnees().getX();
                y = mower.getCoordonnees().getY() - 1;
                break;
            case WEST:
                x = mower.getCoordonnees().getX() - 1;
                y = mower.getCoordonnees().getY();
                break;
            default:
                throw new ExceptionTondeuse(constants.POSITION_INCORRECTE);
        }
        coordonneesSuivantes = new Coordonnees(x, y);
        // si les nouvelles coordonnées sont en dehors de la pelouse, on garde
        // la derniere position connue
        if (coordonneesSuivantes != null
                && coordonnesMax.isHorsCoordonnesMax(coordonneesSuivantes)) {
            return coordonneesSuivantes;
        } else {
            return mower.getCoordonnees();
        }
    }

    /**
     * faire pivoter la tondeuse à droite
     * @param orientation : orientation initiale de la tondeuse
     * @return nouvelle orientation
     * @throws ExceptionTondeuse
     */

    public static Orientation pivoterDroite(Orientation orientation) throws ExceptionTondeuse{
        Orientation orientationSuivante = null ;
        switch (orientation){
            case NORTH :
                orientationSuivante =  Orientation.EAST;
                break;
            case EAST :
                orientationSuivante =  Orientation.SOUTH;
                break;
            case SOUTH :
                orientationSuivante =  Orientation.WEST;
                break;
            case WEST :
                orientationSuivante =  Orientation.NORTH;
                break;
            default :
                throw new ExceptionTondeuse(constants.ORIENTATION_INCORRECTE);
        }
        return orientationSuivante;
    }

    /**
     * pivoter la tondeuse à gauche
     * @param orientation : orientation initale de la tondeuse
     * @return nouvelle orientation
     * @throws ExceptionTondeuse
     */
    public static Orientation pivoterGauche(Orientation orientation) throws ExceptionTondeuse{
        Orientation orientationSuivante = null ;
        switch (orientation){
            case NORTH :
                orientationSuivante =  Orientation.WEST;
                break;
            case EAST :
                orientationSuivante =  Orientation.NORTH;
                break;
            case SOUTH :
                orientationSuivante =  Orientation.EAST;
                break;
            case WEST :
                orientationSuivante =  Orientation.SOUTH;
                break;
            default :
                throw new ExceptionTondeuse(constants.ORIENTATION_INCORRECTE);
        }
        return orientationSuivante;
    }

    /**
     * executer une seule instruction ( A, D ou G)
     * @param mower
     * @param instruction
     * @param coordonnesMax
     * @throws ExceptionTondeuse
     */
    public static void executer(Mower mower, com.MowItNow.mower.enumeration.Instruction instruction, Coordonnees coordonnesMax) throws ExceptionTondeuse {

        switch (instruction){
            case AVANCER :
                mower.setCoordonnees(Order.avancer(mower, coordonnesMax));
                break;
            case DROITE :
                mower.setOrientation(Order.pivoterDroite(mower.getOrientation()));
                break;
            case GAUCHE :
                mower.setOrientation(Order.pivoterGauche(mower.getOrientation()));
                break;
            default: throw new ExceptionTondeuse(constants.INSTRUCTION_INCORRECTE);
        }
    }
}
