package com.example.travelloggedin;

public class ContactModel {
    private String email;
    private String mobile;

    public ContactModel(String emailid, String mobileno){
        this.email = emailid;
        this.mobile = mobileno;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email_id) {
        this.email = email_id;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile_no) {
        this.mobile = mobile_no;
    }
}
