package com.sharding.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.sharding.demo.converter.LocalDateConverter;
import com.sharding.demo.converter.LocalDateTimeConverter;
import com.sharding.demo.listener.ExcelListener;
import com.sharding.demo.listener.MemberListener;
import com.sharding.demo.listener.PurchaseListener;
import com.sharding.demo.vo.ExcelVo;
import com.sharding.demo.vo.InloanMemberPurchaseRecord;
import com.sharding.demo.vo.MemberCheckVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * @Author: jianmin.li
 * @Description: excel控制器
 * @Date: 2021/1/17 21:07
 * @Version: 1.0
 */
@RestController
@RequestMapping("/excel")
@CrossOrigin
public class ExcelController {
    /**
     * 导入并解析excel
     *
     * @param file excel文件
     * @author jianmin.li
     * @date 2021/1/17 21:07
     */
    @PostMapping("/upload")
    public void upload(MultipartFile file) throws IOException {
        EasyExcel
                // 将数据映射到Student实体类，并由自定义的分析事件监听处理数据
                .read(new BufferedInputStream(file.getInputStream()),ExcelVo.class,new ExcelListener())
                // 表头最大行数
                .headRowNumber(1)
                // 是否对单元格内容自动去除两边的空格
                .autoTrim(Boolean.TRUE)
                // 是否自动关闭输入流
                .autoCloseStream(Boolean.TRUE)
                // excel保护密码
                // .password("123456")
                // 是否跳过空行，默认是true
                .ignoreEmptyRow(Boolean.TRUE)
                // 开始导入
                .doReadAll();
    }

    @PostMapping("/memberCheck")
    public void memberCheck(MultipartFile file) throws IOException {
        EasyExcel
                // 将数据映射到Student实体类，并由自定义的分析事件监听处理数据
                .read(new BufferedInputStream(file.getInputStream()),MemberCheckVO.class,new MemberListener())
                // 表头最大行数
                .headRowNumber(1)
                // 是否对单元格内容自动去除两边的空格
                .autoTrim(Boolean.TRUE)
                // 是否自动关闭输入流
                .autoCloseStream(Boolean.TRUE)
                // excel保护密码
                // .password("123456")
                // 是否跳过空行，默认是true
                .ignoreEmptyRow(Boolean.TRUE)
                // 开始导入
                .sheet(1)
                .doRead();
    }

    @PostMapping("/purchase")
    public void purchase(MultipartFile file) throws IOException {
        EasyExcel
                // 将数据映射到Student实体类，并由自定义的分析事件监听处理数据
                .read(new BufferedInputStream(file.getInputStream()),InloanMemberPurchaseRecord.class,
                        new PurchaseListener())
                // 表头最大行数
                .headRowNumber(1)
                // 是否对单元格内容自动去除两边的空格
                .autoTrim(Boolean.TRUE)
                // 是否自动关闭输入流
                .autoCloseStream(Boolean.TRUE)
                .registerConverter(new LocalDateConverter())
                .registerConverter(new LocalDateTimeConverter())
                // excel保护密码
                // .password("123456")
                // 是否跳过空行，默认是true
                .ignoreEmptyRow(Boolean.TRUE)
                // 开始导入
                .doReadAll();
    }
}
