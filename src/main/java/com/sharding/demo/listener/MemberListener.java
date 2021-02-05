package com.sharding.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sharding.demo.vo.MemberCheckVO;

import java.math.BigDecimal;

/**
 * <p>
 * 会员提额补数监听器
 * </p>
 *
 * @author lijianmin
 * @since 2021/2/5 10:23
 */
public class MemberListener extends AnalysisEventListener<MemberCheckVO> {
    @Override
    public void invoke(MemberCheckVO data,AnalysisContext context) {
        Long customerId = data.getCustomerId();
        BigDecimal creditAmount = data.getCreditAmount();
        BigDecimal raiseAmount199 = data.getRaiseAmount199();
        if (customerId % 10 < 5) {
            if (raiseAmount199.compareTo(new BigDecimal("3000")) != 0) {
                System.err.println(String.format("customerId:%d , 数额错误",customerId));
            }
        } else {
            if (creditAmount.compareTo(new BigDecimal("3000")) <= 0) {
                if (raiseAmount199.compareTo(new BigDecimal("1000")) != 0) {
                    System.err.println(String.format("customerId:%d , 数额错误",customerId));
                }
            } else if (creditAmount.compareTo(new BigDecimal("3000")) > 0 && creditAmount.compareTo(new BigDecimal(
                    "6000")) <= 0) {
                if (raiseAmount199.compareTo(new BigDecimal("1500")) != 0) {
                    System.err.println(String.format("customerId:%d , 数额错误",customerId));
                }
            } else if (creditAmount.compareTo(new BigDecimal("6000")) > 0 && creditAmount.compareTo(new BigDecimal(
                    "8000")) <= 0) {
                if (raiseAmount199.compareTo(new BigDecimal("2500")) != 0) {
                    System.err.println(String.format("customerId:%d , 数额错误",customerId));
                }
            } else if (creditAmount.compareTo(new BigDecimal("8000")) > 0 && creditAmount.compareTo(new BigDecimal(
                    "10000")) <= 0) {
                if (raiseAmount199.compareTo(new BigDecimal("2000")) != 0) {
                    System.err.println(String.format("customerId:%d , 数额错误",customerId));
                }
            } else {
                if (raiseAmount199.compareTo(new BigDecimal("1500")) != 0) {
                    System.err.println(String.format("customerId:%d , 数额错误",customerId));
                }
            }
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
