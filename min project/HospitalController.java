package com.example.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/test/")

public class HospitalController {

    @Autowired

    private HospitalService hospitalService;

    @RequestMapping(value = "/hospitals/{id}", method = RequestMethod.GET)

    public @ResponseBody Hospital getHospital(@PathVariable("id") int id) throws Exception {

        Hospital hospital = this.hospitalService.getHospital(id);

        return hospital;

    }

    @RequestMapping(value = "/hospitals", method = RequestMethod.GET)

    public @ResponseBody List<Hospital> getAllHospitals() throws Exception {

        return this.hospitalService.getAllHospitals();

    }

}
@Service

public class HospitalService {

    private List<Hospital> hospitalList=new ArrayList<>(Arrays.asList(

            new Hospital(1001, "Apollo Hospital", "Chennai", 3.8),


            new Hospital(1002,"Global Hospital","Chennai", 3.5),


            new Hospital(1003,"VCare Hospital","Bangalore", 3)));

    public List<Hospital> getAllHospitals(){

        List<Hospital> hospitalList= new ArrayList<Hospital>();

        return hospitalList;

    }

    public Hospital getHospital(int id){

        return hospitalList.stream().filter(c->c.getId()==(id)).findFirst().get();

    }

}

