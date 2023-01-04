package com.example.springsecurity.services;

import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.repos.ContractRepository;
import com.example.springsecurity.repos.FacultyRepository;
import com.example.springsecurity.repos.PersonnelRepository;
import com.example.springsecurity.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelService {
    private final UserRepository userRepository;
    private final PersonnelRepository personnelRepository;
    private final ContractRepository contractRepository;
    private final FacultyRepository facultyRepository;

    public PersonnelService(UserRepository userRepository, PersonnelRepository personnelRepository, ContractRepository contractRepository, FacultyRepository facultyRepository) {
        this.userRepository = userRepository;
        this.personnelRepository = personnelRepository;
        this.contractRepository = contractRepository;

        this.facultyRepository = facultyRepository;
    }

    public void addPersonnel(Personnel personnel){
        personnelRepository.save(personnel);
    }

    public List<Personnel> getPersonnelByContractId(Long contractId){
        return personnelRepository.findAllByContractId(contractId);
    }

    public List<Personnel> getAllPersonnel(){

        return personnelRepository.findAll();
    }
    public void deletePersonnel(Long id) {
        personnelRepository.deleteById(id);
    }

    public Personnel getPersonnelById(Long id){
        return personnelRepository.findById(id).get();
    }

    public Personnel addPersonnelByContractId(Long id, Personnel personnel){
        personnel.setContract(contractRepository.findById(id).orElse(null));
        return personnelRepository.save(personnel);
    }



}
