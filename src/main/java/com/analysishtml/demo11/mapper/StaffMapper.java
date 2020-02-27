package com.analysishtml.demo11.mapper;

import com.analysishtml.demo11.model.Staff;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaffMapper {
    int insert(Staff staff);

    int updateById(int contentId, int id);
}
