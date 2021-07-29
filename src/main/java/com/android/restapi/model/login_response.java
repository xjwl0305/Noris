package com.android.restapi.model;

import lombok.Getter;
import lombok.Setter;

public class login_response {
    public String status;
    public String Name;
    public String email;
    public String phone;
    public String company;

    public login_response(){}
    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
