package mul.camp.a.service;

import java.util.List;

import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.BbsParam;

public interface BbsService {
	
	List<BbsDto> bbslist(BbsParam param);
	boolean bbswrite(BbsDto dto);
	BbsDto bbsdetail(int seq);
	void reply(BbsDto dto);
	
	BbsDto rdupdate(int seq);
	boolean update(BbsDto dto);
	
	boolean delete(BbsDto dto);
}
