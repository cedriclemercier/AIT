package HW4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HW4.model.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
}


