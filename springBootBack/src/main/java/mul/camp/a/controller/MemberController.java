package mul.camp.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.camp.a.dto.MemberDto;
import mul.camp.a.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;
	
	//아이디 중복확인
	@RequestMapping(value="/getId", method= RequestMethod.POST)
	public String getId(MemberDto dto) {
		System.out.println("MemberController getId");
		
		boolean b = service.getId(dto);
		if(b) {
			return "NO";
		}
		return "OK";
	}
	
	//회원가입
	@RequestMapping(value="/regi", method= RequestMethod.POST)
	public String regi(MemberDto dto) {
		System.out.println("MemberController regi");
		System.out.println(dto.toString());
		
		// insert는 넘어올때 입력됐을경우 1 아닐경우 0으로 돌아옴.
		boolean b = service.regi(dto);
		if(b) {
			return "가입되었습니다.";
		}
		return "실패";
		
	} 
	
	//로그인
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public MemberDto login(MemberDto dto) {
		System.out.println("MemberController login()");
		System.out.println(dto.toString());
		
		//아이디,패스워드 확인 후 받아온 값들을 view로 넘김
		MemberDto mem = service.login(dto);
		System.out.println(mem.toString());
		return mem;
		
	}
	
}
	

