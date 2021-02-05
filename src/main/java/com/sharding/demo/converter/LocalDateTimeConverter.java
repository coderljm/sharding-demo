package com.sharding.demo.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * @Author: jianmin.li
 * @Description: easyexcel LocalDateTime转换器
 * @Date: 2020/7/29 9:28
 * @Version: 1.0
 */
public class LocalDateTimeConverter implements Converter<LocalDateTime> {

    @Override
    public Class supportJavaTypeKey() {
        return LocalDateTime.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public LocalDateTime convertToJavaData(CellData cellData,ExcelContentProperty excelContentProperty,
                                           GlobalConfiguration globalConfiguration) {
        if (Objects.isNull(cellData.getStringValue())) {
            return null;
        }
        return LocalDateTime.parse(cellData.getStringValue(),ofPattern(JSON.DEFFAULT_DATE_FORMAT));
    }

    @Override
    public CellData convertToExcelData(LocalDateTime localDateTime,ExcelContentProperty excelContentProperty,
                                       GlobalConfiguration globalConfiguration) {
        return new CellData<>(localDateTime.format(ofPattern(JSON.DEFFAULT_DATE_FORMAT)));
    }
}
