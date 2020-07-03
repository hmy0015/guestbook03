package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping("/guest")
public class GuestController {

	// 리스트
	@RequestMapping("/addList")
	public String list(Model model){
		System.out.println("addList");
		
		GuestDao dao = new GuestDao();
		List<GuestVo> vo = dao.getBookList();
		
		model.addAttribute("vo", vo);
	
		return "/WEB-INF/view/addList.jsp";
	}
	
	// 등록
	@RequestMapping("/add")
	public String add(@ModelAttribute GuestVo vo) {
		System.out.println("add");
		
		GuestDao dao = new GuestDao();
		dao.bookInsert(vo);
		
		return "redirect:/guest/addList";
	}
	
	// 삭제폼
	@RequestMapping("/deleteForm")
	public String deleteForm(@RequestParam("no") int no, Model model) {
		System.out.println("deleteForm");
		
		model.addAttribute("no", no);
		
		return "/WEB-INF/view/deleteForm.jsp";
	}
	
	// 삭제
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestVo vo) {
		System.out.println("delete");
		
		GuestDao dao = new GuestDao();
		dao.bookDelete(vo.getNo(), vo.getPw());

		return "redirect:/guest/addList";
	}
	
}
