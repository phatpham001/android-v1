package com.example.facerecognition.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class AccountModel {
    @SerializedName("idaccount")
    private int idaccount;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
//    private Date created_at;
    @SerializedName("role")
    private String role;
    @SerializedName("status")
    private int status;

    public AccountModel() {
    }

    public AccountModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AccountModel(int idaccount, String username, String password, String role, int status) {
        this.idaccount = idaccount;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public AccountModel(String username, String password,  String role, int status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Date getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(Date created_at) {
//        this.created_at = created_at;
//    }21

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
