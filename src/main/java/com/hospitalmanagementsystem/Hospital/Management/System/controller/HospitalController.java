package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.service.HospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {

    // User can see all hospital details
    // It will be nothing but object of hospital class
    // user can add new hospital into the system
    // So we want to create a URL such that when user will hit that url users will be able to see all Hospital details
    HospitalService hospitalService = new HospitalService();
    @GetMapping("/api/hospitals")
    public List<Hospital> getAllHospital(){
        // To get list of all hospital we need to write logic;
        // logic needs to be written in service layer
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return hospitals;
    }
    int count  = 0;
    @PostMapping("/api/addhospital")
    public String addHospital(){
        Hospital hospital = new Hospital();
        hospital.name = "Som";
        hospital.id = count;
        String id = count + "";
        count++;
        hospitalService.addHospital(id, hospital);
        return "Hospital object got added";
        // Service layer -> we are calling service layer to add this hospital object to our system
    }


    @GetMapping("/api/sayhello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/api/saybye")
    public String sayBye(){
        return "Bye";
    }

    @PostMapping("/api/createpost")
    public String createPost(){
        return "Create Post";
    }

    // @RestController : This is a annotation that will help springboot to understand that this class is a controller
}
