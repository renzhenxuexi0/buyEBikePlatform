package com.softwareEngineering.electrocar.service.impl;

import com.softwareEngineering.electrocar.dao.UserDao;
import com.softwareEngineering.electrocar.entity.User;
import com.softwareEngineering.electrocar.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 通过手机号和密码查找用户
     *
     * @param phone    手机号
     * @param password 密码
     * @return 是否存在
     */
    public User queryByPhoneAndPassword(String phone, String password) {
        return userDao.queryByPhoneAndPassword(phone, password);
    }

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 是否存在
     */
    public Boolean queryByUsername(String username) {
        return userDao.queryByUsername(username) != null;
    }

    /**
     * 通过手机号查找用户
     *
     * @param phone 手机号
     * @return 是否存在
     */
    public Boolean queryByPhone(String phone) {
        return userDao.queryByPhone(phone) != null;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(User user) {
        return this.userDao.insert(user) > 0;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }
}
