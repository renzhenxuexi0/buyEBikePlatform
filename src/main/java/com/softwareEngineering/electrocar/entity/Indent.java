package com.softwareEngineering.electrocar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

