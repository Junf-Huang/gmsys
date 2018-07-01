package com.exercise.gmsys.model;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer PRODID;

    private String PRODNAME;

    private Double PRODCOUNT;

    private Integer PROVID;

    private static final long serialVersionUID = 1L;

    public Integer getPRODID() {
        return PRODID;
    }

    public void setPRODID(Integer PRODID) {
        this.PRODID = PRODID;
    }

    public String getPRODNAME() {
        return PRODNAME;
    }

    public void setPRODNAME(String PRODNAME) {
        this.PRODNAME = PRODNAME == null ? null : PRODNAME.trim();
    }

    public Double getPRODCOUNT() {
        return PRODCOUNT;
    }

    public void setPRODCOUNT(Double PRODCOUNT) {
        this.PRODCOUNT = PRODCOUNT;
    }

    public Integer getPROVID() {
        return PROVID;
    }

    public void setPROVID(Integer PROVID) {
        this.PROVID = PROVID;
    }
}