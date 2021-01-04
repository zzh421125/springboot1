package com.example.springboot.demo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

/**
 * #date：2020/10/9 <br/>
 * #param:  <br/>
 * #return: <br/>
 */
public class Type    {
    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 4)
    private String date1;

    @ExcelProperty(index = 5)
    private String date2;
    @ExcelProperty(index = 6)
    private String date;

    @ExcelIgnore
    private Integer number;

    @ExcelIgnore
    private String mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return name+" "+date1+" "+date2;
    }


}
