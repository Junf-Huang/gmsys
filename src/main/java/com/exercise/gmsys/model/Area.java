package com.exercise.gmsys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor  //为类提供一个无参的构造方法
@AllArgsConstructor //为类提供一个全参的构造方法
public class Area implements Serializable {
    private Integer AREAID;

    private String AREANAME;

    private Integer RELATIVE;

    private static final long serialVersionUID = 1L;

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

    public Integer getRELATIVE() {
        return RELATIVE;
    }

    public void setRELATIVE(Integer RELATIVE) {
        this.RELATIVE = RELATIVE;
    }
}