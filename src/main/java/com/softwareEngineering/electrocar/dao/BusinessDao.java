package com.softwareEngineering.electrocar.dao;

import com.softwareEngineering.electrocar.entity.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface BusinessDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Business queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param business 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Business> queryAllByLimit(Business business, @Param("pageable") Pageable pageable);

    /**
     * 通过品牌名查找商家
     *
     * @param brand 品牌名
     * @return 实例对象
     */
    Business queryByBrand(@Param("brand") String brand);

    /**
     * 通过手机号查找商家
     *
     * @param phone 手机号
     * @return 实例对象
     */
    Business queryByPhone(@Param("phone") String phone);


    /**
     * 通过账号和密码查找商家
     *
     * @param account  账号
     * @param password 密码
     * @return 实例对象
     */
    Business queryByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    /**
     * 统计总行数
     *
     * @param business 查询条件
     * @return 总行数
     */
    long count(Business business);

    /**
     * 新增数据
     *
     * @param business 实例对象
     * @return 影响行数
     */
    int insert(Business business);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Business> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Business> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Business> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Business> entities);

    /**
     * 修改数据
     *
     * @param business 实例对象
     * @return 影响行数
     */
    int update(Business business);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

