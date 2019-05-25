package com.software.pm;

import com.software.pm.common.config.Constants;
import com.software.pm.utils.DateUtils;
import com.software.pm.utils.MD5Utils;
import com.software.pm.utils.StringUtils;
import com.software.pm.utils.UUIDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmApplicationTests {

    @Test
    public void contextLoads() {
        String pw = "";
//        String str = "55ee8c14694a376efbb9f142e9236c69";
        String s = MD5Utils.encrypt(pw);
//        System.out.println(s +"  "+s.length());
        System.out.println(null == s);

//        System.out.println(UUIDUtils.generateShortUUID());
//        System.out.println(StringUtils.getAvatar(str));
//        System.out.println(MD5Utils.toEquals(pw, str));
    }

    @Test
    public void enmuTest() {
//        String key = Constants.Role.ADMIN.getName();
//        String value = Constants.Role.ADMIN.getValue();
//        System.out.println(key +" : "+ value);
        String role = "m";
//        System.out.println(Constants.Role.valueOf(role.toUpperCase()).getName());
//        for (Constants.Gender value : Constants.Gender.values()) {
//            if (value.getValue() == role) {
//                System.out.println(value.getName());
//            }
//        }
        System.out.println(role == "m" ? "男" : "女");
    }

    @Test
    public void dateTest() throws ParseException {
//        String date = "2019-04-20";
//        String date2 = "2019-04-21";
//        System.out.println(DateUtils.toDate(date));
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date begin=simpleDateFormat.parse("2019-05-20");
        Date end=simpleDateFormat.parse("2019-06-21");
        long days=(end.getTime()-begin.getTime())/(1000*3600*24);
        System.out.println("两个日期的差距：" + DateUtils.subtractDays(begin,end));
        System.out.println("两个日期的差距：" + days);

//        simpleDateFormat.setLenient(false);
//        System.out.println(new Date(System.currentTimeMillis()));
//        System.out.println(simpleDateFormat.format(new Date(System.currentTimeMillis())));
//        System.out.println(new Date(new java.util.Date().getTime()));

    }
}
