package com.exercise.gmsys.model;

import java.io.Serializable;
import java.util.Date;

public class Repair implements Serializable {
    private Integer REPAIRID;

    private Double RCOUNT;

    private Date RTIME;

    private Integer DEPARTID;

    private Integer BID;

    private static final long serialVersionUID = 1L;

    public Integer getREPAIRID() {
        return REPAIRID;
    }

    public void setREPAIRID(Integer REPAIRID) {
        this.REPAIRID = REPAIRID;
    }

    public Double getRCOUNT() {
        return RCOUNT;
    }

    public void setRCOUNT(Double RCOUNT) {
        this.RCOUNT = RCOUNT;
    }

    public Date getRTIME() {
        return RTIME;
    }

    public void setRTIME(Date RTIME) {
        this.RTIME = RTIME;
    }

    public Integer getDEPARTID() {
        return DEPARTID;
    }

    public void setDEPARTID(Integer DEPARTID) {
        this.DEPARTID = DEPARTID;
    }

    public Integer getBID() {
        return BID;
    }

    public void setBID(Integer BID) {
        this.BID = BID;
    }
}