package com.sharding.demo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sharding.demo.converter.LocalDateTimeConverter;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: jianmin.li
 * @Description: 定义excel实体类
 * @Date: 2019/8/29 16:24
 * @Version: 1.0
 */
@Data
@ColumnWidth(20)
public class ExcelVo {
    @ExcelProperty(index = 0, value = "id")
    private Long id;
    @ExcelProperty(index = 1, value = "member_start_time", converter = LocalDateTimeConverter.class)
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime memberStartTime;
    @ExcelProperty(index = 2, value = "member_end_time", converter = LocalDateTimeConverter.class)
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime memberEndTime;
    @ExcelProperty(index = 3, value = "biz_order_id")
    private String bizOrderId;

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteDateUseDateFormat);
    }
}
