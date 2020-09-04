package com.king.modelpdf.dao;

import com.king.modelpdf.entity.Titles;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TitlesMapper {
    int deleteByPrimaryKey(@Param("emp_no") Integer emp_no, @Param("title") String title, @Param("from_date") Date from_date);

    int insert(Titles record);

    Titles selectByPrimaryKey(@Param("emp_no") Integer emp_no, @Param("title") String title, @Param("from_date") Date from_date);

    List<Titles> selectAll();

    int updateByPrimaryKey(Titles record);
}