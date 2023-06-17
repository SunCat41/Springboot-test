package com.zhl.controller;

import com.zhl.anno.Log;
import com.zhl.pojo.Dept;
import com.zhl.pojo.Result;
import com.zhl.service.DeptService;
import com.zhl.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* 部门管理Controller
* */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
//    private static Logger log = LoggerFactory.getLogger(DeptController.class);记录日志，使用@Slf4j与这段代码作用一样
    @Autowired
    private DeptService deptService;
    @Autowired
    private EmpService empService;
    /*
    * 查询部门信息
    * */
    @GetMapping
    public Result list(){
        log.info("查询全部数据");
        List<Dept> deptList= deptService.list();
        return Result.success(deptList);
    }
    /*
    * 删除部门
    * */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);
        deptService.delete(id);
        empService.deleteByDepId(id);
        return Result.success();
    }

    /*
    * 新增部门
    * */
    @Log
    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        deptService.insert(dept);
        return Result.success();
    }

    /*
    * 根据id查询部门
    * */
    @GetMapping("/{id}")
    public Result Search(@PathVariable Integer id){
        log.info("根据id查询部门信息:{}",id);
        Dept dept = deptService.search(id);
        return Result.success(dept);
    }//返回对象，给下边的修改方法提供数据

    /*
    * 修改部门信息
    * */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门信息");
        deptService.update(dept);
        return Result.success();
    }//由于在前端，编辑按钮和search方法其实是@GetMapping绑定了，所以会在页面中显示出dept实体信息，且信息在响应体中
    //所以在update方法中@RequestBody可以接收到dept这么一个json格式的数据
}
