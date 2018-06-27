package com.exercise.gmsys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor  //为类提供一个无参的构造方法
@AllArgsConstructor //为类提供一个全参的构造方法
public class Category implements Serializable {
    private Integer CID;

    private String CNAME;

    private static final long serialVersionUID = 1L;

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public String getCNAME() {
        return CNAME;
    }

    public void setCNAME(String CNAME) {
        this.CNAME = CNAME == null ? null : CNAME.trim();
    }
}