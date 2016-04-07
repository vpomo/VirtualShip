package com.vpomo.virtualships.web;

import com.vpomo.virtualships.model.CellSquare;
import com.vpomo.virtualships.service.ControlValues;
import com.vpomo.virtualships.service.DispatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Pomogalov on 04.04.2016.
 */
@Controller
public class DrawSquare {
    private final DispatchingService dispatchingService;
    public ControlValues controlValues;

    @Autowired
    public DrawSquare(DispatchingService dispatchingService) {
        this.dispatchingService = dispatchingService;
    }

    //public int
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) throws InterruptedException {
        dispatchingService.startMovingShips(1,1,1);
        return "/index";
    }

    @RequestMapping(value = "/restful/getall", method = RequestMethod.GET)
    public @ResponseBody ArrayList<CellSquare> getSquare() {
        return dispatchingService.getSquareToJSON();
    }

}
