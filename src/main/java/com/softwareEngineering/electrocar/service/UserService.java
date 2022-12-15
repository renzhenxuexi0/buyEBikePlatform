package com.softwareEngineering.electrocar.service;

import com.softwareEngineering.electrocar.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 是否存在
     */
    Boolean queryByUsername(String username);

    /**
     * 通过手机号查找用户
     *
     * @param phone 手机号
     * @return 是否存在
     */
    Boolean queryByPhone(String phone);

    /**
     * 通过手机号和密码查找用户
     *
     * @param phone 手机号
     * @param password 密码
     * @return 是否存在
     */
    Boolean queryByPhoneAndPassword(String phone, String password);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    Boolean insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
