package com.example.self.UsersClasses;

public class DiaryHelper {
    String note,key,date;

    public DiaryHelper(String note, String key, String date) {
        this.note = note;
        this.key = key;
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DiaryHelper() {
    }
}
