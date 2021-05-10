package Main.Service.controller;

import Main.Service.dao.RegistrationDao;
import Main.Service.model.Registration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private RestTemplate template;

    @Autowired
    private RegistrationDao dao;

    @GetMapping("/")
    public String home() {
        return "index.jsp";
    }

    @GetMapping("/eligibility")
    public ResponseEntity<String> checkEligibility(@RequestParam int citizen_id) {
        String url = "http://CITIZEN-SERVICE/citizen-service/get-citizen/"+citizen_id;
        ResponseEntity<String> request = template.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(request.getBody());
            JsonNode cid = root.path("occupation_id");
            String firstName = root.path("name").path("firstName").toString();
            String lastName = root.path("name").path("lastName").toString();
            String bank_account_no = root.path("bank_account_no").toString();


            String occupation_id = cid.toString();

            String eligible = getEligibility(occupation_id);

            String res;
            if (!eligible.equals("true")) {
                res = firstName + " " + lastName +" has successfully applied for a grant at the Kingdom of FarFarAway.  " +
                        "Money of 1,000 USD will be transferred to " + bank_account_no + " within 72 hours";
                register(citizen_id);
            } else {
                res = "You are not eligible";
            }
            return new ResponseEntity<String>(res, HttpStatus.OK);

        } catch (Exception e) {
            String res = "Error";
            return new ResponseEntity<String>(res, HttpStatus.BAD_REQUEST);
        }
    }

    public String getEligibility(String occupation_id) {
        String url =  "http://ELIGIBILITY-SERVICE/eligibility/check/"+occupation_id;
        return template.getForObject(url, String.class);
    }

    public String register(int citizen_id) {
        Registration registration = new Registration();
        registration.setCitizen_id(citizen_id);
        registration.setRegistered(true);
        dao.save(registration);
        return "Successfully registered.";
    }

}
