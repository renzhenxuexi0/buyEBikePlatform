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
     * 支付状态 0 表示未处理的直接购买订单 1 表示未处理的以旧换新购买订单
     * 2 表示以接受的直接购买的订单 3 表示以接受的以旧换新的订单
     * 4 表示拒绝的... 5 表示拒绝的
     */
    private Integer payingSign;
    /**
     * 用户id
     */
    private Integer userId;


}

