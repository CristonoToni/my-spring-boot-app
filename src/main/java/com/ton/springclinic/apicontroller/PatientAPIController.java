package com.ton.springclinic.apicontroller;

import com.ton.springclinic.model.Patient;
import com.ton.springclinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Ton-SSD on 7/10/2017.
 */
@RestController
@RequestMapping("/api/patients")
@Transactional(readOnly = false,
        rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
public class PatientAPIController {
    private Logger logger = Logger.getLogger("PatientAPIController");
    private PatientRepository patientRepository;

    @Autowired  //auto assign value
    public PatientAPIController(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    //POST:ADD
    @RequestMapping(value = "",method = RequestMethod.POST)
    public int addPatient(@RequestBody Patient patient){
        patientRepository.addPatient(patient);
        return patient.getPatientId();
    }

    //GET:Get
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Patient> getAllPatient(){
        return patientRepository.getAllPatients();
    }

    @RequestMapping(value = "/{patientId}",method = RequestMethod.GET)
    public Patient getPatient(@PathVariable int patientId){
        Patient patient = patientRepository.getPatient(patientId);
        logger.info("Get a patient: " + patient.getFirstName() +" "+patient.getLastName());
        return patient;
    }

    //PUT:update
    //value=more path extends from a class's path defined at class header.
    //@PathVariable= get value as a variable using in method
    //@RequestBody= get HTML body as a variable using in method
    @RequestMapping(value = "/{patientId}",method = RequestMethod.PUT)
    public void updatePatient(@PathVariable int patientId,
                              @RequestBody Patient updatedPatient){
        Patient patient = patientRepository.getPatient(patientId);
        //update new value into current one got from its id
        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
    }

    //DELETE:remove
    @RequestMapping(value = "/{patientId}",method = RequestMethod.DELETE)
    public void removePatient(@PathVariable int patientId){
        Patient patient = patientRepository.getPatient(patientId);
        patientRepository.removePatient(patient);
    }

}
