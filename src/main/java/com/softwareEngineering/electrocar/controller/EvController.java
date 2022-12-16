package com.softwareEngineering.electrocar.controller;

import com.softwareEngineering.electrocar.entity.Ev;
import com.softwareEngineering.electrocar.service.EvService;
import com.softwareEngineering.electrocar.utils.PicUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;


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

    @GetMapping("/deleteImage/{path}")
    public ResponseEntity<String> deleteImage(@PathVariable("path") String path) {
        String s = PicUtil.deFile(path);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    /**
     * 新增数据
     *
     * @param ev 实体
     * @return 新增是否成功
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(Ev ev) {
        return ResponseEntity.ok(this.evService.insert(ev));
    }

    /**
     * 上传图片
     *
     * @param File 图片文件
     * @return 返回是否成功的信息
     */
    @PostMapping("/uploadingImage")
    public ResponseEntity<String> uploadingImage(@RequestParam("file") MultipartFile File) {
        try {
            System.out.println(File);
            String s = PicUtil.singleFileUpload(File);
            return ResponseEntity.status(HttpStatus.OK).body(s);
        } catch (IOException e) {
            return ResponseEntity.ok("服务器异常");
        }
    }

    /**
     * 编辑数据
     *
     * @param ev 实体
     * @return 编辑是否成功
     */
    @PutMapping
    public ResponseEntity<Boolean> edit(Ev ev) {
        return ResponseEntity.ok(this.evService.update(ev));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.evService.deleteById(id));
    }

}

