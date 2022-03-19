package mul.camp.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.camp.a.dao.MemberDao;
import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao dao;
	
	@Override
	public boolean addmember(MemberDto mem) {
		
		int count = dao.addmember(mem);
		
		return count>0 ? true:false;	// 0보다 컸을때는 true, 0보다 크지 않았을때는 false
	}
	
	@Override
	public int getId(String id) {
		return dao.getId(id);
		
	}

	@Override
	public MemberDto login(MemberDto mem) {
		
		return dao.login(mem);
	}

	

	

	
	
}
