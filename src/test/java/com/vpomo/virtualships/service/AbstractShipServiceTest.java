package com.vpomo.virtualships.service;

import com.vpomo.virtualships.model.Ship;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.vpomo.virtualships.model.Ship.MAX_SIZE_SQUARE;

/**
 * Created by Pomogalov on 24.03.2016.
 */

public abstract class AbstractShipServiceTest {
    @Autowired
    protected ShipService shipService;

    @Before
    public void shouldShipService() {

        System.out.println(" ===== Before test passed  ==== ");
    }

    @Test
    public void testNextMove() {
        System.out.println(" ===== test nextMove() started  ==== ");
        System.out.println("MAX_SIZE_SQUARE = " + MAX_SIZE_SQUARE);
        Ship shipTest = new Ship("typeA");
        System.out.println("coordinateX1 = " + shipTest.getCoordinateX());
        System.out.println("coordinateY1 = " + shipTest.getCoordinateY());
        this.shipService.nextMove(shipTest);
        System.out.println("coordinateX2 = " + shipTest.getCoordinateX());
        System.out.println("coordinateY2 = " + shipTest.getCoordinateY());
        System.out.println(" ===== test nextMove() passed  ==== ");
    }

}
