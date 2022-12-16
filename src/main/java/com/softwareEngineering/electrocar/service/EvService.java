package com.softwareEngineering.electrocar.service;

import com.softwareEngineering.electrocar.entity.Ev;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EvService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Ev queryById(Integer id);

    /**
     * 分页查询
     *
     * @param ev          筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Ev> queryByPage(Ev ev, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ev 实例对象
     * @return 是否成功
     */
    Boolean insert(Ev ev);

    /**
     * 修改数据
     *
     * @param ev 实例对象
     * @return 是否成功
     */
    Boolean update(Ev ev);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
