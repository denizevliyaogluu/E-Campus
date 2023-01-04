package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Contract;
import com.example.springsecurity.models.Lesson;
import com.example.springsecurity.services.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contract")
public class ContractController {
    public final ContractService contractService;
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }
    @GetMapping()
    public ResponseEntity<?> getAllContract(){
        return ResponseEntity.ok(contractService.getAllContract());
    }

    @PostMapping()
    public Contract addContract(@RequestBody Contract contract){

        return contractService.addContract(contract);
    }
}
