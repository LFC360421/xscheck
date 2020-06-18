package com.xscheck.pojo;

public class Statistics {
    private int sno;
    private String sname;
    private int arrivedNum;
    private int applyNum;
    private int truancyNum;

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

    public int getArrivedNum() {
        return arrivedNum;
    }

    public void setArrivedNum(int arrivedNum) {
        this.arrivedNum = arrivedNum;
    }

    public int getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }

    public int getTruancyNum() {
        return truancyNum;
    }

    public void setTruancyNum(int truancyNum) {
        this.truancyNum = truancyNum;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", arrivedNum=" + arrivedNum +
                ", applyNum=" + applyNum +
                ", truancyNum=" + truancyNum +
                '}';
    }
}
