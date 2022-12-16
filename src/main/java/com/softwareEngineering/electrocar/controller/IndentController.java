package com.softwareEngineering.electrocar.controller;

import com.softwareEngineering.electrocar.entity.Indent;
import com.softwareEngineering.electrocar.service.IndentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("indent")
public class IndentController {
    /**
     * 服务对象
     */
    @Resource
    private IndentService indentService;

    /**
     * 分页查询
     *
     * @param indent      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<Indent>> queryByPage(Indent indent, PageRequest pageRequest) {
        return ResponseEntity.ok(this.indentService.queryByPage(indent, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Indent> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.indentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param indent 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Indent> add(Indent indent) {
        return ResponseEntity.ok(this.indentService.insert(indent));
    }

    /**
     * 编辑数据
     *
     * @param indent 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Indent> edit(Indent indent) {
        return ResponseEntity.ok(this.indentService.update(indent));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.indentService.deleteById(id));
    }

}

