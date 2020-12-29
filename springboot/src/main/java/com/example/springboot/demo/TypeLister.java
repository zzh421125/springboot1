package com.example.springboot.demo;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * #date：2020/11/10 <br/>
 * #param:  <br/>
 * #return: <br/>
 */
public class TypeLister extends AnalysisEventListener {

    public static String date ;
    List<Type> list = new ArrayList<>();
    private static int count = 1;

    @Override
    public void invoke(Object object, AnalysisContext analysisContext) {
       Type type= (Type) object;
        System.out.println("解析到一条数据:{ "+ type.toString() +" }");
        count++;
        setDate(type.getDate());
        DateFormat format1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = null;
        try {
            date = format1.parse(type.getDate1());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        type.setNumber(calendar.get(Calendar.DAY_OF_MONTH));
        type.setDate1(type.getDate1().split(" ")[1]);
        type.setDate2(type.getDate2().split(" ")[1]);
        type.setMark("√");
        list.add(type);


    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        System.out.println("所有数据解析完成！");
        System.out.println(" count ：" + count);

    }
    /**
     * 设置时间
     */
    private void setDate(String date) {
      if(StringUtils.isEmpty(TypeLister.date)){
          TypeLister.date=date;
      }
    }
}
