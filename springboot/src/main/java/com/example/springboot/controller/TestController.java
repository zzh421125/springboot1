package com.example.springboot.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.springboot.common.ZiException;
import com.example.springboot.demo.ProgramName;
import com.example.springboot.demo.QryExelDTO;
import com.example.springboot.demo.Type;
import com.example.springboot.demo.TypeLister;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #date：2020/11/9 <br/>
 * #param:  <br/>
 * #return: <br/>
 */
@Controller
public class TestController {

    @PostMapping("/test")
    public void test(@RequestParam("file") MultipartFile file, @RequestParam("name")
            String name ,HttpServletResponse response) throws IOException {
        String originalFilename = file.getOriginalFilename();
        if (!originalFilename.endsWith("xlsx")) {
            throw new ZiException("101", "文件格式不对");
        }
        List<Type> types = EasyExcel.read(file.getInputStream(), Type.class, new TypeLister())
                .sheet().doReadSync();

        //校验百分比是否100
    /*    List<ProgramName> programs = qryExelDTO.getPrograms();

        if(!CollectionUtils.isEmpty(programs)){
            //上班总天数
            Integer workdaysize = list.size();
            BigDecimal tatal = new BigDecimal(workdaysize);
            BigDecimal tatalDay=BigDecimal.ZERO;
            for (ProgramName program : programs) {
                BigDecimal bigDecimal = tatal.multiply(program.getPercentage()).divide(new BigDecimal("100"), BigDecimal.ROUND_HALF_UP);
                program.setPercentage(bigDecimal);
                tatalDay.add(bigDecimal);
            }
            if (!(tatal.compareTo(tatalDay)==0)) {
                throw new ZiException("10100", "百分比之和不等于100");
            }

            //将name换成itemName
            for (ProgramName program : programs) {
                int number = program.getPercentage().intValue();
                for (int i = 0; i < number; i++) {
                    list.get(i).setName(program.getItemName());
                }
            }
        }*/

        ArrayList<Type> list1 = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            Type type1 = new Type();
            for (Type type : types) {
                if (i == type.getNumber()) {
                    type1 = type;
                }
            }
            list1.add(type1);
        }


        ClassPathResource classPathResource = new ClassPathResource("/templates/1.xlsx");
        String path = classPathResource.getFile().getPath();
        response.setHeader("Content-disposition", "attachment; filename=" + "1.xlsx");
        response.setContentType("application/msexcel;charset=UTF-8");//设置类型
        response.setHeader("Cache-Control", "no-cache");//设置头

        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream(), Type.class).withTemplate(path).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", TypeLister.date);
        excelWriter.fill(map, writeSheet);
        excelWriter.fill(list1, writeSheet);
        excelWriter.finish();

    }

    @GetMapping("/")
    public String test1() {
        return "test";
    }
}