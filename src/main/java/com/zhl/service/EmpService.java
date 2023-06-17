package com.zhl.service;

import com.zhl.pojo.Emp;
import com.zhl.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/*
* 员工管理
* */
public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    void add(Emp emp);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
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
    Emp login(Emp emp);

    /**
     * 根据部门id删除员工
     * @param id
     */
    void deleteByDepId(Integer id);
}
