package com.xscheck.pojo;

public class Course {
    private Integer id;
    private String coursename;
    private String majorclass;
    private Integer tno;
    private String tname;
    private String schedule;
    private String credit;
    private String period;
    private String type;
    private String acadyearterm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getMajorclass() {
        return majorclass;
    }

    public void setMajorclass(String majorclass) {
        this.majorclass = majorclass;
    }

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAcadyearterm() {
        return acadyearterm;
    }

    public void setAcadyearterm(String acadyearterm) {
        this.acadyearterm = acadyearterm;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", coursename='" + coursename + '\'' +
                ", majorclass='" + majorclass + '\'' +
                ", tno=" + tno +
                ", tname='" + tname + '\'' +
                ", schedule='" + schedule + '\'' +
                ", credit='" + credit + '\'' +
                ", period='" + period + '\'' +
                ", type='" + type + '\'' +
                ", acadyearterm='" + acadyearterm + '\'' +
                '}';
    }
}
