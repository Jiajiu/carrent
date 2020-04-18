package com.jiu.bus.controller;

import com.jiu.bus.domain.Rent;
import com.jiu.bus.service.CheckService;
import com.jiu.bus.service.RentService;
import com.jiu.bus.vo.CheckVo;
import com.jiu.sys.utils.DataGridView;
import com.jiu.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * 检查单管理的控制器
 */
@RestController
@RequestMapping("check")
public class CheckController {

    @Autowired
    private CheckService checkService;

    @Autowired
    private RentService rentService;

    /**
     * 根据出租单号查询出租单信息
     * @param rentid
     * @return
     */
    @RequestMapping("checkRentExist")
    public Rent checkRentExist(String rentid){
        Rent rent=this.rentService.queryRentByRentId(rentid);//null /对象
        return rent;
    }

    /**
     * 根据出租单号加载检查单的表单数据
     * @param rentid
     * @return
     */
    @RequestMapping("initCheckFormData")
    public Map<String,Object> initCheckFormData(String rentid){
        return this.checkService.initCheckFormData(rentid);
    }

    /**
     * 保存检查单数据
     * @param checkVo
     * @return
     */
    @RequestMapping("saveCheck")
    public ResultObj saveCheck(CheckVo checkVo){
        try{
            checkVo.setCreatetime(new Date());
            this.checkService.addCheck(checkVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_FAILED;
        }
    }

    /**
     * 查询
     * @param checkVo
     * @return
     */
    @RequestMapping("loadAllCheck")
    public DataGridView loadAllCheck(CheckVo checkVo){
        return this.checkService.queryAllCheck(checkVo);
    }

    /**
     * 修改检查单数据
     * @param checkVo
     * @return
     */
    @RequestMapping("updateCheck")
    public ResultObj updateCheck(CheckVo checkVo){
        try{
            this.checkService.updateCheck(checkVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_FAILED;
        }
    }
}
