package com.softwareEngineering.electrocar.service.impl;

import com.softwareEngineering.electrocar.entity.Indent;
import com.softwareEngineering.electrocar.dao.IndentDao;
import com.softwareEngineering.electrocar.service.IndentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;


@Service("indentService")
public class IndentServiceImpl implements IndentService {
    @Resource
    private IndentDao indentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Indent queryById(Integer id) {
        return this.indentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param indent      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Indent> queryByPage(Indent indent, PageRequest pageRequest) {
        long total = this.indentDao.count(indent);
        return new PageImpl<>(this.indentDao.queryAllByLimit(indent, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param indent 实例对象
     * @return 实例对象
     */
    @Override
    public Indent insert(Indent indent) {
        this.indentDao.insert(indent);
        return indent;
    }

    /**
     * 修改数据
     *
     * @param indent 实例对象
     * @return 实例对象
     */
    @Override
    public Indent update(Indent indent) {
        this.indentDao.update(indent);
        return this.queryById(indent.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.indentDao.deleteById(id) > 0;
    }
}
