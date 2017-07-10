package com.ton.springclinic.repository;

import com.ton.springclinic.model.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Ton-SSD on 7/10/2017.
 */
@Repository     //just tell this class works as a repository
public class PatientRepository {

    @PersistenceContext //assign entityManager automatically
    EntityManager entityManager;    //JPA Hibernate class which handle entity classes.

    public Patient getPatient(int patientId){
//        return entityManager.getReference(Patient.class,patientId);
        Patient result = entityManager.getReference(Patient.class,patientId);
        return result;
    }

    public List<Patient> getAllPatients(){
        String sqlQuery = "select p from Patient p";
        Query query = entityManager.createQuery(sqlQuery,Patient.class);
        return query.getResultList();
    }

    public void addPatient(Patient p){
        entityManager.persist(p);
    }

    public void removePatient(Patient p){
        entityManager.remove(p);
    }
}
