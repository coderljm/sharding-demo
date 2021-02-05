package com.sharding.demo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员购买记录表
 * </p>
 *
 * @author jianmin.li
 * @since 2020-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ColumnWidth(20)
public class InloanMemberPurchaseRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @ExcelProperty(index = 0)
    protected Long id;

    /**
     * 创建时间
     */
    @ExcelProperty(index = 12)
    protected LocalDateTime createAt;

    /**
     * 修改时间
     */
    @ExcelProperty(index = 13)
    protected LocalDateTime updateAt;
    /**
     * 订单号
     */
    @ExcelProperty(index = 1)
    private String orderNo;

    /**
     * 渠道编号
     */
    @ExcelProperty(index = 2)
    private Integer channelId;

    /**
     * 客户编号
     */
    @ExcelProperty(index = 3)
    private Long customerId;

    /**
     * 客户类型 1新客户 2老客户
     */
    @ExcelProperty(index = 4)
    private Integer customerType;

    /**
     * 会员类型
     */
    @ExcelProperty(index = 5)
    private String memberType;

    /**
     * 购买成功时间
     */
    @ExcelProperty(index = 6)
    private LocalDateTime purchaseSuccessTime;

    /**
     * 会员开始日期
     */
    @ExcelProperty(index = 7)
    private LocalDateTime memberStartTime;

    /**
     * 会员结束日期
     */
    @ExcelProperty(index = 8)
    private LocalDateTime memberEndTime;

    /**
     * 提额金额
     */
    @ExcelProperty(index = 9)
    private BigDecimal raiseAmount;

    /**
     * 是否提额成功 0提额失败 1提额成功 默认0
     */
    @ExcelProperty(index = 10)
    private Boolean raiseSuccess;
    /**
     * 提额失败原因
     */
    @ExcelProperty(index = 14)
    private String failReason;
    /**
     * 核心提额业务流水号，提额时由风控生成，降额时需要用该流水号去降额
     */
    @ExcelProperty(index = 11)
    private String bizOrderId;

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteDateUseDateFormat);
    }
}
