package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping("/guest")
public class GuestController {
	@Autowired
	private GuestDao dao;

	// 리스트
	@RequestMapping("/addList")
	public String list(Model model){
		System.out.println("addList");
		
		List<GuestVo> vo = dao.getBookList();
		model.addAttribute("vo", vo);
	
		return "addList";
	}
	
	// 등록
	@RequestMapping("/add")
	public String add(@ModelAttribute GuestVo vo) {
		System.out.println("add");
		
		dao.bookInsert(vo);
		
		return "redirect:/guest/addList";
	}
	
	// 삭제폼
	@RequestMapping("/deleteForm/{no}")
	public String deleteForm(@PathVariable("no") int no, Model model) {
		System.out.println("deleteForm");
		
		model.addAttribute("no", no);
		
		return "deleteForm";
	}
	
	// 삭제
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestVo vo) {
		System.out.println("delete");
		
		dao.bookDelete(vo.getNo(), vo.getPw());

		return "redirect:/guest/addList";
	}
	
}
