package com.example.self.UsersClasses;

public class UserGuardian {
    String yourMail, yourPhn, childMail, name, role,childPassword;

    public String getChildPassword() {
        return childPassword;
    }

    public void setChildPassword(String childPassword) {
        this.childPassword = childPassword;
    }

    public UserGuardian() {
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

    public String getChildMail() {
        return childMail;
    }

    public void setChildMail(String childMail) {
        this.childMail = childMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserGuardian(String yourMail, String yourPhn, String childMail, String name, String role,String childPassword){
        this.yourMail=yourMail;
        this.yourPhn=yourPhn;
        this.childMail=childMail;
        this.name=name;
        this.role=role;
        this.childPassword=childPassword;

    }
}
