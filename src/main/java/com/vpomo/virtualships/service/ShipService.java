package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Ship;

/**
 * Created by Pomogalov on 22.03.2016.
 */
public interface ShipService {
    void nextMove(Ship ship);
    int nextMoveX(String typeShip, int directionMovement, int currentX);
    int nextMoveY(String typeShip, int directionMovement, int currentY);
}
