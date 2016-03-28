package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Square;

/**
 * Created by Pomogalov on 25.03.2016.
 */
public class DispatchingServiceImpl implements DispatchingService {
    private Square square;
    private boolean arraySuspendFlagShipA[];
    private boolean arraySuspendFlagShipD[];
    private boolean arraySuspendFlagShipP[];

    public DispatchingServiceImpl() {
        this.square = new Square();
        this.arraySuspendFlagShipA = new boolean[MAX_NUMBER_SHIPS];
        this.arraySuspendFlagShipD = new boolean[MAX_NUMBER_SHIPS];
        this.arraySuspendFlagShipP = new boolean[MAX_NUMBER_SHIPS];
        for (int n = 0; n < MAX_NUMBER_SHIPS; n++) {
            this.arraySuspendFlagShipA[n] = true;
            this.arraySuspendFlagShipD[n] = true;
            this.arraySuspendFlagShipP[n] = true;
        }
    }

    public void startMovingShips(int numberShipTypeA, int numberShipTypeD, int numberShipTypeP) {

            if (numberShipTypeA > 0) {
                for (int n = numberShipTypeA; n > 0; n--) {
                    this.arraySuspendFlagShipA[n] = false;

                }
            }

    }

    public void stopMovingShip() {
        for (int n = 0; n < MAX_NUMBER_SHIPS; n++) {
            this.arraySuspendFlagShipA[n] = true;
            this.arraySuspendFlagShipD[n] = true;
            this.arraySuspendFlagShipP[n] = true;
        }

    }
}
