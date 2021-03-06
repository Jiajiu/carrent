package com.jiu.bus.service;

import com.jiu.bus.domain.Customer;
import com.jiu.bus.vo.CustomerVo;
import com.jiu.sys.utils.DataGridView;

import java.util.List;

/**
 * 客户管理的服务接口
 * @author Jiu
 */
public interface CustomerService {

    /**
     * 加载客户返回DataGridView
     * @param customerVo
     * @return
     */
    public DataGridView queryAllCustomer(CustomerVo customerVo);

    /**
     * 添加客户
     * @param customerVo
     */
    public void addCustomer(CustomerVo customerVo);

    /**
     * 修改客户
     * @param customerVo
     */
    public void updateCustomer(CustomerVo customerVo);

    /**
     * 根据id删除客户
     * @param identity
     */
    public void deleteCustomer(String identity);

    /**
     * 批量删除客户
     * @param identitys
     */
    public void deleteBatchCustomer(String [] identitys);

    /**
     * 根据身份证号查询客户信息
     * @param identity
     * @return
     */
    public Customer queryCustomerByIdentity(String identity);

    /**
     * 查询客户数据返回集合
     * @param customerVo
     * @return
     */
    List<Customer> queryAllCustomerForList(CustomerVo customerVo);
}
