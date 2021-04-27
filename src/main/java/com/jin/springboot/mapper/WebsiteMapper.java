package com.jin.springboot.mapper;


import com.jin.springboot.entity.Website;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
@Repository("websiteMapper")
public interface WebsiteMapper {

//    @Select("select id, name, url, country from website")
    public List<Website> getAll();

//    @Insert("insert into website(id, name, url, country) values (#{website.id},#{website.name},#{website.url},#{website.country})")
    public void add(@Param("website") Website website);

//    @Update("update website set name = #{website.name}, url = #{website.url}, country = #{website.country} where id = #{website.id}")
    public void updateById(@Param("website") Website website);

//    @Delete("delete from website where id=#{id}")
    public void deleteById(@Param("id") Integer id);

//    @Select("select id, name, url, country from website where id=#{id}")
    public Website getById(@Param("id") Integer id);

}
