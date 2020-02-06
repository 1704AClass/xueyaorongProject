package com.itheima.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.mapper.MemberMapper;
import com.itheima.pojo.Member;
import com.itheima.service.MemberService;
import com.itheima.utils.MD5Utils;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper memberMapper;
	
	//根据手机号查询会员
	public Member findByTelephone(String telephone) {
		// TODO Auto-generated method stub
		return memberMapper.findByTelephone(telephone);
	}
	//新增会员
	public void add(Member member) {
		// TODO Auto-generated method stub
		if(member.getPassword() != null){
			member.setPassword(MD5Utils.md5(member.getPassword()));
		}
		memberMapper.add(member);
	}
	/*public Member findOne(String username) {
		return memberMapper.findOne(username);
	}*/
	/**
	* 会员数量统计
	*/
	/*public List<Integer> findMemberCountByMonth(List<String> month) {
		List<Integer> list = new ArrayList();
		for (String m : month) {
			//拼接日期格式
			m = m + ".31";
			Integer count = memberMapper.findMemberCountBeforeDate(m);
			list.add(count);
		}
		return list;
	}*/
}
