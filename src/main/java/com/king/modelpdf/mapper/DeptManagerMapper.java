package com.king.modelpdf.mapper;

import com.king.modelpdf.entity.DeptManager;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptManagerMapper {
    int deleteByPrimaryKey(@Param("emp_no") Integer emp_no, @Param("dept_no") String dept_no);

    int insert(DeptManager record);

    DeptManager selectByPrimaryKey(@Param("emp_no") Integer emp_no, @Param("dept_no") String dept_no);

    List<DeptManager> selectAll();

    int updateByPrimaryKey(DeptManager record);
}