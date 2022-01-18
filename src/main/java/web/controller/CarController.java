package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.Service;

@Controller
public class CarController {

    private final Service cars;

    @Autowired
    public CarController(Service cars) {
        this.cars = cars;
    }

    @GetMapping(value = "/cars")
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String getCars(@RequestParam(value = "count", required = false) String count, ModelMap modelMap) {
        modelMap.addAttribute("msg", cars.select(count));
        return "cars";
    }
}
