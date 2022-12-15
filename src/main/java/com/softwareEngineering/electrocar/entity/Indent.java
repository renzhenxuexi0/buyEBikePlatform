package com.softwareEngineering.electrocar.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Indent implements Serializable {
    private static final long serialVersionUID = 154697950890432485L;

    private Integer id;
    /**
     * 电动车的id
     */
    private Integer evId;
    /**
     * 是否已经付款
     */
    private Integer payingSign;
    /**
     * 用户id
     */
    private Integer userId;


}

