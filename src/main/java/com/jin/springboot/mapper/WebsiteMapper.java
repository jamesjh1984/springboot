package com.jin.springboot.mapper;


import com.jin.springboot.entity.Website;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//@Component
@Repository("websiteMapper")
public interface WebsiteMapper {

//    @Select("select id, name, url, country from website")
    List<Website> getAll();

//    @Insert("insert into website(id, name, url, country) values (#{website.id},#{website.name},#{website.url},#{website.country})")
    void add(@Param("website") Website website);

//    @Update("update website set name = #{website.name}, url = #{website.url}, country = #{website.country} where id = #{website.id}")
    void updateById(@Param("website") Website website);

//    @Delete("delete from website where id=#{id}")
    void deleteById(@Param("id") Integer id);

    //    @Select("select id, name, url, country from website where id=#{id}")
    Website getById(@Param("id") Integer id);

    //    @Select("select id, name, url, country from website where name=#{name}")
    Website getByName(@Param("name") String name);





//    MySql Stored Procedure, call james.get_all_websites();
    List<Website> mysqlGetAllWebsites();

//    MySql Stored Procedure, call james.get_website_by_id();
    List<Website> mysqlGetWebsiteById(Map<String, Object> map);




//    Oracle Stored Procedure, call c##e519013.pkg_website.get_all_websites(po_websites OUT SYS_REFCURSOR);
    List<Website> oracleGetAllWebsites(Map<String, Object> map);

//    Oracle Stored Procedure, call c##e519013.pkg_website.get_website_by_id(pi_id IN INTEGER, po_websites OUT SYS_REFCURSOR);
    List<Website> oracleGetWebsiteById(Map<String, Object> map);


}
