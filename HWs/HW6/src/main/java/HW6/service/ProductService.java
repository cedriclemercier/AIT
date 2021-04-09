package HW6.service;

import HW6.model.Product;
import HW6.repo.ProductRepo;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public void createMockProduct() {
        // creating and persisting a product
        Product pro = new Product();
        pro.setName("Microsoft Word");
        pro.setPrice(499L);
        repo.save(pro);
    }

    @Transactional
    @Async
    public void readLockTransaction() throws InterruptedException {
        System.out.println(LocalTime.now() + " <-- Reading Product Entity -->");

        Product product1 = null;
        try {
            product1 = repo.findProductForRead(1L);
        } catch (Exception e) {
            System.err.println(LocalTime.now() + " -- Got exception whole acquiring the read lock:\n " + e + " --");
            return;
        }

        System.out.println(LocalTime.now() + " -- Acquired the read lock --");

        System.out.println(LocalTime.now() + " -- Read product: " + product1 + " --");

        Thread.sleep(2000);
    }

    @Transactional
    @Async
    public void writeLockTransaction() throws InterruptedException {
        Thread.sleep(100);

        System.out.println(LocalTime.now() + " <-- Writing Product entity -->");

        Product product2 = null;
        try {
            product2 = repo.findProductForWrite(1L);
        } catch (Exception e) {
            System.err.println(LocalTime.now() + " -- Got exception while " + "acquiring the write lock:\n " + e + " --");
            return;
        }

        System.out.println(LocalTime.now() + " -- Acquired write lock --");
        product2.setName("New name");
        repo.save(product2);

        System.out.println(LocalTime.now() + " -- User 2 updated product: " + product2 + " --");
    }

}
