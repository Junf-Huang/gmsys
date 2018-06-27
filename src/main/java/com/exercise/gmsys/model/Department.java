package com.exercise.gmsys.model;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer DEPARTID;

    private String DEPARTNAME;

    private Integer AREAID;

    private String AREANAME;

    private static final long serialVersionUID = 1L;

    public Integer getDEPARTID() {
        return DEPARTID;
    }

    public void setDEPARTID(Integer DEPARTID) {
        this.DEPARTID = DEPARTID;
    }

    public String getDEPARTNAME() {
        return DEPARTNAME;
    }

    public void setDEPARTNAME(String DEPARTNAME) {
        this.DEPARTNAME = DEPARTNAME == null ? null : DEPARTNAME.trim();
    }

    public Integer getAREAID() {
        return AREAID;
    }

    public void setAREAID(Integer AREAID) {
        this.AREAID = AREAID;
    }

    public String getAREANAME() {
        return AREANAME;
    }

    public void setAREANAME(String AREANAME) {
        this.AREANAME = AREANAME == null ? null : AREANAME.trim();
    }
}