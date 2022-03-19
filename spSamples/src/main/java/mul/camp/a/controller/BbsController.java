package mul.camp.a.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.camp.a.dao.BbsDao;
import mul.camp.a.dto.BbsDto;
import mul.camp.a.dto.BbsParam;
import mul.camp.a.service.BbsService;

	@Controller
	public class BbsController {
		private static Logger logger = LoggerFactory.getLogger(BbsController.class);
		
		@Autowired
		BbsService service;
		
		@RequestMapping(value="bbslist.do", method= RequestMethod.GET)
		public String bbslist(Model model, BbsParam param) {
			logger.info("BbsController bbslist()" + new Date());
			
			List<BbsDto> list = service.bbslist(param);
			model.addAttribute("bbslist", list);
			
			return "bbslist";
		}
		
		@RequestMapping(value="bbswrite.do", method= RequestMethod.GET)
		public String bbswrite() {
			logger.info("BbsController bbswrite()" + new Date());
			
			return "bbswrite";
		}
		
		@RequestMapping(value="bbswriteAf.do", method= RequestMethod.POST,
						produces = "application/String; charset=utf-8")
		public String bbswriteAf(BbsDto dto) {
			logger.info("BbsController bbswriteAf()" + new Date());
		//	System.out.println(dto.toString()); 먼저 테스트하기.
			boolean b = service.bbswrite(dto);
			if(b==true) {
				System.out.println("게시글이 작성되었습니다.");
				return "redirect:/bbslist.do";
			}
			else {
				return "bbswrite.do";
			}
			
		}
		
		@RequestMapping(value="bbsdetail.do", method= RequestMethod.GET,
							produces = "application/String; charset=utf-8")
		public String bbsdetail(Model model, int seq) {
			logger.info("BbsController bbsdetail()" + new Date());
			System.out.println("seq= "+seq);
			
			//DB-> BbsDto
			BbsDto bbs = service.bbsdetail(seq);
			
			//model
			model.addAttribute("bbs", bbs);
			
			
			return "bbsdetail";
		}
		
	
		
		@RequestMapping(value="answer.do", method= RequestMethod.GET,
				produces = "application/String; charset=utf-8")
		public String answer (Model model, int seq) {
			logger.info("BbsController answer()" + new Date());
			
			//DB-> BbsDto
			BbsDto bbs = service.bbsdetail(seq);
			
			//model
			model.addAttribute("bbs", bbs);
			
			return "bbsanswer";
		}
		
		@RequestMapping(value="answerAf.do", method= RequestMethod.GET,
						produces = "application/String; charset=utf-8")
		public String answerAf(BbsDto dto) {	//BbsDto dto로그인한 사람의 정보.
			logger.info("BbsController answerAf()" + new Date());
			
			// DB	-> update, insert
			service.reply(dto);
			
			System.out.println(dto.toString());
			return "redirect:/bbslist.do";
			
		}
		
		@RequestMapping(value="updatebbs.do", method= RequestMethod.GET,
				produces = "application/String; charset=utf-8")
		public String updatebbs(Model model, int seq) {
			logger.info("BbsController updatebbs()" + new Date());
			
			// DB -> SELECT
			BbsDto bbs = service.rdupdate(seq);
			System.out.println(bbs.toString());
			
			//model
			model.addAttribute("bbs", bbs);
			
			return "bbsupdate";
		}
		
		@RequestMapping(value="updateAf.do", method= RequestMethod.GET,
				produces = "application/String; charset=utf-8")
		public String updateAf(BbsDto dto) {
			logger.info("BbsController updateAf()" + new Date());
			System.out.println(dto.toString());
			
			//DB -> UPDATE
			boolean b = service.update(dto);
			if(b==true) {
				System.out.println("게시글이 수정되었습니다.");
				return "redirect:/bbslist.do";
			}
			else {
				return "updatebbs";
			}
			
			
		}
		
		@RequestMapping(value="deletebbs.do", method= RequestMethod.GET,
				produces = "application/String; charset=utf-8")
		public String deletebbs(BbsDto dto) {
			logger.info("BbsController deletebbs()" + new Date());
			System.out.println(dto.toString());
			
			boolean b = service.delete(dto);
			if(b==true) {
				System.out.println("게시글이 삭제되었습니다.");
				return "redirect:/bbslist.do";
			}
			else {
				return "redirect:/bbslist.do";
			}
			
		}
		
		
		
		
		
}
