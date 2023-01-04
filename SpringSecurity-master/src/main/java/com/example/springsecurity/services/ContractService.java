package com.example.springsecurity.services;

import com.example.springsecurity.models.Contract;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.repos.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }
    public List<Contract> getAllContract() {
        return contractRepository.findAll();
    }
    public Contract addContract(Contract contract) {
        contractRepository.save(contract);
        return contract;
    }
}
