package EligibilityService.controller;

import EligibilityService.dao.EligibilityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/eligibility")
public class EligibilityController {

    @Autowired
    private EligibilityDao dao;

    @GetMapping("/check/{occupation_id}")
    public Boolean checkEligibility(@PathVariable int occupation_id) {
        Boolean eligible = dao.findByOccupationId(occupation_id);
        return eligible;
    }

}
