package com.zhl.mapper;

import com.zhl.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
* 部门管理
* */
@Mapper
public interface DeptMapper {
    /*
    * 查询全部部门信息
    * */
    @Select("select * from dept")

    /*
    * 根据id删除部门信息
    * */
    List<Dept> list();
    /*
    * 根据id删除部门信息
    * */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /*
    * 新增部门
    * */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime}) ")
    void insert(Dept dept);
    @Select("select * from dept where id =#{id}")
    Dept search(Integer id);
    @Update("update dept set name = #{name},update_time=#{updateTime} where id =#{id}")
    void update(Dept dept);
}
