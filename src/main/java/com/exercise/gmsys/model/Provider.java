package com.exercise.gmsys.model;

import java.io.Serializable;

public class Provider implements Serializable {
    private Integer PROVID;

    private String PROVNAME;

    private String ADDRESS;

    private String PHONE;

    private static final long serialVersionUID = 1L;

    public Integer getPROVID() {
        return PROVID;
    }

    public void setPROVID(Integer PROVID) {
        this.PROVID = PROVID;
    }

    public String getPROVNAME() {
        return PROVNAME;
    }

    public void setPROVNAME(String PROVNAME) {
        this.PROVNAME = PROVNAME == null ? null : PROVNAME.trim();
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS == null ? null : ADDRESS.trim();
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE == null ? null : PHONE.trim();
    }
}