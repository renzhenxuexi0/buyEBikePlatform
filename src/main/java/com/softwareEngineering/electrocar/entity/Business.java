package com.softwareEngineering.electrocar.entity;

import lombok.Data;

import java.io.Serializable;

@Data
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
     * 0代表撤离状态1代表入驻状态
     */
    private Integer entrySign;

}

