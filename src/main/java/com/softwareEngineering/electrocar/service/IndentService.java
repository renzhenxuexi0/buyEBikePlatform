package com.softwareEngineering.electrocar.service;

import com.softwareEngineering.electrocar.entity.Indent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IndentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Indent queryById(Integer id);

    /**
     * 分页查询
     *
     * @param indent      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Indent> queryByPage(Indent indent, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param indent 实例对象
     * @return 实例对象
     */
    Indent insert(Indent indent);

    /**
     * 修改数据
     *
     * @param indent 实例对象
     * @return 实例对象
     */
    Indent update(Indent indent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
