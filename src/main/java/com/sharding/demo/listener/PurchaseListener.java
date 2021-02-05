package com.sharding.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sharding.demo.vo.InloanMemberPurchaseRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 会员购买记录监听器
 * </p>
 *
 * @author lijianmin
 * @since 2021/2/5 14:10
 */
public class PurchaseListener extends AnalysisEventListener<InloanMemberPurchaseRecord> {
    private final List<InloanMemberPurchaseRecord> records = new ArrayList<>(200);

    @Override
    public void invoke(InloanMemberPurchaseRecord data,AnalysisContext context) {
        records.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.err.println(records);
    }
}
