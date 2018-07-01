package com.exercise.gmsys.model;

import java.io.Serializable;

public class CheckBalance implements Serializable {
    private Integer CHID;

    private Integer BUYID;

    private Integer BID;

    private Integer REPAIRID;

    private Integer SID;

    private Integer TID;

    private static final long serialVersionUID = 1L;

    public Integer getCHID() {
        return CHID;
    }

    public void setCHID(Integer CHID) {
        this.CHID = CHID;
    }

    public Integer getBUYID() {
        return BUYID;
    }

    public void setBUYID(Integer BUYID) {
        this.BUYID = BUYID;
    }

    public Integer getBID() {
        return BID;
    }

    public void setBID(Integer BID) {
        this.BID = BID;
    }

    public Integer getREPAIRID() {
        return REPAIRID;
    }

    public void setREPAIRID(Integer REPAIRID) {
        this.REPAIRID = REPAIRID;
    }

    public Integer getSID() {
        return SID;
    }

    public void setSID(Integer SID) {
        this.SID = SID;
    }

    public Integer getTID() {
        return TID;
    }

    public void setTID(Integer TID) {
        this.TID = TID;
    }
}