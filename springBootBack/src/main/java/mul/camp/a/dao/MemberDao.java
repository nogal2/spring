package mul.camp.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.camp.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	
	//아이디 중복확인
	public int getId(MemberDto dto);
	
	//회원가입
	public int regi(MemberDto dto);
	
	//로그인
	public MemberDto login(MemberDto dto);
		
	
}
