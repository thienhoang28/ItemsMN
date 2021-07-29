package com.javaweb.ItemsMN.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaweb.ItemsMN.model.Items;
import com.javaweb.ItemsMN.model.Type_Item;
import com.javaweb.ItemsMN.service.ItemService;
import com.javaweb.ItemsMN.service.TypeItemService;

@Controller
public class ItemsController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private TypeItemService typeitemService;
	
	@GetMapping(value= {"/","/items"})
	public String showListItem(Model model) {
		
		return findPaginated(1, model);
	}
	
	@GetMapping("/item/additem")
	public String addItem(Model model) {
		List<Type_Item> listTypeItems = typeitemService.findAll();
		model.addAttribute("item", new Items());
		model.addAttribute("listTypeItems", listTypeItems);
		
        return "addeditItems";
	}
	
	@PostMapping("/item/save")
	public String saveItem(Items item, HttpServletRequest request) {
		String[] speciIDs = request.getParameterValues("speciID");
		String[] speciNames = request.getParameterValues("speciName");
		String[] speciValues = request.getParameterValues("speciValue");
		
		for(int i=0; i<speciNames.length; i++) {
			if(speciNames[i]!=null && speciValues[i]!=null) {
				if(speciIDs != null && speciIDs.length>0) {
					item.setSpecification(Long.valueOf(speciIDs[i]), speciNames[i], speciValues[i]);
				}
				else {
					item.addSpecification(speciNames[i], speciValues[i]);
				}
			}
		}
		itemService.save(item);
		
		return "redirect:/items";
	}
	
	@GetMapping(value= {"/item/edit/{id}", "/item/detail/{id}"})
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Items item = itemService.findById(id).get();
		List<Type_Item> listTypeItems = typeitemService.findAll();
		model.addAttribute("item", item);
		model.addAttribute("listTypeItems", listTypeItems);
		
		return "addeditItems";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value="pageNo") int pageNo, Model model) {
		int pageSize = 5;
		
		Page<Items> page = itemService.findPaginated(pageNo, pageSize);
		List<Items> listItems = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listItems", listItems);
		
		return "listItems";
	}

}
