package HW4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HW4.model.Contract;

public interface ContractJpaRepository extends JpaRepository<Contract, Integer> {

}