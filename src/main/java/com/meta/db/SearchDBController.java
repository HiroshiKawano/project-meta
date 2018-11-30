package com.meta.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchDBController {

	@Autowired SearchHistoryRepository shRepository;
	@Autowired SearchHistoryDB shDB;
	@Autowired LibraryApi libapi;

	//格納された検索履歴DBをビューで表示する
	/*
	@RequestMapping(value="/history")
	public String history(Model model){
		List<SearchHistoryDB> shList = shRepository.findAll();
		model.addAttribute("shList",shList);
	return "history.html";
	}
	*/

	//検索された書籍の情報を一時格納
	@RequestMapping(value="/history")
	public String insert(
			@ModelAttribute(value="shDB")SearchHistoryDB shDB,
			//@ModelAttribute(value="libapi")libraryapi libapi,
			Model model) {
		shDB.setId(1);
		shDB.setTitle("A");
		shDB.setAuthorname("B");
		shDB.setPublishername("C");
		//shDB.setPublicationyear(null);
		shDB.setSubject("D");
		shDB.setClassification("E");
		shDB.setIsbn("F");
		//shDB.setDate(null);
		shDB.setUserID(1);
		shRepository.saveAndFlush(shDB);
		List<SearchHistoryDB>shList = shRepository.findAll();
		model.addAttribute("shList",shList);
		return "history.html" ;
	}


	//ISBN、本の名前などをDBに格納
	/*public String searchResult(
			@RequestParam(value="")
			@ModelAttribute(value="shDB")SearchHistoryDB shDB,
			Model model) {
		shRepository.saveAndFlush(shDB);
		return null ;
	}*/
}
