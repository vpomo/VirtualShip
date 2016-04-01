package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Ship;
import com.vpomo.virtualships.model.Square;

import java.util.Random;

import static com.vpomo.virtualships.service.ControlValues.MAX_SIZE_SQUARE;


/**
 * Created by Pomogalov on 22.03.2016.
 */

//@Service
public class ShipServiceImpl implements ShipService {
    private Square square;

    public ShipServiceImpl (Square square) {
        this.square = square;
    }

    public synchronized void nextMove(Ship ship, Square square) {
        int currentCoordinateX, nextCoordinateX;
        int currentCoordinateY, nextCoordinateY;
        String typeShip;
        String color = "ZZ";
        int directionMoveShip = 10;
        Random nextMove = new Random();

        currentCoordinateX = ship.getCoordinateX();
        currentCoordinateY = ship.getCoordinateY();
        typeShip = ship.getTypeShip();

        //System.out.println("currentX= " + currentCoordinateX + " currentY= " + currentCoordinateY);
        switch (typeShip) {
            case "typeA":
                directionMoveShip = nextMove.nextInt(8);
                color = "aa";
                break;
            case "typeD":
                directionMoveShip = nextMove.nextInt(4);
                color = "dd";
                break;
            case "typeP":
                directionMoveShip = nextMove.nextInt(4);
                color = "pp";
                break;
            default:
                break;
        }

        nextCoordinateX = currentCoordinateX + nextMoveX(typeShip, directionMoveShip, currentCoordinateX);
        nextCoordinateY = currentCoordinateY + nextMoveY(typeShip, directionMoveShip, currentCoordinateY);

        ship.setCoordinateX(nextCoordinateX);
        ship.setCoordinateY(nextCoordinateY);

        square.setColorCell(nextCoordinateX,nextCoordinateY, color);
        square.setNumberTimesCell(nextCoordinateX,nextCoordinateY,5);

        //System.out.println("nextX= " + nextCoordinateX + " nextY= " + nextCoordinateY);

    }

/**
 * directionMovement - variants of the ship movements for typeA
 * 0 - Up + Left; 1 - Up + Middle; 2- //Up + Right
 * 3 - Horizontally + Right;
 * 4 - Down + Right; 5 - Down + Middle; 6 - Down + Left;
 * 7 - Horizontally + Left;
 *
 * directionMovement - variants of the ship movements for typeD
 * 0 - Up + Left; 1- //Up + Right
 * 2 - Down + Right; 3 - Down + Left;
 *
 * directionMovement - variants of the ship movements for typeP
 * 0 - Up + Middle;
 * 1 - Horizontally + Right;
 * 2 - Down + Middle;
 * 3 - Horizontally + Left;
 *
 */
    public int nextMoveX(String typeShip, int directionMovement, int currentX) {
        int moveX = 0;
        if (typeShip.equals("typeA")) {
            switch (directionMovement) {
                case 0:
                case 6:
                case 7:
                    if (currentX == 0){
                        moveX = 1;
                    } else {
                        moveX = -1;
                    }
                    break;
                case 1:
                case 5:
                    moveX = 0;
                    break;
                case 2:
                case 3:
                case 4:
                    if (currentX == (MAX_SIZE_SQUARE-1)){
                        moveX = -1;
                    } else {
                        moveX = 1;
                    }
                    break;
                default:
                    break;
            }
        }
        if (typeShip.equals("typeD")) {
            switch (directionMovement) {
                case 0:
                case 3:
                    if (currentX == 0){
                        moveX = 1;
                    } else {
                        moveX = -1;
                    }
                    break;
                case 1:
                case 2:
                    if (currentX == (MAX_SIZE_SQUARE-1)){
                        moveX = -1;
                    } else {
                        moveX = 1;
                    }
                    break;
                default:
                    break;
            }
        }
        if (typeShip.equals("typeP")) {
            switch (directionMovement) {
                case 0:
                case 2:
                    moveX = 0;
                    break;
                case 1:
                    if (currentX == (MAX_SIZE_SQUARE-1)){
                        moveX = -1;
                    } else {
                        moveX = 1;
                    }
                    break;
                case 3:
                    if (currentX == 0){
                        moveX = 1;
                    } else {
                        moveX = -1;
                    }
                    break;
                default:
                    break;
            }
        }
        return moveX;
    }

    public int nextMoveY(String typeShip, int directionMovement, int currentY) {
        int moveY = 0;
        if (typeShip.equals("typeA")) {
            switch (directionMovement) {
                case 0:
                case 1:
                case 2:
                    if (currentY == 0){
                        moveY = 1;
                    } else {
                        moveY = -1;
                    }
                    break;
                case 3:
                case 7:
                    moveY = 0;
                    break;
                case 4:
                case 5:
                case 6:
                    if (currentY == (MAX_SIZE_SQUARE-1)){
                        moveY = -1;
                    } else {
                        moveY = 1;
                    }
                    break;
                default:
                    break;
            }
        }
        if (typeShip.equals("typeD")) {
            switch (directionMovement) {
                case 0:
                case 1:
                    if (currentY == 0){
                        moveY = 1;
                    } else {
                        moveY = -1;
                    }
                    break;
                case 2:
                case 3:
                    if (currentY == (MAX_SIZE_SQUARE-1)){
                        moveY = -1;
                    } else {
                        moveY = 1;
                    }
                    break;
                default:
                    break;
            }
        }
        if (typeShip.equals("typeP")) {
            switch (directionMovement) {
                case 1:
                case 3:
                    moveY = 0;
                    break;
                case 2:
                    if (currentY == (MAX_SIZE_SQUARE-1)){
                        moveY = -1;
                    } else {
                        moveY = 1;
                    }
                    break;
                case 0:
                    if (currentY == 0){
                        moveY = 1;
                    } else {
                        moveY = -1;
                    }
                    break;
                default:
                    break;
            }
        }
        return moveY;
    }

}
