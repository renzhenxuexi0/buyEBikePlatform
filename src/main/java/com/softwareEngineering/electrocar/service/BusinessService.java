package com.softwareEngineering.electrocar.service;

import com.softwareEngineering.electrocar.entity.Business;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface BusinessService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Business queryById(Integer id);

    /**
     * 分页查询
     *
     * @param business    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Business> queryByPage(Business business, PageRequest pageRequest);

    /**
     * 通过品牌名查找商家
     *
     * @param brand 品牌名
     * @return 实例对象
     */
    Boolean queryByBrand(String brand);

    /**
     * 通过手机号查找商家
     *
     * @param phone 手机号
     * @return 实例对象
     */
    Boolean queryByPhone(String phone);


    /**
     * 通过账号和密码查找商家
     *
     * @param account  账号
     * @param password 密码
     * @return 实例对象
     */
    Business queryByAccountAndPassword(String account, String password);

    /**
     * 新增数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    Business insert(Business business);

    /**
     * 修改数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    Business update(Business business);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
