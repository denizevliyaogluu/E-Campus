package com.example.springsecurity.service;

import com.example.springsecurity.models.Contract;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.services.ContractService;
import com.example.springsecurity.services.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContractServiceTest {

    @Autowired
    private ContractService contractService;

    @Test
    void addContract() {

        Contract ct = new Contract();
        ct.setContractName("Contract1");
        contractService.addContract(ct);

    }
}
