package com.softwareEngineering.electrocar.controller;

import com.softwareEngineering.electrocar.entity.Business;
import com.softwareEngineering.electrocar.service.BusinessService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("business")
public class BusinessController {
    /**
     * 服务对象
     */
    @Resource
    private BusinessService businessService;

    /**
     * 分页查询
     *
     * @param business    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<Business>> queryByPage(Business business, PageRequest pageRequest) {
        return ResponseEntity.ok(this.businessService.queryByPage(business, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Business> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.businessService.queryById(id));
    }

    /**
     * 通过品牌名查找商家
     *
     * @param brand 品牌名
     * @return 实例对象
     */
    @GetMapping("/brand/{brand}")
    public ResponseEntity<Boolean> queryByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(businessService.queryByBrand(brand));
    }

    /**
     * 通过手机号查找商家
     *
     * @param phone 手机号
     * @return 实例对象
     */
    @GetMapping("/phone/{phone}")
    public ResponseEntity<Boolean> queryByPhone(@PathVariable String phone) {
        return ResponseEntity.ok(businessService.queryByPhone(phone));
    }

    /**
     * 通过账号和密码查找商家
     *
     * @param account  账号
     * @param password 密码
     * @return 实例对象
     */
    @GetMapping("account/{account}/password/{password}")
    public ResponseEntity<Business> queryByAccountAndPassword(@PathVariable String account, @PathVariable String password) {
        return ResponseEntity.ok(businessService.queryByAccountAndPassword(account, password));
    }

    /**
     * 新增数据
     *
     * @param business 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Business> add(@RequestBody Business business) {
        return ResponseEntity.ok(this.businessService.insert(business));
    }

    /**
     * 编辑数据
     *
     * @param business 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Business> edit(@RequestBody Business business) {
        return ResponseEntity.ok(this.businessService.update(business));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.businessService.deleteById(id));
    }

}

