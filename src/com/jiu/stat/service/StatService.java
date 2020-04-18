package com.jiu.stat.service;

import com.jiu.stat.domain.BaseEntity;

import java.util.List;

/**
 * 统计分析数据的服务接口
 * @author Jiu
 */
public interface StatService {

    /**
     * 查询客户地区的数据
     * @return
     */
    List<BaseEntity> loadCustomerAreaStatList();

    /**
     * 业务员年度统计数据
     * @param year
     * @return
     */
    List<BaseEntity> loadOpernameYearGradeStatList(String year);

    /**
     * 加载公司年度月统计数据
     * @param year
     * @return
     */
    List<Double> loadCompanyYearGradeStatList(String year);

}
