package com.exercise.gmsys.model;

import java.io.Serializable;
import java.util.Date;

public class Assignment implements Serializable {
    private Integer TID;

    private Double TCOUNT;

    private Date TRTIME;

    private Integer BID;

    private Integer DEPARTID;

    private static final long serialVersionUID = 1L;

    public Integer getTID() {
        return TID;
    }

    public void setTID(Integer TID) {
        this.TID = TID;
    }

    public Double getTCOUNT() {
        return TCOUNT;
    }

    public void setTCOUNT(Double TCOUNT) {
        this.TCOUNT = TCOUNT;
    }

    public Date getTRTIME() {
        return TRTIME;
    }

    public void setTRTIME(Date TRTIME) {
        this.TRTIME = TRTIME;
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