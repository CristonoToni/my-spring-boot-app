package com.ton.springclinic.webcontroller;

import com.ton.springclinic.model.Patient;
import com.ton.springclinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ton-SSD on 7/12/2017.
 */
@Controller
@Transactional(readOnly = false,rollbackFor = Exception.class
    ,isolation = Isolation.READ_COMMITTED)
public class PatientWebController {

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(value = "/patient/create",method = RequestMethod.GET)
    public String create(){
        return "patient/create"; //path/file in templates folder
    }

    //input from .html and store patient to db.
    @RequestMapping(value = "/patient/create",method = RequestMethod.POST)
    public String create(Patient patient){
        patientRepository.addPatient(patient);
        return "patient/doneCreate"; //show done page after user fill form and create patient.
    }
}
