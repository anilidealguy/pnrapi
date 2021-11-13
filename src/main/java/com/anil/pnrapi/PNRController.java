package com.anil.pnrapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/PnrController")
public class PNRController {

    @Autowired
    PNRRepository repository;

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/CreatePNR/")
    public PNRResponseVO createPNR(@RequestBody PNRRequestVO pnrRequestVO) {

        PNREntity pnrEntityObject = new PNREntity(pnrRequestVO.getPlanes(), pnrRequestVO.getApplicationId()
        , pnrRequestVO.getScenarioCode(), pnrRequestVO.getNoOfPnr(), pnrRequestVO.getFId());

        PNREntity savedResult = repository.save(pnrEntityObject);
        return new PNRResponseVO(savedResult.getFlights(), savedResult.getApplicationId(), savedResult.getScenarioCode());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPNR/{id}")
    public PNREntity getPNR(@PathVariable Integer id) {
        repository.findAll().forEach(System.out::println);
        return repository.findById(id).get();
    }
}
