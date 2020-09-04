package com.king.modelpdf.entity;

import java.io.Serializable;
import java.util.Date;

public class DeptManager implements Serializable {
    private Integer emp_no;

    private String dept_no;

    private Date from_date;

    private Date to_date;

    private static final long serialVersionUID = 1L;

    public Integer getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(Integer emp_no) {
        this.emp_no = emp_no;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no == null ? null : dept_no.trim();
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", emp_no=").append(emp_no);
        sb.append(", dept_no=").append(dept_no);
        sb.append(", from_date=").append(from_date);
        sb.append(", to_date=").append(to_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}