package com.example.demo.controller;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import com.example.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/")
    public String index(Model model) {
        getAllProducts(model);
        return "index.jsp";
    }

    @GetMapping("/buy")
    public String updateStock(@RequestParam int quantity, @RequestParam int product_id, Model model) {
        Product product = purchaseService.findById(product_id);
        try {
            product.setStock(product.getStock() - quantity);
            purchaseService.save(product);
        } catch (Exception e) {
            System.out.println(e);
        }
        getAllProducts(model);
        return "index.jsp";
    }

    private void getAllProducts(Model model) {
        List<Product> products = productDao.findAll();
        model.addAttribute("products", products);
    }

}
