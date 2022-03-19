package mul.camp.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.camp.a.dao.BbsDao;
import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.BbsParam;

@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> bbslist(BbsParam param) {
		return dao.bbslist(param);
	}

	@Override
	public boolean bbswrite(BbsDto dto) {
		
		int count = dao.bbswrite(dto);
		return count > 0 ? true:false;
	}

	@Override
	public BbsDto bbsdetail(int seq) {
		
		return dao.bbsdetail(seq);
	}

	@Override
	public void reply(BbsDto dto) {
		int n = dao.replyBbsUpdate(dto);
		if(n==0) {
			System.out.println("replyBbsUpdate fail~");
		}
		
		n=dao.replyBbsInsert(dto);
		if(n==0) {
			System.out.println("replyBbsInsert fail~");
		}
		
	}

	@Override
	public BbsDto rdupdate(int seq) {
		
		return dao.rdupdate(seq);
	}

	@Override
	public boolean update(BbsDto dto) {
		
		int n = dao.update(dto);
		return n > 0 ? true:false;
		
	}

	@Override
	public boolean delete(BbsDto dto) {
		int n = dao.delete(dto);
		return n > 0 ? true:false;
	}

	
	
	
	
}
