package com.example.springboot;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.example.springboot.demo.Type;
import com.example.springboot.demo.TypeLister;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Test
	 public void contextLoads() throws FileNotFoundException {
      FileInputStream fileInputStream = new FileInputStream("D:\\1.xlsx");
       //EasyExcel.read(fileInputStream, Type.class, new TypeLister())
        //       .sheet().doRead();
        List<Type> objects = EasyExcel.read(fileInputStream,Type.class, new TypeLister()).sheet().doReadSync();
        for (Type object : objects) {
            System.out.println(object);
        }

        int size = objects.size();
        System.out.println(size+"tIOA");
    }

    @Test
    public void contextLoads1(){
        Type type = new Type();
        type.setDate1("2020-09-09");
        type.setDate2("2020-09-19");
       // type.setDate3("2020-09-09");
        type.setName("aaa");
        type.setMark("ee");
        Type type1 = new Type();
        type1.setDate1("2020-09-9");
        type1.setDate2("2020-09-9");
      //  type1.setDate3("2020-09-9");
        type1.setName("aaa11");
        type1.setMark("ee");
        ArrayList<Type> list = new ArrayList<>();
        list.add(type1);
        list.add(type);

        //FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        //ExcelWriter excelWriter;
      EasyExcel.
                write("D:\\7.xlsx").withTemplate("D:\\11.xlsx").
                sheet().doFill(list);
        /*ExcelWriter writer = EasyExcel.
                write("D:\\7.xlsx").withTemplate("D:\\11.xlsx").build();

        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        writer.fill(list,writeSheet);

       // excelWriter.write(List<Type> list, writeSheet);
      //  excelWriter.sheet().doFill(data())
        writer.finish();*/
    }
}
