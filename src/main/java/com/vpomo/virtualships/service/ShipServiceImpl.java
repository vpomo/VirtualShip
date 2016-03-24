package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Ship;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.vpomo.virtualships.model.Ship.MAX_SIZE_SQUARE;

/**
 * Created by Pomogalov on 22.03.2016.
 */

@Service
public class ShipServiceImpl implements ShipService{
    public void nextMove(Ship ship) {
        int currentCoordinateX, nextCoordinateX;
        int currentCoordinateY, nextCoordinateY;
        String typeShip;
        int moveShip;
        Random nextMove = new Random();

        currentCoordinateX = ship.getCoordinateX();
        currentCoordinateY = ship.getCoordinateY();
        typeShip = ship.getKind();

        if (typeShip.equals("typeA")) {
            moveShip = nextMove.nextInt(8);
        } else {
            moveShip = nextMove.nextInt(4);
        }

        nextCoordinateX = currentCoordinateX + nextMoveX(typeShip, moveShip, currentCoordinateX);
        nextCoordinateY = currentCoordinateY + nextMoveY(typeShip, moveShip, currentCoordinateY);

        ship.setCoordinateX(nextCoordinateX);
        ship.setCoordinateY(nextCoordinateY);

    }

/**
 * moveShip - variants of the ship movements for typeA
 * 0 - Up + Left; 1 - Up + Middle; 2- //Up + Right
 * 3 - Horizontally + Right;
 * 4 - Down + Right; 5 - Down + Middle; 6 - Down + Left;
 * 7 - Horizontally + Left;
 *
 * moveShip - variants of the ship movements for typeD
 * 0 - Up + Left; 1- //Up + Right
 * 2 - Down + Right; 3 - Down + Left;
 *
 * moveShip - variants of the ship movements for typeP
 * 0 - Up + Middle;
 * 1 - Horizontally + Right;
 * 2 - Down + Middle;
 * 3 - Horizontally + Left;
 *
 */
    public int nextMoveX(String typeShip, int moveShip, int currentX) {
        int moveX = 0;
        if (typeShip.equals("typeA")) {
            switch (moveShip) {
                case 0, 6, 7:
                    if (currentX == 0){
                        moveX = 1;
                    } else {
                        moveX = -1;
                    }
                    break;
                case 1, 5:
                    moveX = 0;
                    break;
                case 2, 3, 4:
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
            switch (moveShip) {
                case 0, 3:
                    if (currentX == 0){
                        moveX = 1;
                    } else {
                        moveX = -1;
                    }
                    break;
                case 1, 2:
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
            switch (moveShip) {
                case 0, 2:
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

    public int nextMoveY(String typeShip, int moveShip, int currentY) {
        int moveY = 0;
        if (typeShip.equals("typeA")) {
            switch (moveShip) {
                case 0, 1, 2:
                    if (currentY == 0){
                        moveY = 1;
                    } else {
                        moveY = -1;
                    }
                    break;
                case 3, 7:
                    moveY = 0;
                    break;
                case 4, 5, 6:
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
            switch (moveShip) {
                case 0, 1:
                    if (currentY == 0){
                        moveY = 1;
                    } else {
                        moveY = -1;
                    }
                    break;
                case 2, 3:
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
            switch (moveShip) {
                case 1, 2:
                    moveY = 0;
                    break;
                case 3:
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
