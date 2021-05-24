package com.halo.uitils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Halo
 * @date Created in 2020/12/19  00:06
 * @description
 */
public class JsonUitils {
    public static String getJson(Object object, String dateFormat) {
        ObjectMapper mapper = new ObjectMapper();

        // 使用ObjectMapper格式化日期输出
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 自定义日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(simpleDateFormat);

        Date date = new Date();

        try {
            return mapper.writeValueAsString(date);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJson(Object object) {
        return getJson(object, "yyyy-MM-dd HH:mm:ss");
    }
}
