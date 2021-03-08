package HW4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HW4.model.RevenueRecognition;

public interface RevenueRecognitionJpaRepository extends JpaRepository<RevenueRecognition, Integer> {

}