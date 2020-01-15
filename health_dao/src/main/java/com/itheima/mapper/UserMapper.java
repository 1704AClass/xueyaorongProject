package com.itheima.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itheima.pojo.User;


public interface UserMapper {
	@Select("select * from user")
	List<User> list();

}
