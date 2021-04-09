package HW6.controller;

import HW6.model.Product;
import HW6.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepo repo;

    @RequestMapping(value = {"/id"}, method = RequestMethod.GET)
    public Product findOne(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping
    public Product put(@RequestBody Product product) {
        return repo.save(product);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return repo.save(product);
    }
}
