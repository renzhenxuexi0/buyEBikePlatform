package com.softwareEngineering.electrocar.controller;

import com.softwareEngineering.electrocar.entity.Ev;
import com.softwareEngineering.electrocar.service.EvService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("ev")
public class EvController {
    /**
     * 服务对象
     */
    @Resource
    private EvService evService;

    /**
     * 分页查询
     *
     * @param ev          筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<Ev>> queryByPage(Ev ev, PageRequest pageRequest) {
        return ResponseEntity.ok(this.evService.queryByPage(ev, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Ev> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.evService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ev 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Ev> add(Ev ev) {
        return ResponseEntity.ok(this.evService.insert(ev));
    }

    /**
     * 编辑数据
     *
     * @param ev 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Ev> edit(Ev ev) {
        return ResponseEntity.ok(this.evService.update(ev));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.evService.deleteById(id));
    }

}

