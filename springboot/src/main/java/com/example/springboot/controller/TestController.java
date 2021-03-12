package com.example.springboot.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.springboot.common.ZiException;
import com.example.springboot.demo.Type;
import com.example.springboot.demo.TypeLister;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * #date：2020/11/9 <br/>
 * #param:  <br/>
 * #return: <br/>
 */
@Controller
public class TestController {
    @PostMapping("/test")
    public void test(@RequestParam("file") MultipartFile file, @RequestParam("name")
            String name, HttpServletResponse response) throws IOException {
        String originalFilename = file.getOriginalFilename();
        if (!originalFilename.endsWith("xlsx")) {
            throw new ZiException("101", "文件格式不对");
        }
        List<Type> types = EasyExcel.read(file.getInputStream(), Type.class, new TypeLister())
                .sheet().doReadSync();
        List<Type> collect = types.stream().filter(type -> name.equals(type.getName())).collect(Collectors.toList());

        ArrayList<Type> list1 = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            Type type1 = new Type();
            for (Type type : collect) {
                if (i == type.getNumber()) {
                    type1 = type;
                }
            }
            list1.add(type1);
        }
        ClassPathResource classPathResource = new ClassPathResource("/templates/1.xlsx");
        response.setHeader("Content-disposition", "attachment; filename=" + "正大天晴药业工作记录.xlsx");
        response.setContentType("application/msexcel;charset=UTF-8");//设置类型
        response.setHeader("Cache-Control", "no-cache");//设置头
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream(), Type.class).withTemplate(
                classPathResource.getInputStream()).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", TypeLister.date);
        map.put("yourName",name);
        excelWriter.fill(map, writeSheet);
        excelWriter.fill(list1, writeSheet);
        excelWriter.finish();
    }
    @PostMapping("/test2")
    public void test2(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpServletRequest.getFile("file");
        String originalFilename = file.getOriginalFilename();
        if (!originalFilename.endsWith("xlsx")) {
            throw new ZiException("101", "文件格式不对");
        }
        List<Type> types = EasyExcel.read(file.getInputStream(), Type.class, new TypeLister())
                .sheet().doReadSync();
        List<Type> collect = types.stream().filter(type -> name.equals(type.getName())).collect(Collectors.toList());
        ArrayList<Type> list1 = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            Type type1 = new Type();
            for (Type type : collect) {
                if (i == type.getNumber()) {
                    type1 = type;
                }
            }
            list1.add(type1);
        }
        ClassPathResource classPathResource = new ClassPathResource("/templates/1.xlsx");
        String filename = new String(("正大天晴药业集团工作量记录_"+name+"_"+TypeLister.date+".xlsx").getBytes(),"ISO-8859-1");
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType("application/msexcel;charset=UTF-8");//设置类型
        response.setHeader("Cache-Control", "no-cache");//设置头
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream(), Type.class).withTemplate(
                classPathResource.getInputStream()).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", TypeLister.date);
        map.put("yourName",name);
        excelWriter.fill(map, writeSheet);
        excelWriter.fill(list1, writeSheet);
        excelWriter.finish();
    }
    @GetMapping("/")
    public ModelAndView test1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }
}