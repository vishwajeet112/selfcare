package com.example.self.UsersClasses;

public class UserCouncellor {
    String  yourMail, yourPhn, name,specialisation,gender,certificateUrl,role;boolean isAprooved;

    public UserCouncellor() {
    }

    public UserCouncellor(String yourMail, String yourPhn, String name, String specialisation, String gender, String certificateUrl, String role, boolean isAprooved) {
        this.yourMail = yourMail;
        this.yourPhn = yourPhn;
        this.name = name;
        this.specialisation = specialisation;
        this.gender = gender;
        this.certificateUrl = certificateUrl;
        this.role = role;
        this.isAprooved = isAprooved;
    }

    public String getYourMail() {
        return yourMail;
    }

    public void setYourMail(String yourMail) {
        this.yourMail = yourMail;
    }

    public String getYourPhn() {
        return yourPhn;
    }

    public void setYourPhn(String yourPhn) {
        this.yourPhn = yourPhn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAprooved() {
        return isAprooved;
    }

    public void setAprooved(boolean aprooved) {
        isAprooved = aprooved;
    }
}
