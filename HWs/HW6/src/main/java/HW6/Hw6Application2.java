package HW6;

import HW6.model.Product;
import HW6.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Hw6Application2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Hw6Application2.class, args);
        ProductService ps = applicationContext.getBean(ProductService.class);

        ps.createMockProduct();
        ps.writeLockTransaction();
        ps.readLockTransaction();
    }
}
