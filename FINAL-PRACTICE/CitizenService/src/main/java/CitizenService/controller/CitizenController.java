package CitizenService.controller;


import CitizenService.dao.CitizenDao;
import CitizenService.model.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citizen-service")
public class CitizenController {

    @Autowired
    private CitizenDao dao;

    @GetMapping("/get-citizen/{citizen_id}")
    public Citizen getCitizen(@PathVariable int citizen_id) {
        Citizen citizen = dao.findByCitizenId(citizen_id);
        return citizen;
    }

}
