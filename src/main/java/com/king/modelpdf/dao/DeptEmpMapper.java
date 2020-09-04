package com.king.modelpdf.dao;

import com.king.modelpdf.entity.DeptEmp;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptEmpMapper {
    int deleteByPrimaryKey(@Param("emp_no") Integer emp_no, @Param("dept_no") String dept_no);

    int insert(DeptEmp record);

    DeptEmp selectByPrimaryKey(@Param("emp_no") Integer emp_no, @Param("dept_no") String dept_no);

    List<DeptEmp> selectAll();

    int updateByPrimaryKey(DeptEmp record);
}