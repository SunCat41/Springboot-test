package com.zhl.service.impl;


import com.zhl.mapper.DeptMapper;
import com.zhl.mapper.EmpMapper;
import com.zhl.pojo.Dept;
import com.zhl.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;
   /*
   * 查询全部部门信息
   * */
    @Override
    public List<Dept> list(){
        return deptMapper.list();
    }

    /*
    * 根据id删除部门
    * */
    @Transactional
    @Override
    public void delete(Integer id){
        deptMapper.deleteById(id);
        empMapper.deleteByDepId(id);
    }

    /*
    * 新增部门
    * */

    @Override
    public void insert(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    /*
    * 根据id查询部门信息
    * */
    @Override
    public Dept search(Integer id){
        return deptMapper.search(id);
    }

    /*
    * 修改部门信息
    * */
    @Override
    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
