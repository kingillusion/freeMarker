package com.king.modelpdf.mapper;

import com.king.modelpdf.entity.Departments;
import java.util.List;

public interface DepartmentsMapper {
    int deleteByPrimaryKey(String dept_no);

    int insert(Departments record);

    Departments selectByPrimaryKey(String dept_no);

    List<Departments> selectAll();

    int updateByPrimaryKey(Departments record);
}