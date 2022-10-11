package com.example.self.UsersClasses;

public class UserStudent {
     String name,guardianMail,yourMail,guardianPhn,dob,gender,class_grade,role,yourPhn;boolean profileComp;
    public UserStudent(){}

    public boolean isProfileComp() {
        return profileComp;
    }

    public void setProfileComp(boolean profileComp) {
        this.profileComp = profileComp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserStudent(String name, String guardianMail, String yourMail, String guardianPhn, String dob, String gender, String class_grade, String role, String yourPhn,boolean profileComp){
        this.name=name;
        this.guardianMail=guardianMail;
        this.yourMail=yourMail;
        this.guardianPhn=guardianPhn;
        this.dob=dob;
        this.gender=gender;
        this.class_grade=class_grade;
        this.role=role;
        this.yourPhn=yourPhn;
        this.profileComp=profileComp;
    }

    public String getGuardianMail() {
        return guardianMail;
    }

    public String getYourPhn() {
        return yourPhn;
    }

    public void setYourPhn(String yourPhn) {
        this.yourPhn = yourPhn;
    }

    public void setGuardianMail(String guardianMail) {
        this.guardianMail = guardianMail;
    }

    public String getYourMail() {
        return yourMail;
    }

    public void setYourMail(String yourMail) {
        this.yourMail = yourMail;
    }

    public String getGuardianPhn() {
        return guardianPhn;
    }

    public void setGuardianPhn(String guardianPhn) {
        this.guardianPhn = guardianPhn;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClass_grade() {
        return class_grade;
    }

    public void setClass_grade(String class_grade) {
        this.class_grade = class_grade;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
