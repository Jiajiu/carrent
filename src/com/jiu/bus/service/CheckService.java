package com.jiu.bus.service;

import com.jiu.bus.vo.CheckVo;
import com.jiu.sys.utils.DataGridView;

import java.util.Map;

/**
 * 检查单的服务接口
 */
public interface CheckService {

    /**
     * 根据出租单号加载检查单的表单数据
     * @param rentid
     * @return
     */
    Map<String,Object> initCheckFormData(String rentid);

    /**
     * 保存检查单信息
     * @param checkVo
     */
    void addCheck(CheckVo checkVo);

    /**
     * 查询
     * @param checkVo
     */
    public DataGridView queryAllCheck(CheckVo checkVo);

    /**
     * 修改检查单的数据
     * @param checkVo
     */
    void updateCheck(CheckVo checkVo);
}
