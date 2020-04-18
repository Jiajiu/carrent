package com.jiu.bus.service;

import com.jiu.bus.domain.Rent;
import com.jiu.bus.vo.RentVo;
import com.jiu.sys.utils.DataGridView;

public interface RentService {

    /**
     * 保存出租单信息
     * @param rentVo
     */
    void addRent(RentVo rentVo);

    /**
     * 查询出租单
     * @param rentVo
     * @return
     */
    DataGridView queryAllRent(RentVo rentVo);

    /**
     * 修改（更新）出租单
     * @param rentVo
     */
    void updateRent(RentVo rentVo);

    /**
     * 根据出租单id删除出租单
     * @param rentid
     */
    void deleteRent(String rentid);

    /**
     * 根据出租单号查询出租单信息
     * @param rentid
     * @return
     */
    Rent queryRentByRentId(String rentid);
}
