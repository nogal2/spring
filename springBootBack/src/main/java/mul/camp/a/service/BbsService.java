package mul.camp.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.camp.a.dao.BbsDao;
import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.BbsParam;
import mul.camp.a.dto.CommentDto;

@Service
@Transactional
public class BbsService {
	
	@Autowired
	BbsDao dao;
	
	// 게시판 불러오기
	public List<BbsDto> getBbsList() {
		return dao.getBbsList();
	}
	
	// 글 작성
	public boolean addWrite(BbsDto dto) {
		int n = dao.addWrite(dto);
		
		return n>0? true:false;
	} 
	
	// 게시글 디테일 불러오기
	public BbsDto bbsDetail(BbsDto seq) {
		return dao.bbsDetail(seq);
	}
	
	// 게시물 검색
	public List<BbsDto> getBbsListSearch(BbsParam param) {
		return dao.getBbsListSearch(param);
	}
	
	public List<BbsDto> getBbsListSearchPage(BbsParam param) {
		return dao.getBbsListSearchPage(param);
	}
	// 게시글의 총수
	public int getBbsCount(BbsParam param) {
		return dao.getBbsCount(param);
	}
	
	// 답글
	public boolean reply(BbsDto dto) {
		 
		dao.replyBbsUpdate(dto);
		int n = dao.replyBbsInsert(dto);
		if(n==0) {
			System.out.println("replyBbsInsert fail");
			return false;
		}else {
			return true;
		}
		
	}
	
	// 수정
	public boolean bbsUpdate(BbsDto dto) {
		int n = dao.bbsUpdate(dto);
		
		return n>0? true:false;
		
	}
	
	//삭제
	public boolean bbsDelect(BbsDto dto) {
		int n = dao.bbsDelect(dto);
		return n>0? true:false;
	}
	
	// 댓글 추가
	public boolean addComment(CommentDto dto) {
		int n = dao.addComment(dto);
		
		return n>0? true:false;
	}
	
	// 댓글 불러오기
	public List<CommentDto> getCommentList(int seq) {
		return dao.getCommentList(seq);
	}
	
}
