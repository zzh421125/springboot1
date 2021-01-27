package com.example.springboot.demo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @describe： <br/>
 * @date：2021/1/4 <br/>
 * @author:ZhouZiHao
 */
public class ProgramName implements Serializable{
    /**
    * 项目名称
    */
    private String itemName;
    /**
    * 项目百分比
    */
    private BigDecimal percentage;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}
