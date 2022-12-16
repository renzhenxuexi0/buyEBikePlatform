package com.softwareEngineering.electrocar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business implements Serializable {
    private static final long serialVersionUID = -41759002812998261L;

    private Integer id;
    /**
     * 店铺品牌名
     */
    private String brand;
    /**
     * 后台账号
     */
    private String account;
    /**
     * 后台密码
     */
    private String password;
    /**
     * 商铺地址
     */
    private String address;
    /**
     * 0 代表申请入驻状态 1 代表入驻状态 2 代表撤离状态
     */
    private Integer entrySign;

}

