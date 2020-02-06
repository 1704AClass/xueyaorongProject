package com.itheima.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.itheima.pojo.OrderSetting;

public interface OrderSettingMapper {

	long findCountByOrderDate(Date orderDate);

	void editNumberByOrderDate(OrderSetting orderSetting);

	void add(OrderSetting orderSetting);

	//预约范围日期
	List<OrderSetting> getOrderSettingByMonth(Map date);

	//预约日期查询你预约
	OrderSetting findByOrderDate(Date date);

	//更新已经预约的人数
	void editReservationsByOrderDate(OrderSetting orderSetting);

}
