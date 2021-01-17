package com.sharding.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.sharding.demo.vo.ExcelVo;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: jianmin.li
 * @Description: 自定义分析事件监听
 * @Date: 2019/8/29 16:29
 * @Version: 1.0
 */
public class ExcelListener extends AnalysisEventListener<ExcelVo> {
    private final List<ExcelVo> list = new ArrayList<>();
    private final StringBuffer buffer = new StringBuffer();

    /**
     * 一行一行的读取数据，将数据放到集合，批量处理
     *
     * @param excelVo
     * @param analysisContext
     * @return : void
     * @Author: jianmin.li
     * @Date: 2019/10/23 9:59
     */
    @Override
    public void invoke(ExcelVo excelVo,AnalysisContext analysisContext) {
        // list.add(excelVo);
        // if (list.size() == 2) {
        //     doSomething();
        // }
        Duration duration = Duration.between(excelVo.getMemberStartTime(),excelVo.getMemberEndTime());
        LocalDateTime time = excelVo.getMemberStartTime().plusDays(duration.toDays() + NumberUtils.LONG_ONE);
        String dueTime = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String sql = buffer.append("update xxx set due_time = '").append(dueTime).append("' where biz_order_id = '")
                .append(excelVo.getBizOrderId()).append("';").toString();
        System.err.println(sql);
        buffer.setLength(0);
    }

    private void doSomething() {
        for (ExcelVo excelVo : list) {
            System.err.println(excelVo);
        }
        list.clear();
    }

    /**
     * 数据读取完进行的操作
     *
     * @param analysisContext
     * @return : void
     * @Author: jianmin.li
     * @Date: 2019/10/23 10:05
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if (list.size() > 0) {
            doSomething();
        }
    }

    /**
     * 获取表头信息
     *
     * @param headMap
     * @param context
     * @return : void
     * @Author: jianmin.li
     * @Date: 2019/10/23 10:06
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap,AnalysisContext context) {
        System.err.println(JSON.toJSONString(headMap));
        Integer sheetNo = context.readSheetHolder().getReadSheet().getSheetNo();
        System.err.println(sheetNo);
    }
}
