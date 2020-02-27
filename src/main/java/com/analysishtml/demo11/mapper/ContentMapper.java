package com.analysishtml.demo11.mapper;

import com.analysishtml.demo11.model.Content;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentMapper {
    int insert(Content content);
    int updateById(int staffGroupId, int id);
}
