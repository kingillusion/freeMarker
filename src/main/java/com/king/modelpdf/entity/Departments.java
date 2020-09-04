package com.king.modelpdf.entity;

import java.io.Serializable;

public class Departments implements Serializable {
    private String dept_no;

    private String dept_name;

    private static final long serialVersionUID = 1L;

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no == null ? null : dept_no.trim();
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name == null ? null : dept_name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dept_no=").append(dept_no);
        sb.append(", dept_name=").append(dept_name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}