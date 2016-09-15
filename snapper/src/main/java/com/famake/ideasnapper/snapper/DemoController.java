package com.famake.ideasnapper.snapper;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("ide")
public class DemoController {
	@Autowired
	IdeRepository repository;
	@Autowired
	TagRepository tagRepository;
	
	@RequestMapping(value="/ide", method=RequestMethod.GET)
	public String ideliste(Ide ide, Model model){
		model.addAttribute("overskriften", "Ny ide");
		retrieveLists(model);
		return "index";
	}

	@RequestMapping(value="/ide", method=RequestMethod.POST)
	public String leggtil(Ide ide, Model model,
			@RequestParam(value="avbryt", required=false) String avbryt,
			@RequestParam(value="slett", required=false) String slett) {
		if (slett != null) {
			repository.delete(ide);
		}
		else if (avbryt == null) {
			if (ide.getDato() == null) {
				ide.setDato(new Date());
			}
			repository.save(ide);
		}
		model.addAttribute("ide", new Ide());
		retrieveLists(model);
		model.addAttribute("overskriften", "Ny ide");
		return "index";
	}
	
	@RequestMapping(value="/ide/{id}", method=RequestMethod.GET)
	public String ide(@PathVariable("id") int id, Model model) {
		Ide ide = repository.findOne((long)id);
		model.addAttribute("ide", ide);
		
		retrieveLists(model);
		model.addAttribute("overskriften", ide.getTitle());
		return "index";
	}
	
	private void retrieveLists(Model model) {
		Iterable<Ide> ideer = repository.findAll();
		model.addAttribute("ideer",ideer);
		model.addAttribute("allTags", tagRepository.findAll());
	}
}
 