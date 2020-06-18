package com.xscheck.pojo;

public class Admin {
    private Integer adminno;
    private String password;

    public Integer getAdminno() {
        return adminno;
    }

    public void setAdminno(Integer adminno) {
        this.adminno = adminno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminno=" + adminno +
                ", password='" + password + '\'' +
                '}';
    }
}