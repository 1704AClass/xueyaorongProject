package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itheima.constant.MessageConstant;
import com.itheima.constant.RedisMessageConstant;
import com.itheima.entity.Result;
import com.itheima.untils.SmsUtils;
import com.itheima.untils.ValidateCodeUtils;

import redis.clients.jedis.JedisPool;


/**
* 短信验证码
*/
@RequestMapping("/validateCode")
@RestController
public class ValidateCodeController {
	/*@Autowired
	private RedisTemplate redisTemplate;*/
	@Autowired 
	private JedisPool jedisPool;
	
	//验证码
	@RequestMapping("/send4Order")
	private Result send4Order(String telephone) {
		System.out.println("发短信");
		System.out.println(telephone+"电话");
		//使用工具类来生成4位验证码
		String code = ValidateCodeUtils.generateValidateCode(4)+"";
		System.out.println(code+"验证码");
		
		try {
			//发送成功
			/*SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,telephone,code.toString());*/
			SmsUtils.sendSms(telephone, code);
		} catch (Exception e) {
			//发动失败
			e.printStackTrace();
			return new Result(false,MessageConstant.SEND_VALIDATECODE_FAIL);
		}
		//放到缓存中
	/*	redisTemplate.boundHashOps("SmsTelephone").put(RedisMessageConstant.SENDTYPE_ORDER,code);*/
		jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_ORDER,5 * 60,code.toString());
		return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
	}
}
