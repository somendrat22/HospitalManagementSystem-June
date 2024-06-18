package com.hospitalmanagementsystem.Hospital.Management.System.service;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HospitalService {

    // To make spring understand this is a service class we use @Service annotation over it.
    // In service class we write all our logics
    // As hospital service needs hospital repository that's why we have created one instance or object of hospital repository inside hospital service
    // We have injected the dependency of hospital repository inside hospital service;
    HospitalRepository hospitalRepository = new HospitalRepository();
    public List<Hospital> getAllHospitals(){
        // You need hospitals data
        // Service layer need to call repository layer
        HashMap<String, Hospital> hospitalDB  = hospitalRepository.getAllHospital();
        List<Hospital> allHospitals = new ArrayList<>();
        for(String hospitalID : hospitalDB.keySet()){
            Hospital hospital = hospitalDB.get(hospitalID);
            allHospitals.add(hospital);
        }
        return allHospitals;
    }

    public void addHospital(String id, Hospital hospital){
        // Service layer want to save this object in the system
        // Service layer will call repository layer to save this object
        hospitalRepository.addHospital(id, hospital);
    }

}
