package com.jiu.bus.service;

import com.jiu.bus.domain.Car;
import com.jiu.bus.vo.CarVo;
import com.jiu.sys.utils.DataGridView;

/**
 * 车辆管理的服务接口
 * @author Jiu
 */
public interface CarService {

    /**
     * 查询所有车辆
     * @param carVo
     * @return
     */
    public DataGridView queryAllCar(CarVo carVo);

    /**
     * 添加车辆
     * @param carVo
     */
    void addCar(CarVo carVo);

    /**
     * 修改车辆
     * @param carVo
     */
    public void updateCar(CarVo carVo);

    /**
     * 根据车牌号查询
     * @param carnumber
     * @return
     */
    public Car queryCarByCarNumber(String carnumber);

    /**
     * 根据车牌号删除车辆
     * @param carnumber
     */
    public void deleteCar(String carnumber);

    /**
     * 批量删除车辆
     * @param carnumbers
     */
    public void deleteBatchCar(String [] carnumbers);
}
