package com.exercise.gmsys.model;

import java.io.Serializable;
import java.util.Date;

public class Scrap implements Serializable {
    private Integer SID;

    private Double SCOUNT;

    private Date STIME;

    private Integer BID;

    private Integer DEPARTID;

    private static final long serialVersionUID = 1L;

    public Integer getSID() {
        return SID;
    }

    public void setSID(Integer SID) {
        this.SID = SID;
    }

    public Double getSCOUNT() {
        return SCOUNT;
    }

    public void setSCOUNT(Double SCOUNT) {
        this.SCOUNT = SCOUNT;
    }

    public Date getSTIME() {
        return STIME;
    }

    public void setSTIME(Date STIME) {
        this.STIME = STIME;
    }

    public Integer getBID() {
        return BID;
    }

    public void setBID(Integer BID) {
        this.BID = BID;
    }

    public Integer getDEPARTID() {
        return DEPARTID;
    }

    public void setDEPARTID(Integer DEPARTID) {
        this.DEPARTID = DEPARTID;
    }
}