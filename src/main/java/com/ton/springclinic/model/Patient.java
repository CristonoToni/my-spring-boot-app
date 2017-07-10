package com.ton.springclinic.model;

import javax.persistence.*;

/**
 * Created by Ton-SSD on 7/10/2017.
 *
 * Table Patients will be created automatically if unavailable in Database(dbname is
 * defined in application.properties)
 */
@Entity //1instance = 1row of DB
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int patientId;
    private String firstName;
    private String lastName;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
