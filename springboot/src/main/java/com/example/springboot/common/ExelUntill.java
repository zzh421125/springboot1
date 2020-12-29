package com.example.springboot.common;


import com.alibaba.excel.metadata.Sheet;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayEbppInvoiceTaxnoBatchqueryRequest;
import com.alipay.api.response.AlipayEbppInvoiceTaxnoBatchqueryResponse;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * #date：2020/11/9 <br/>
 * #param:  <br/>
 * #return: <br/>
 */
public class ExelUntill {

    private static int total;

    public static int randan(int number){
        Random random = new Random(1);
        int i =0;
            while (true){
                i = random.nextInt(7);
                if(i!=0){
                    break;
            }
        }
        return i;
    }


    //验证服务器地址
  /*  public static String check_Url(HttpServletRequest request){
        //获取参数配置
        String signature = request.getParameter("signature");
        //获取时间托
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        //获取echostr 字符
        String echostr   = request.getParameter("echostr");
        //获取token 此token跟需跟微信公众号的token一致；
        String token = "liftmooc";
        String str = "";
        // try ---- catch 捕捉异常
        try {
            //判断是否为空
            if (null != signature) {
                //声明一个存储数据字符数组
                String[] ArrTmp = { token, timestamp, nonce };
                Arrays.sort(ArrTmp);
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < ArrTmp.length; i++) {
                    sb.append(ArrTmp[i]);
                }
                //获取消息对象
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                //声明一个字节流数组；
                byte[] bytes = md.digest(new String(sb).getBytes());
                //声明一个字符流
                StringBuffer buf = new StringBuffer();
                for (int i = 0; i < bytes.length; i++) {
                    if (((int) bytes[i] & 0xff) < 0x10) {
                        buf.append("0");
                    }
                    buf.append(Long.toString((int) bytes[i] & 0xff, 16));
                }
                if (signature.equals(buf.toString())) {
                    str = echostr;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回消息
        return str;*/







    public static void main(String[] args) {
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal add = zero.add(null);
        System.out.println(add);

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","GBK","alipay_public_key","RSA2");
        AlipayEbppInvoiceTaxnoBatchqueryRequest request = new AlipayEbppInvoiceTaxnoBatchqueryRequest();
        request.setBizContent("{" +
                "\"tax_no\":\"123\"," +
                "      \"invoice_kind_list\":[" +
                "        \"PLAIN\"" +
                "      ]," +
                "\"scene\":\"INVOICE_EXPENSE\"," +
                "\"start_invoice_date\":\"2017-01-11\"," +
                "\"end_invoice_date\":\"2017-07-11\"," +
                "\"limit_size\":20," +
                "\"enable_trade_out\":\"true\"," +
                "\"page_num\":1" +
                "  }");
     /*  AlipayEbppInvoiceTaxnoBatchqueryResponse response = alipayClient.execute(request,accessToken);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }*/
    }

}
