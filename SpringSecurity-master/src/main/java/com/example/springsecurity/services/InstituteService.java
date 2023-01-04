package com.example.springsecurity.services;
import com.example.springsecurity.models.Faculty;
import com.example.springsecurity.models.Institute;
import com.example.springsecurity.models.Student;
import com.example.springsecurity.repos.InstituteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("instituteService")
@Slf4j
@RequiredArgsConstructor
public class InstituteService {
    private final InstituteRepository instituteRepository;

    public void addInstitute(Institute institute){
        instituteRepository.save(institute);
    }
    public List<Institute> getInstituteByUserId(Long id){
        return instituteRepository.findAllByUserId(id);
    }
    public List<Institute> getAll(){
        return instituteRepository.findAll();
    }

    public void deleteInstitute(Long id) {
        instituteRepository.deleteById(id);
    }

    public Institute getInstituteById(Long id){
        return instituteRepository.findById(id).get();
    }


}
