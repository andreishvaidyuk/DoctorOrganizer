package sk.upjs.doctororganizer.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Term {

    private Long id;
    private Long id_patient;
    private String patient;
    private Long id_doctor_office;
    private LocalDateTime date;
    private String time;
    private String reason;
    private String term_condition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Long getId_doctor_office() {
        return id_doctor_office;
    }

    public void setId_doctor_office(Long id_doctor_office) {
        this.id_doctor_office = id_doctor_office;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTerm_condition() {
        return term_condition;
    }

    public void setTerm_condition(String term_condition) {
        this.term_condition = term_condition;
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + time + " " + patient + " " + reason + " Stav termínu: " + term_condition;
    }
}
