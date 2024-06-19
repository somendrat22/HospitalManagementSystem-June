package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.model.Patient;
import com.hospitalmanagementsystem.Hospital.Management.System.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    PatientService patientService = new PatientService();

    // When a particular patient will try to register itself then that particular patient will
    // get saved into our system and at the same time that particular patient will get associated
    // with hospital which is having maximum beds
    // So when we are hitting this end point we are expecting it will return hospital
    // object in which patient got registerd

    @PostMapping("/api/patient/register")
    public Hospital registerPatient(@RequestBody Patient patient){
        // patient controller will call patient service
        Hospital hospital = patientService.registerPatient(patient);
        return hospital;
    }
}
