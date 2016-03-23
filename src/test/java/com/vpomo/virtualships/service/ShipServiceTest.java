package com.vpomo.virtualships.service;
import com.vpomo.virtualships.model.Ship;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

package com.vpomo.virtualships.model.Ship;
        packa com.vpomo.virtualships.model.Ship;

/**
 * Created by Pomogalov on 23.03.2016.
 */
public class ShipServiceTest {
    @Autowired
    protected ShipService shipService;

    public Ship ship1 = new Ship("TypeA");

    @Before
    public void shouldShipService() {

        System.out.println(" ===== Before test passed  ==== ");
    }

    @Test
    public void testNextMove() {
        shipService.nextMove(ship1, 1, 1);
        System.out.println(" ===== test nextMove() passed  ==== ");
    }

}
