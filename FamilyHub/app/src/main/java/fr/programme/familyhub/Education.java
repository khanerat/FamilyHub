package fr.programme.familyhub;

import java.util.Date;

public class Education {
    private Date date; // Date du rendez-vous
    private String parentName; // Nom du parent
    private String teacherName; // Nom du professeur
    private String subject; // Matière du rendez-vous

    // Constructeur
    public Education(Date date, String parentName, String teacherName, String subject) {
        this.date = date;
        this.parentName = parentName;
        this.teacherName = teacherName;
        this.subject = subject;
    }

    // Méthodes d'accès aux attributs
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
