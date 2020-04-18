package com.jiu.bus.mapper;

import com.jiu.bus.domain.Rent;

import java.util.List;

public interface RentMapper {
    int deleteByPrimaryKey(String rentid);

    int insert(Rent record);

    int insertSelective(Rent record);

    Rent selectByPrimaryKey(String rentid);

    int updateByPrimaryKeySelective(Rent record);

    int updateByPrimaryKey(Rent record);

    //查询出租单
    public List<Rent> queryAllRent(Rent rent);
}
