package com.zhl.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhl.mapper.EmpMapper;
import com.zhl.pojo.Emp;
import com.zhl.pojo.PageBean;
import com.zhl.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end){
////        获取总记录数
//        Long count = empMapper.count();
////      获取分页查询结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp>empList=empMapper.page(start,pageSize);
////        封装PageBean对象
//        PageBean pageBean = new PageBean(count,empList);
        //        获取总记录数
        PageHelper.startPage(page,pageSize);
//      获取分页查询结果列表
        List<Emp> empList= empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>)empList;
//        封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /**
     * 根据id批量删除员工
     * @param ids
     */
    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }

    /**
     * 新增员工
     * @param emp
     */
    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    /**
     * 修改员工信息
     * @param emp
     */
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    /**
     * 员工登录
     * @param emp
     * @return
     */
    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }

    /**
     * 根据部门id删除员工
     * @param id
     */
    @Override
    public void deleteByDepId(Integer id) {
        empMapper.deleteByDepId(id);
    }
}
