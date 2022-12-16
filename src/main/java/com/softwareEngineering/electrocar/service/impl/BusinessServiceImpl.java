package com.softwareEngineering.electrocar.service.impl;

import com.softwareEngineering.electrocar.dao.BusinessDao;
import com.softwareEngineering.electrocar.entity.Business;
import com.softwareEngineering.electrocar.service.BusinessService;
import com.softwareEngineering.electrocar.utils.RandomStringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessDao businessDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Business queryById(Integer id) {
        return this.businessDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param business    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Business> queryByPage(Business business, PageRequest pageRequest) {
        long total = this.businessDao.count(business);
        return new PageImpl<>(this.businessDao.queryAllByLimit(business, pageRequest), pageRequest, total);
    }

    /**
     * 通过品牌名查找商家
     *
     * @param brand 品牌名
     * @return 实例对象
     */
    @Override
    public Boolean queryByBrand(String brand) {
        return businessDao.queryByBrand(brand) != null;
    }

    /**
     * 通过手机号查找商家
     *
     * @param phone 手机号
     * @return 实例对象
     */
    @Override
    public Boolean queryByPhone(String phone) {
        return businessDao.queryByPhone(phone) != null;
    }

    /**
     * 通过账号和密码查找商家
     *
     * @param account  账号
     * @param password 密码
     * @return 实例对象
     */
    @Override
    public Business queryByAccountAndPassword(String account, String password) {
        return businessDao.queryByAccountAndPassword(account, password);
    }

    /**
     * 新增数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    @Override
    public Business insert(Business business) {
        business.setAccount(RandomStringUtil.randomString(8));
        this.businessDao.insert(business);
        return business;
    }

    /**
     * 修改数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    @Override
    public Business update(Business business) {
        this.businessDao.update(business);
        return this.queryById(business.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.businessDao.deleteById(id) > 0;
    }
}
