package com.fantow.springmvc.HelloWorld;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.Authenticator.Success;

@Controller
public class SpringMVCHandler {

	
	
	
	@RequestMapping("/textRedirect")
	public String test7() {
		System.out.println("进行重定向");
		return "redirect:https://www.baidu.com";
	}
	
	@RequestMapping("/testMap")
	public String test6(Map<String, Object> map) {
		System.out.println(map.getClass().getName());
		map.put("password", "123456");
		return "success";
	}
	
	
	@RequestMapping("/testModelAndView")
	public ModelAndView test5() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", "Tom");
		mav.setViewName("success");
		return mav;
	}
	
	
	@RequestMapping("/testPostForm")
	public String test4(User user) {
		System.out.println(user);
		return "success";
	}
	
	
	
	
	@RequestMapping("/testRequestCookieValue")
	public String test3(@CookieValue("JSESSIONID")String jession) {
		System.out.println("Jession: "+jession);
		return "success";
	}
	
	
	@RequestMapping("/testRequestHeader")
	public String test2(@RequestHeader("accept-language")String acceptLanguage) {
		System.out.println("header: "+acceptLanguage);
		return "success";
	}
	
	
	@RequestMapping(value="/testRequestParam")
	public String testGetParam(String username,@RequestParam(required=false,defaultValue="10")int age) {
		System.out.println(username +" , "+age);
		return "success";
	}
	
	
	@RequestMapping(value="/order/{id}",method=RequestMethod.GET)
	public String testRESTGET(@PathVariable("id") Integer id) {
		System.out.println("GET: "+id);
		return "success";
	}
	
	
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String testRESTPost(){
		System.out.println("Post" );
		return "success";
	}
	
	@RequestMapping(value="/order/{id}",method=RequestMethod.DELETE)
	public String testRESTDelete(@PathVariable("id") Integer id) {
		System.out.println("Delete: "+id);
		return "success";
	}
	
	@RequestMapping(value="/order",method=RequestMethod.PUT)
	public String testRESTPut() {
		System.out.println("Put ");
		return "success";
	}
	
	
	
	@RequestMapping("/hello")
	public String HelloHandler() {
		System.out.println("执行HelloHandler");
		return "success";
	}
	
	
	@RequestMapping(value="/testRequestMappingParamsAndHeaders",params= {"username","age"})
	public String testRquestMapping() {
		System.out.println("访问方法成功!");
		return "success";
	}
	
	
	@RequestMapping(value="/test/{id}")
	public String test1(@PathVariable("id") Integer id) {
		
		System.out.println("get test: "+id);
		return "success";
		
	}
	
	
	
}
