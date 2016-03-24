package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Ship;

/**
 * Created by Pomogalov on 22.03.2016.
 */
public interface ShipService {
    void nextMove(Ship ship);
    nextMoveX(String typeShip, int moveShip, int currentX);
    nextMoveY(String typeShip, int moveShip, int currentY);
}
