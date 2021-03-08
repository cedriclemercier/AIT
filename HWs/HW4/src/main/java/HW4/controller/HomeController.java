package HW4.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import HW4.model.Contract;
import HW4.model.Product;
import HW4.repository.ContractJpaRepository;
import HW4.repository.ProductJpaRepository;
import HW4.service.RevenueRecognitionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    RevenueRecognitionFacade script;

    @Autowired
    ProductJpaRepository productRepo;

    @Autowired
    ContractJpaRepository contractRepo;

    @RequestMapping(path = "/")
    public ModelAndView home() {
        List<Product> products = productRepo.findAll();

        Map<String, Object> allObjectsMap = new HashMap<String, Object>();
        allObjectsMap.put("products", products);

        ModelAndView mv = new ModelAndView();
        mv.addAllObjects(allObjectsMap);

        mv.setViewName("home.jsp");
        return mv;
    }

    @RequestMapping(path = "/check")
    public ModelAndView calculateRevenueRecognition() {
        List<Contract> contracts = contractRepo.findAll();

        System.out.println(contracts.toString());

        Map<String, Object> allObjectsMap = new HashMap<String, Object>();
        allObjectsMap.put("contracts", contracts);

        ModelAndView mv = new ModelAndView();
        mv.addAllObjects(allObjectsMap);

        mv.setViewName("checkrr.jsp");
        return mv;
    }



}