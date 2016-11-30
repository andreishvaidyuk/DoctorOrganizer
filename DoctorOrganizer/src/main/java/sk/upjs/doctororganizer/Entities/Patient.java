package sk.upjs.doctororganizer.Entities;

import java.util.Date;

public class Patient {
    private int id;
    private String name;
    private String surname;
    private String adress;
    private Date date_of_birth;
    private String id_number;
    private String insured_at;
    private String phone_number;
    private String email; 
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getInsured_at() {
        return insured_at;
    }

    public void setInsured_at(String insured_at) {
        this.insured_at = insured_at;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", adress=" + adress + ", date_of_birth=" + date_of_birth + ", id_number=" + id_number + ", insured_at=" + insured_at + ", phone_number=" + phone_number + ", email=" + email + ", password=" + password + '}';
    }
    
    
}
