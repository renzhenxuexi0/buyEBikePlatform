package com.softwareEngineering.electrocar.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Ev implements Serializable {
    private static final long serialVersionUID = 799123406402252364L;

    private Integer id;

    private String name;
    /**
     * 品牌和商家名称对应
     */
    private String brand;
    /**
     * 型号
     */
    private String model;
    /**
     * 价格
     */
    private Double price;
    /**
     * 图片
     */
    private String image;
    /**
     * 商家id
     */
    private Integer businessId;

}

