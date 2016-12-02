package sk.upjs.doctororganizer.Entities;

import java.math.BigInteger;

public class DoctorOffice {
    private Long id;
    private String city;
    private String street;
    private int house_number;
    private String hospital;
    private String specialization;
    private String opening_hours;
    private BigInteger phone_number;
    private Long id_doctor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public BigInteger getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(BigInteger phone_number) {
        this.phone_number = phone_number;
    }

    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }

    @Override
    public String toString() {
        return "DoctorOffice{" + "id=" + id + ", city=" + city + ", street=" + street + ", house_number=" + house_number + ", hospital=" + hospital + ", specialization=" + specialization + ", opening_hours=" + opening_hours + ", phone_number=" + phone_number + ", id_doctor=" + id_doctor + '}';
    }
    
    
}
