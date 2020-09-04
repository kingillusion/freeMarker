package com.king.modelpdf.mapper;

import com.king.modelpdf.entity.Salaries;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalariesMapper {
    int deleteByPrimaryKey(@Param("emp_no") Integer emp_no, @Param("from_date") Date from_date);

    int insert(Salaries record);

    Salaries selectByPrimaryKey(@Param("emp_no") Integer emp_no, @Param("from_date") Date from_date);

    List<Salaries> selectAll();

    int updateByPrimaryKey(Salaries record);
}