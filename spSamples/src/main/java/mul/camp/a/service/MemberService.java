package mul.camp.a.service;

import java.util.List;

import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.MemberDto;

public interface MemberService {
	
	boolean addmember(MemberDto mem);
	int getId(String id);
	MemberDto login(MemberDto mem);
	
}
