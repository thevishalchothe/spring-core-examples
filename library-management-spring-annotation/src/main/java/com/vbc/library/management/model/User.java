package com.vbc.library.management.model;

import lombok.Data;

@Data
public class User {
    private int uid;
    private String uname;
    private String email;
    private String mobile;
    private String address;
    private College college;
}
