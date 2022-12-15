package com.softwareEngineering.electrocar.dao;

import com.softwareEngineering.electrocar.entity.Ev;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Mapper
public interface EvDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Ev queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param ev       查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Ev> queryAllByLimit(Ev ev, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param ev 查询条件
     * @return 总行数
     */
    long count(Ev ev);

    /**
     * 新增数据
     *
     * @param ev 实例对象
     * @return 影响行数
     */
    int insert(Ev ev);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ev> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Ev> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ev> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Ev> entities);

    /**
     * 修改数据
     *
     * @param ev 实例对象
     * @return 影响行数
     */
    int update(Ev ev);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

