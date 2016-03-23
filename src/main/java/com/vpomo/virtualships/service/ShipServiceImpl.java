package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Ship;

import java.util.Random;

/**
 * Created by Pomogalov on 22.03.2016.
 */
public class ShipServiceImpl implements ShipService{
    public void nextMove(Ship ship) {
        int coordinateX, coordinateY;
        Random rand = new Random();

        coordinateX = ship.getCoordinateX();
        coordinateY = ship.getCoordinateY();
        coordinateX = coordinateX + rand.nextInt(3);
        coordinateY = coordinateY + rand.nextInt(3);

        ship.setCoordinateX(coordinateX);
        ship.setCoordinateY(coordinateY);

    }
}
