package mul.camp.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.BbsParam;
import mul.camp.a.dto.CommentDto;
import mul.camp.a.service.BbsService;

@RestController
public class BbsController {
	
	@Autowired
	BbsService service;
	
	// 게시물 불러오기
	@RequestMapping(value="/getBbsList", method= {RequestMethod.POST, RequestMethod.GET} )
	public List<BbsDto> getBbsList() {
		System.out.println("BbsController getBbsList "+ new Date());
		
		List<BbsDto> list = service.getBbsList();
		System.out.println(list.toString());
		return list;		
	}
	
	// 게시물 쓰기
	@RequestMapping(value="/addWrite", method= {RequestMethod.POST, RequestMethod.GET})
	public String addWrite(BbsDto dto) {
		System.out.println("BbsController addWrite "+ new Date());
		System.out.println(dto.toString());
		
		boolean b = service.addWrite(dto);
		if(b) {
			return "yes";
		} else {
			return "no";
		}
		
	}
	
	// 게시글 디테일 불러오기 
	@RequestMapping(value="/bbsDetail", method= {RequestMethod.POST, RequestMethod.GET} )
	public BbsDto bbsDetail(BbsDto seq) {
		System.out.println("BbsController bbsDetail "+ new Date());
		System.out.println("시퀀스 번호: " +seq.getSeq());
		System.out.println(seq.toString());
		
		return service.bbsDetail(seq);
		
	}
	
	// 게시물 검색(페이징이 안들어간것, 모바일용)
	@RequestMapping(value="/getBbsListSearch", method= {RequestMethod.POST, RequestMethod.GET} )
	public List<BbsDto> getBbsListSearch(BbsParam param) {
		System.out.println("BbsController getBbsListSearch "+ new Date());
		return service.getBbsListSearch(param);
	}
	
	// 특정 범위에 들어가있는 글
	@RequestMapping(value="/getBbsListSearchPage", method= {RequestMethod.POST, RequestMethod.GET} )
	public List<BbsDto> getBbsListSearchPage(BbsParam param) {
		System.out.println("BbsController getBbsListSearchPage "+ new Date());
		
		//페이지 설정
		int sn = param.getPage();	// 0   1    2    3 ~ 현재 페이지
		int start = sn*10 +1;		// 1   11	21   31
		int end = (sn + 1) * 10;	// 10  20	30   40
		param.setStart(start);
		param.setEnd(end);
		
		return service.getBbsListSearchPage(param);
		
	}
	
	// 게시글의 총수
	@RequestMapping(value="/getBbsCount", method= {RequestMethod.POST, RequestMethod.GET} )
	public int getBbsCount(BbsParam param) {
		System.out.println("BbsController getBbsCount "+ new Date());
		return service.getBbsCount(param);
	}
	
	// 답글
	@RequestMapping(value="/answer", method= {RequestMethod.POST, RequestMethod.GET} )
	public String answer(BbsDto dto) {
		System.out.println("BbsController answer "+ new Date());
		System.out.println(dto.toString());
		
		boolean b=service.reply(dto);
		
		if(b) {
			return "완료";
		} else {
			return "실패";
		}
		
	}
	
	// 수정
	@RequestMapping(value="/bbsUpdate", method= {RequestMethod.POST, RequestMethod.GET} )
	public String bbsUpdate(BbsDto dto) {
		System.out.println("BbsController bbsUpdate "+ new Date());
		System.out.println(dto.toString());
		
		boolean b = service.bbsUpdate(dto);
		
		if(b) {
			return "완료";
		}else {
			return "실패";
		}
		
	}
	
	// 삭제
	@RequestMapping(value="/bbsDelect", method= {RequestMethod.POST, RequestMethod.GET} )
	public String bbsDelect(BbsDto dto) {
		System.out.println("BbsController bbsDelect "+ new Date());
		System.out.println(dto.toString());
		
		boolean b = service.bbsDelect(dto);
		if(b) {
			return "완료";
		}else {
			return "실패";
		}
	}
	
	// 댓글 추가
	@RequestMapping(value="/addComment", method= {RequestMethod.POST, RequestMethod.GET} )
	public String addComment(CommentDto dto) {
		System.out.println("BbsController addComment "+ new Date());
		System.out.println(dto.toString());
		
		boolean b = service.addComment(dto);
		if(b) {
			return "완료";
		} else {
			return "실패";
		}
	}
	
	// 댓글 목록 불러오기
	@RequestMapping(value="/getCommentList", method= {RequestMethod.POST, RequestMethod.GET} )
	public List<CommentDto> getCommentList(int seq) {
		System.out.println("BbsController getCommentList "+ new Date());
		System.out.println(seq);
		
		List<CommentDto> list = service.getCommentList(seq);
		return list;
		
	}
}
