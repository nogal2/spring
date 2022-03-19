package mul.camp.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {
	
	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> bbslist(BbsParam param) {
		
		return session.selectList(ns+"bbslist", param);
	}

	@Override
	public int bbswrite(BbsDto dto) {
		
		int count = session.insert(ns+"writebbs", dto);
		
		return count;
	}

	@Override
	public BbsDto bbsdetail(int seq) {
		return session.selectOne(ns+"detailbbs", seq);
	}

	@Override
	public int replyBbsUpdate(BbsDto dto) {
		int n = session.update(ns+"replyBbsUpdate", dto);
		return n;
	}

	@Override
	public int replyBbsInsert(BbsDto dto) {
		int n = session.insert(ns+"replyBbsInsert", dto);
		return n;
	}

	@Override
	public BbsDto rdupdate(int seq) {
		
		return session.selectOne(ns + "rdupdate", seq);
	}

	@Override
	public int update(BbsDto dto) {
		int n = session.update(ns+"bbsupdate", dto);
		return n;
	}

	@Override
	public int delete(BbsDto dto) {
		int n = session.delete(ns+"bbsdelete", dto);
		return n;
	}

	
	
	
}
