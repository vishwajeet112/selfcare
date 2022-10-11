package com.example.self.UsersClasses;

public class Uploadhelp {
    String url,name,mail;

    public Uploadhelp() {
    }

    public Uploadhelp(String url, String name, String mail) {
        this.url = url;
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


