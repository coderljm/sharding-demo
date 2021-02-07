package com.sharding.demo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 会员提额补数校验
 * </p>
 *
 * @author lijianmin
 * @since 2021/2/5 10:18
 */
@Data
@ColumnWidth(20)
public class MemberCheckVO {
    @ExcelProperty(index = 0)
    private Long customerId;
    @ExcelProperty(index = 5)
    private BigDecimal creditAmount;
    @ExcelProperty(index = 6)
    private BigDecimal raiseAmount199;
    @ExcelProperty(index = 2)
    private String idCard;
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
