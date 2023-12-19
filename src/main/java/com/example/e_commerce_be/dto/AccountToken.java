package com.example.e_commerce_be.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class AccountToken {

    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String address;
    private String province;
    private String district;
    private String ward;
    private String email;
    private String phone;
    private String avatar;
    private double wallet;
    private String status;
    private String token;
    private List<String> roles;

    public AccountToken() {
    }

    public AccountToken(Integer id, String username,
                        String firstname,
                        String lastname, String address, String province,
                        String district, String ward, String email, String phone,
                        String avatar, double wallet, String status, String token,
                        List<String> roles) {
        this.id = id;
        this.username = username;

        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.wallet = wallet;
        this.status = status;
        this.token = token;
        this.roles = roles;
    }
}
