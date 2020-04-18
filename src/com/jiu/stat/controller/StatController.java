package com.jiu.stat.controller;

import com.jiu.bus.domain.Customer;
import com.jiu.bus.domain.Rent;
import com.jiu.bus.service.CustomerService;
import com.jiu.bus.service.RentService;
import com.jiu.bus.vo.CustomerVo;
import com.jiu.stat.domain.BaseEntity;
import com.jiu.stat.service.StatService;
import com.jiu.stat.utils.ExportCustomerUtils;
import com.jiu.stat.utils.ExportRentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计分析
 * @author Jiu
 */
@RequestMapping("stat")
@Controller
public class StatController {

    @Autowired
    private StatService statService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentService rentService;

    /**
     * 跳转到客户地区统计页面
     * @return
     */
    @RequestMapping("toCustomerAreaStat")
    public String toCustomerAreaStat(){
        return "stat/customerAreaStat";
    }

    /**
     * 加载客户地区的统计数据
     * @return
     */
    @RequestMapping("loadCustomerAreaStatJosn")
    @ResponseBody
    public List<BaseEntity> loadCustomerAreaStatJosn(){
        return this.statService.loadCustomerAreaStatList();
    }

    /**
     * 跳转到业务员年度统计页面
     * @return
     */
    @RequestMapping("toOpernameYearGradeStat")
    public String  toOpernameYearGradeStat(){
        return "stat/opernameYearGradeStat";
    }

    /**
     * 加载业务员年度统计数据
     * @param year
     * @return
     */
    @RequestMapping("loadOpernameYearGradeStat")
    @ResponseBody
    public Map<String,Object> loadOpernameYearGradeStat(String year){
        List<BaseEntity> entities=this.statService.loadOpernameYearGradeStatList(year);
        Map<String,Object> map=new HashMap<>();
        List<String> names=new ArrayList<>();
        List<Double> values=new ArrayList<>();
        for(BaseEntity baseEntity:entities){
            names.add(baseEntity.getName());
            values.add(baseEntity.getValue());
        }
        map.put("name",names);
        map.put("value",values);
        return map;
    }

    /**
     * 跳转到公司年度月统计数据页面
     * @return
     */
    @RequestMapping("toCompanyYearGradeStat")
    public String toCompanyYearGradeStat(){
        return "stat/companyYearGradeStat";
    }

    /**
     * 加载业务员年度每月统计数据
     * @param year
     * @return
     */
    @RequestMapping("loadCompanyYearGradeStat")
    @ResponseBody
    public List<Double> loadCompanyYearGradeStat(String year){
        List<Double> entities=this.statService.loadCompanyYearGradeStatList(year);
        for(int i=0;i<entities.size();i++){
            if(null==entities.get(i)){
                entities.set(i,0.0);
            }
        }
        return entities;
    }

    /**
     * 导出客户信息数据
     * @param customerVo
     * @param response
     * @return
     */
    @RequestMapping("exportCustomer")
    public ResponseEntity<Object> exportCustomer(CustomerVo customerVo, HttpServletResponse response){
        List<Customer> customers=customerService.queryAllCustomerForList(customerVo);
        String fileName="客户数据.xls";
        String sheetName="客户数据";
        ByteArrayOutputStream bos= ExportCustomerUtils.exportCustomer(customers,sheetName);

        return getResponseEntity(fileName, bos);
    }

    /**
     * 导出出租单
     * @param rentid
     * @return
     */
    @RequestMapping("exportRent")
    public ResponseEntity<Object> exportRent(String rentid){
        //根据出租单号查询出租单信息
        Rent rent=rentService.queryRentByRentId(rentid);
        //根据身份证号查询客户信息
        Customer customer=customerService.queryCustomerByIdentity(rent.getIdentity());


        String fileName=customer.getCustname()+"-的出租单.xls";
        String sheetName=customer.getCustname()+"+出租单";
        ByteArrayOutputStream bos= ExportRentUtils.exportRent(rent,customer,sheetName);
        return getResponseEntity(fileName, bos);
    }

    private ResponseEntity<Object> getResponseEntity(String fileName, ByteArrayOutputStream bos) {
        try {
            fileName= URLEncoder.encode(fileName,"UTF-8");//处理文件名乱码
            //创建封装响应头信息的对象
            HttpHeaders headers=new HttpHeaders();
            //封装响应内容类型(APPLICATION_OCTET_STREAM响应的内容不限定）
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //设置下载的文件名的名称
            headers.setContentDispositionFormData("attachment",fileName);
            return new ResponseEntity<Object>(bos.toByteArray(),headers, HttpStatus.CREATED);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
