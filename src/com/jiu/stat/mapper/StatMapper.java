package com.jiu.stat.mapper;

import com.jiu.stat.domain.BaseEntity;

import java.util.List;

public interface StatMapper {

    /**
     * 查询客户地区的数据统计
     * @return
     */
    List<BaseEntity> queryCustomerAreaStat();

    /**
     * 查询业务员年度的业绩统计
     * @param year
     * @return
     */
    List<BaseEntity> queryOpernameYearGradeStat(String year);

    /**
     * 加载公司年度月统计数据
     * @param year
     * @return
     */
    List<Double> queryCompanyYearGradeStat(String year);
}
