package sk.upjs.doctororganizer.Entities;

import java.time.LocalDateTime;

public class Term {
    private int id;
    private int id_patient;
    private int id_doctor_office;
    private LocalDateTime date;
    private String reason;
    private String term_condition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_doctor_office() {
        return id_doctor_office;
    }

    public void setId_doctor_office(int id_doctor_office) {
        this.id_doctor_office = id_doctor_office;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
        return "Term{" + "id=" + id + ", id_patient=" + id_patient + ", id_doctor_office=" + id_doctor_office + ", date=" + date + ", reason=" + reason + ", term_condition=" + term_condition + '}';
    }
}
