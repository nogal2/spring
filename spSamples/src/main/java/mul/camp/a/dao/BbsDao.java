package mul.camp.a.dao;

import java.util.List;

import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.BbsParam;

public interface BbsDao {
	
	List<BbsDto> bbslist(BbsParam param);
	int bbswrite(BbsDto dto);
	BbsDto bbsdetail(int seq);
	
	int replyBbsUpdate(BbsDto dto);
	int replyBbsInsert(BbsDto dto);
	
	BbsDto rdupdate(int seq);
	int update(BbsDto dto);
	
	int delete(BbsDto dto);
}
