package com.douzone.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookListController {
	
	@Autowired
	private GuestBookDao guestBookDao;
	
	@RequestMapping({"", "/index"})
	public String index(Model model) {
		model.addAttribute("list", guestBookDao.getList());
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestBookVo guestBookVo) {
		guestBookDao.insert(guestBookVo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteform/{no}", method=RequestMethod.GET)
	public String deleteForm(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "deleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestBookVo guestBookVo) {
		guestBookDao.delete(guestBookVo);
		return "redirect:/";
	}

}
