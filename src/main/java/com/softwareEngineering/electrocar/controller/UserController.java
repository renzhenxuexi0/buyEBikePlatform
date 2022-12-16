package com.softwareEngineering.electrocar.controller;

import com.softwareEngineering.electrocar.entity.User;
import com.softwareEngineering.electrocar.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 是否存在
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<Boolean> queryByUsername(@PathVariable("username") String username) {
        System.out.println(username);
        return ResponseEntity.ok(this.userService.queryByUsername(username));
    }

    /**
     * 通过手机号查找用户
     *
     * @param phone 手机号
     * @return 是否存在
     */
    @GetMapping("/phone/{phone}")
    public ResponseEntity<Boolean> queryByPhone(@PathVariable("phone") String phone) {
        System.out.println(phone);
        return ResponseEntity.ok(this.userService.queryByPhone(phone));
    }


    /**
     * 通过手机和密码查找用户
     *
     * @param phone    手机号
     * @param password 密码
     * @return 是否存在
     */
    @GetMapping("/phone/{phone}/password/{password}")
    public ResponseEntity<User> queryByPhone(@PathVariable("phone") String phone,
                                             @PathVariable("password") String password,
                                             HttpServletRequest request, HttpServletResponse response) {
        User user = this.userService.queryByPhoneAndPassword(phone, password);
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", user);
        return ResponseEntity.ok(user);
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Boolean> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

