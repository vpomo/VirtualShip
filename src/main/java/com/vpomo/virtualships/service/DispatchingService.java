package com.vpomo.virtualships.service;

/**
 * Created by Pomogalov on 25.03.2016.
 */
public interface DispatchingService {
    public static final int MAX_NUMBER_SHIPS = 5;
    void startMovingShips(int numberShipTypeA, int numberShipTypeD, int numberShipTypeP) throws InterruptedException;
    void stopMovingShip();

}
