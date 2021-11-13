package com.anil.pnrapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightRepository fr;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    private String createFlight(@RequestBody Flight flight) {
        Flight dbSave = fr.save(flight);
        return "Flight Created Successfully";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    private Flight getFlight(@PathVariable("id") int id) {
        return fr.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    private Flight updateFlight(@PathVariable("id") int id, @RequestBody Flight flight) {
        System.out.println(flight);
        fr.save(flight);
        return fr.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    private void deleteFlight(@PathVariable("id") int id) {
        fr.deleteById(id);
    }
}
