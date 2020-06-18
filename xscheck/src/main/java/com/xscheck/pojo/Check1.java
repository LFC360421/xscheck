package com.xscheck.pojo;

import java.util.Date;

public class Check1 {
    private int id;
    private int sno;
    private String sname;
    private String majorclass;
    private Date checktime;
    private String coursename;
    private String tname;
    private String istruancy;
    private String acadyearterm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMajorclass() {
        return majorclass;
    }

    public void setMajorclass(String majorclass) {
        this.majorclass = majorclass;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getIstruancy() {
        return istruancy;
    }

    public void setIstruancy(String istruancy) {
        this.istruancy = istruancy;
    }

    public String getAcadyearterm() {
        return acadyearterm;
    }

    public void setAcadyearterm(String acadyearterm) {
        this.acadyearterm = acadyearterm;
    }

    @Override
    public String toString() {
        return "Check1{" +
                "id=" + id +
                ", sno=" + sno +
                ", sname='" + sname + '\'' +
                ", majorclass='" + majorclass + '\'' +
                ", checktime=" + checktime +
                ", coursename='" + coursename + '\'' +
                ", tname='" + tname + '\'' +
                ", istruancy='" + istruancy + '\'' +
                ", acadyearterm='" + acadyearterm + '\'' +
                '}';
    }
}
