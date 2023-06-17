package com.zhl.service;

import com.zhl.pojo.Dept;

import java.util.List;

/*
* 部门管理
* */
public interface DeptService {
    /*
    * 查询全部部门数据
    * */
    List<Dept> list();

    /*
    * 根据id删除部门信息
    * */
    void delete(Integer id);

    /*
    * 新增部门
    * */
    void insert(Dept dept);



    /*
    *根据id查询部门信息
    * */
    Dept search(Integer id);

    void update(Dept dept);
}
