package com.vpomo.virtualships.service;

/**
 * Created by Pomogalov on 25.03.2016.
 */
public interface DispatchingService {
    void startMovingShips(int numberShipTypeA, int numberShipTypeD, int numberShipTypeP) throws InterruptedException;
    void stopMovingShip();

}
