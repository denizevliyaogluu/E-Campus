package com.example.springsecurity;

import com.example.springsecurity.models.*;
import com.example.springsecurity.services.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@Slf4j
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder()
    {
       return  new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, DepartmentService departmentService, InstituteService instituteService,
                          FacultyService facultyService, LessonService lessonService, StudentService studentService,
                          ContractService contractService, PersonnelService personnelService
                         )
    {
        return args->
        {
            userService.saveRole(new UserRole(null,"ROLE_OGRENCI"));
            userService.saveRole(new UserRole(null,"ROLE_OGRENCIISLERI"));
            userService.saveRole(new UserRole(null,"ROLE_INSANKAYNAKLARI"));
            userService.saveRole(new UserRole(null,"ROLE_SISTEMYONETICISI"));
            userService.saveRole(new UserRole(null,"ROLE_FAKULTEYONETIMI"));
            userService.saveRole(new UserRole(null,"ROLE_ENSTITUYONETIMI"));



            userService.saveUser(new User(null,"deniz","devliyaoglu","12345",new ArrayList<>()));
            userService.saveUser(new User(null,"elif","eatesalp","12345",new ArrayList<>()));
            userService.saveUser(new User(null,"yagmur","ymutlu","12345",new ArrayList<>()));
            userService.saveUser(new User(null,"aleyna","asevimli","12345",new ArrayList<>()));
            userService.saveUser(new User(null,"sena","spaydas","12345",new ArrayList<>()));
            userService.saveUser(new User(null,"sila","syurt","12345",new ArrayList<>()));

            userService.addRoleToUser("devliyaoglu","ROLE_OGRENCIISLERI");
            userService.addRoleToUser("eatesalp","ROLE_INSANKAYNAKLARI");
            userService.addRoleToUser("ymutlu","ROLE_SISTEMYONETICISI");
            userService.addRoleToUser("asevimli","ROLE_FAKULTEYONETIMI");
            userService.addRoleToUser("spaydas","ROLE_ENSTITUYONETIMI");
            userService.addRoleToUser("syurt","ROLE_OGRENCI");


            Institute in = new Institute();
            in.setInstituteName("Bilgisayar Bilimleri");
            instituteService.addInstitute(in);

            Faculty fc = new Faculty();
            fc.setFacultyName("Mühendislik ve Doğa Bilimleri Fakültesi");
            facultyService.addFaculty(fc);

            Department dp = new Department();
            dp.setDepartmentName("Bilgisayar Mühendisliği");
            departmentService.addDepartment(dp);
            facultyService.addDepartmentByFacultyId(dp,fc.getId());

            Lesson ls = new Lesson();
            ls.setLessonName("Sunucu Taraflı Programlama");
            lessonService.addLesson(ls);
            departmentService.addLessonByDepartmentId(ls,dp.getId());

            Student st = new Student();
            st.setUsername("Deniz Evliyaoglu");
            lessonService.addStudentByLessonId(st,ls.getId());

            Contract ct = new Contract();
            ct.setContractName("Contract1");
            contractService.addContract(ct);

            Personnel pr = new Personnel();
            pr.setPersonnelType("Öğretmen");
            pr.setContract(ct);
            personnelService.addPersonnel(pr);

        };
    }
}
