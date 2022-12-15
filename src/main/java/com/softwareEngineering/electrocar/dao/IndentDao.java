package com.softwareEngineering.electrocar.dao;

import com.softwareEngineering.electrocar.entity.Indent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Mapper
public interface IndentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Indent queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param indent   查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Indent> queryAllByLimit(Indent indent, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param indent 查询条件
     * @return 总行数
     */
    long count(Indent indent);

    /**
     * 新增数据
     *
     * @param indent 实例对象
     * @return 影响行数
     */
    int insert(Indent indent);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Indent> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Indent> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Indent> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Indent> entities);

    /**
     * 修改数据
     *
     * @param indent 实例对象
     * @return 影响行数
     */
    int update(Indent indent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

