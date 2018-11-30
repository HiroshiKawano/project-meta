package com.meta.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LibraryController {
	@Autowired LibraryRepository libRepository;
	@Autowired LibraryService libService;

	@RequestMapping(value="/library/search", method=RequestMethod.GET)
	public String libraryConfirm(Model model) {

		LibraryDto libraryDto = libService.service();

		libRepository.deleteAll();
		for(int i = 0 ; i < libraryDto.getResults().size(); i++ ) {

			//System.out.println(libraryDto.getResults().get(i).getId());
			//IDをループで自動連番
			libraryDto.getResults().get(i).setId(i + 1);
			libRepository.saveAndFlush(libraryDto.getResults().get(i));
		}
		List<LibraryApi> libList = libRepository.findAll();

		for (int i = 0; i < libList.size() ; i++) {
			//
			String geocode = libList.get(i).getGeocode();
			String[] geo = geocode.split(",");
			libList.get(i).setLat(geo[0]);
			libList.get(i).setLng(geo[1]);
		}
		libRepository.saveAll(libList);
		libRepository.flush();
		model.addAttribute("libList",libraryDto.getResults());
		return "library";
	}
}
