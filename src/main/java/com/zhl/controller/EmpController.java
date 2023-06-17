package com.zhl.controller;

import com.zhl.anno.Log;
import com.zhl.pojo.Emp;
import com.zhl.pojo.PageBean;
import com.zhl.pojo.Result;
import com.zhl.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
* 员工管理Controller
* */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end)
    {
        log.info("分页查询，参数:{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Log
    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids){//由于路径变量，所以使用PathVariable
        log.info("批量删除：{}",ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 新增员工
     * @param emp
     * @return
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        empService.add(emp);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工信息，id:{}",id);
        Emp emp= empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 修改员工信息
     * @param emp
     * @return
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息:{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
