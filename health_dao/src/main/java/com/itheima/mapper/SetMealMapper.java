package com.itheima.mapper;

import java.util.Map;

import com.github.pagehelper.Page;
import com.itheima.pojo.Setmeal;

public interface SetMealMapper {
	public void add(Setmeal setmeal);
	public void setSetmealAndCheckGroup(Map<String,Integer> map);
	public Page<Setmeal> findByCondition(String queryString);
	
}
