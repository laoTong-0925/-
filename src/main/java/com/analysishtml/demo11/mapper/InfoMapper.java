package com.analysishtml.demo11.mapper;

import com.analysishtml.demo11.model.Info;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InfoMapper {

    int insert(Info info);

    int updateById(int contentId, int id);

}
