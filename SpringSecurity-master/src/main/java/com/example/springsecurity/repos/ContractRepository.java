package com.example.springsecurity.repos;

import com.example.springsecurity.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Long> {

}
