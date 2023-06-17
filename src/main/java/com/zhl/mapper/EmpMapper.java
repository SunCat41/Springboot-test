package com.zhl.mapper;

import com.zhl.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/*
* 员工管理
* */
@Mapper
public interface EmpMapper {
//    /*
//    * 查询总记录数
//    * @return
//    * */
//    @Select("select count(*) from emp")
//    public Long count();
//
//    /*
//    *分页查询，获取列表数据
//    * @param start
//    * @param PageSize
//    * @return
//    * */
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);

    /**
     * 分页查询，获取列表数据
     * @return
     */
//    @Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    @Insert("insert into emp(username,name,gender,image,job,entrydate,dept_id,create_time,update_time)"+
    "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void add(Emp emp);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 修改员工信息
     * @param emp
     */
    void update(Emp emp);

    /**
     * 员工登录
     * @param emp
     * @return
     */
    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 根据bumenID删除员工
     * @param id
     */
    @Delete("delete from emp where dept_id = #{id}")
    void deleteByDepId(Integer id);
}
