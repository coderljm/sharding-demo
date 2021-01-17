package com.sharding.demo.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @Author: jianmin.li
 * @Description: easyexcel LocalDate转换器
 * @Date: 2020/7/29 9:28
 * @Version: 1.0
 */
public class LocalDateConverter implements Converter<LocalDate> {

    @Override
    public Class supportJavaTypeKey() {
        return LocalDate.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public LocalDate convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty,
                                       GlobalConfiguration globalConfiguration) {
        if (Objects.isNull(cellData.getStringValue())) {
            return null;
        }
        return LocalDate.parse(cellData.getStringValue(), DateTimeFormatter.ISO_DATE);
    }

    @Override
    public CellData<String> convertToExcelData(LocalDate date, ExcelContentProperty excelContentProperty,
                                               GlobalConfiguration globalConfiguration) {
        return new CellData<>(date.format(DateTimeFormatter.ISO_DATE));
    }
}
