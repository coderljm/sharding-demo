package com.sharding.demo.handler;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.context.annotation.Configuration;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @Author: jianmin.li
 * @Description: LocalDateTimeTypeHandler,为了让mybatis支持localDateTime
 * @Date: 2021/1/12 1:01
 * @Version: 1.0
 */
@Configuration
//定义转换器支持的JAVA类型
@MappedTypes(LocalDate.class)
//定义转换器支持的数据库类型
@MappedJdbcTypes(value = JdbcType.TIMESTAMP, includeNullJdbcType = true)
public class LocalDateTypeHandler extends BaseTypeHandler<LocalDate> {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(JSON.DEFFAULT_DATE_FORMAT);

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement,int i,LocalDate localDate,
                                    JdbcType jdbcType) throws SQLException {
        if (Objects.nonNull(localDate)) {
            preparedStatement.setString(i,dateTimeFormatter.format(localDate));
        }
    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet,String columnName) throws SQLException {
        String target = resultSet.getString(columnName);
        return StringUtils.isBlank(target) ? null : LocalDate.parse(target,dateTimeFormatter);
    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet,int columnIndex) throws SQLException {
        String target = resultSet.getString(columnIndex);
        return StringUtils.isBlank(target) ? null : LocalDate.parse(target,dateTimeFormatter);
    }

    @Override
    public LocalDate getNullableResult(CallableStatement callableStatement,int columnIndex) throws SQLException {
        String target = callableStatement.getString(columnIndex);
        return StringUtils.isBlank(target) ? null : LocalDate.parse(target,dateTimeFormatter);
    }
}
