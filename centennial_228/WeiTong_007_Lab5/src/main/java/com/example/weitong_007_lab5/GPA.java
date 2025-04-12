package com.example.weitong_007_lab5;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class GPA {
    public SimpleStringProperty studentID = new SimpleStringProperty();
    public SimpleDoubleProperty termOne = new SimpleDoubleProperty();
    public SimpleDoubleProperty termTwo = new SimpleDoubleProperty();
    public SimpleDoubleProperty termThree = new SimpleDoubleProperty();
    public SimpleDoubleProperty termCGPA = new SimpleDoubleProperty();

    public GPA(String studentID,double termOne,double termTwo,double termThree){
        this.studentID.set(studentID);
        this.termOne.set(termOne);
        this.termTwo.set(termTwo);
        this.termThree.set(termThree);
        this.termCGPA.set((termOne+termTwo+termThree)/3.0);
    }

    public GPA(String studentID,double termOne,double termTwo,double termThree,double termCGPA){
        this.studentID.set(studentID);
        this.termOne.set(termOne);
        this.termTwo.set(termTwo);
        this.termThree.set(termThree);
        this.termCGPA.set(termCGPA);
    }

    public double getTermCGPA() {
        return termCGPA.get();
    }

    public SimpleDoubleProperty termCGPAProperty() {
        return termCGPA;
    }

    public double getTermThree() {
        return termThree.get();
    }

    public SimpleDoubleProperty termThreeProperty() {
        return termThree;
    }

    public double getTermTwo() {
        return termTwo.get();
    }

    public SimpleDoubleProperty termTwoProperty() {
        return termTwo;
    }

    public double getTermOne() {
        return termOne.get();
    }

    public SimpleDoubleProperty termOneProperty() {
        return termOne;
    }

    public String getStudentID() {
        return studentID.get();
    }

    public SimpleStringProperty studentIDProperty() {
        return studentID;
    }
}
