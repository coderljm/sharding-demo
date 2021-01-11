package com.sharding.demo.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author: jianmin.li
 * @Description: 自定义连接池健康检查,避免springboot2.3.X版本启动报健康检查失败异常
 * @Date: 2021/1/12 0:47
 * @Version: 1.0
 */
@Configuration
public class DataSourceHealthConfig extends DataSourceHealthContributorAutoConfiguration {
    public DataSourceHealthConfig(Map<String, DataSource> dataSources,
                                  ObjectProvider<DataSourcePoolMetadataProvider> metadataProviders) {
        super(dataSources,metadataProviders);
    }

    @Override
    protected AbstractHealthIndicator createIndicator(DataSource source) {
        DataSourceHealthIndicator indicator = (DataSourceHealthIndicator) super.createIndicator(source);
        if (!StringUtils.hasText(indicator.getQuery())) {
            indicator.setQuery("select 1");
        }
        return indicator;
    }
}
