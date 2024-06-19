package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {

    // After question mark if you are seeing any key value pair. Then we call those key value pair
    // as query parameter or request parameter

    // User can see all hospital details
    // It will be nothing but object of hospital class
    // user can add new hospital into the system
    // So we want to create a URL such that when user will hit that url users will be able to see all Hospital details
    // Post Method
    HospitalService hospitalService = new HospitalService();
    @GetMapping("/api/hospitals")
    public List<Hospital> getAllHospital(){
        // To get list of all hospital we need to write logic;
        // logic needs to be written in service layer
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return hospitals;
    }
    @PostMapping("/api/addhospital")
    public String addHospital(@RequestBody Hospital hospital){
        String id = hospital.id + "";
        hospitalService.addHospital(id, hospital);
        return "Hospital object got added";
        // Service layer -> we are calling service layer to add this hospital object to our system
    }

    // Develop one endpoint which when client will hit then client will be able to see specific hospital details

    @GetMapping("/api/hospital")
    public Hospital getSpecificHospitalDetail(@RequestParam int hospitalId){
        // controller will ask service to provide hospital detail on the basis of hospiatalID
        return hospitalService.getHospitalDetailById(hospitalId);
    }

    @GetMapping("/api/hospital/{hospitalId}/detail")
    public Hospital getSpecificHospitalDetailByUsingPathVariable(@PathVariable int hospitalId){
        return hospitalService.getHospitalDetailById(hospitalId);
    }







    // @RestController : This is a annotation that will help springboot to understand that this class is a controller
}
