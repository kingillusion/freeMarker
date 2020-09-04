package com.king.modelpdf.mapper;

import com.king.modelpdf.entity.Employees;
import java.util.List;

public interface EmployeesMapper {
    int deleteByPrimaryKey(Integer emp_no);

    int insert(Employees record);

    Employees selectByPrimaryKey(Integer emp_no);

    List<Employees> selectAll();

    int updateByPrimaryKey(Employees record);
}