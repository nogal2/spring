package mul.camp.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mul.camp.a.dto.MemberDto;
import mul.camp.a.service.MemberService;

@Controller
public class MemberController {
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService service;

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("MemberController login()" + new Date());

		return "login";
	}

	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		logger.info("MemberController regi()" + new Date());

		return "regi";
	}

	@RequestMapping(value = "regiAf.do", method = RequestMethod.POST, 
					produces = "application/String; charset=utf-8")
	public String regiAf(MemberDto dto) {
		logger.info("MemberController regiAf()" + new Date());
		System.out.println("id: " + dto);
		boolean b = service.addmember(dto);
		if(b==true) {
			System.out.println("가입되었음");
		}
	//	return "login";
	//	return "login.do"; -> login.do.jsp 로 가게됨
		return "redirect:/login.do"; // 위에 있는 login() 으로 가게됨.

	}

	@ResponseBody
	@RequestMapping(value="idcheck.do", method= RequestMethod.POST,
					produces = "application/String; charset=utf-8")
	public String idcheck(String id) { 
		logger.info("MemberController idcheck()" + new Date());
		System.out.println("id: " + id);
		int count = service.getId(id); 
		System.out.println("count: " + count);
		
		if(count > 0) {
			return "NO";
		}else {
			return "YES";
		}
	}
	
	
	@RequestMapping(value="loginAf.do", method= RequestMethod.POST,
					produces = "application/String; charset=utf-8")
	public String loginAf(MemberDto dto, HttpServletRequest req) { //request == HttpServletRequest req 이걸 넣어주면  session에 접근하도록 해준다.
		logger.info("MemberController loginAf()" + new Date());
		System.out.println(dto);
		
		MemberDto mem = service.login(dto);
		System.out.println(mem);	// pwd null 은 보내주지 않아서 그런거지 없어서 그런게 아님.
		if(mem != null) {	// 정상적인 로그인
			
			//login 정보를 저장 -> session
			req.getSession().setAttribute("login", mem);	// login을 키값, mem을 데이터로 하는것을 session에 저장한다.
			return "redirect:/bbslist.do";
		}
		else {	// 회원 정보에 없음
			return "redirect:/login.do";
		}
		
	}
	

}
