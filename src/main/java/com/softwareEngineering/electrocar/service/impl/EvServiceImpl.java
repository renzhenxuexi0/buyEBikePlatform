package com.softwareEngineering.electrocar.service.impl;

import com.softwareEngineering.electrocar.dao.EvDao;
import com.softwareEngineering.electrocar.entity.Ev;
import com.softwareEngineering.electrocar.service.EvService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("evService")
public class EvServiceImpl implements EvService {
    @Resource
    private EvDao evDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Ev queryById(Integer id) {
        return this.evDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param ev          筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Ev> queryByPage(Ev ev, PageRequest pageRequest) {
        long total = this.evDao.count(ev);
        return new PageImpl<>(this.evDao.queryAllByLimit(ev, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ev 实例对象
     * @return 是否成功
     */
    @Override
    public Boolean insert(Ev ev) {
        return this.evDao.insert(ev) > 0;
    }

    /**
     * 修改数据
     *
     * @param ev 实例对象
     * @return 是否成功
     */
    @Override
    public Boolean update(Ev ev) {
        return this.evDao.update(ev) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.evDao.deleteById(id) > 0;
    }
}
