package mul.camp.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.BbsParam;
import mul.camp.a.dto.CommentDto;

@Mapper
@Repository
public interface BbsDao {
	
	// 게시판 불러오기
	public List<BbsDto> getBbsList();
	
	// 글 작성
	public int addWrite(BbsDto dto);
	
	//  게시글 디테일 불러오기 
	public BbsDto bbsDetail(BbsDto seq);
	
	// 게시물 검색
	public List<BbsDto> getBbsListSearch(BbsParam param);
	
	
	public List<BbsDto> getBbsListSearchPage(BbsParam param);
	// 게시글의 총수
	public int getBbsCount(BbsParam param);
	
	//답글
	public void replyBbsUpdate(BbsDto dto);
	public int replyBbsInsert(BbsDto dto);
	
	//수정
	public int bbsUpdate(BbsDto dto);
	
	//삭제
	public int bbsDelect(BbsDto dto);
	
	//댓글 추가
	public int addComment(CommentDto dto);
	
	//댓글 불러오기
	public List<CommentDto> getCommentList(int seq);
	
}
