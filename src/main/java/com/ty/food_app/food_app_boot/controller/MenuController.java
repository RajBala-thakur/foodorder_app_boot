package com.ty.food_app.food_app_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.food_app_boot.dto.Menu;
import com.ty.food_app.food_app_boot.service.MenuService;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@RestController
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private MenuService service;
	@PostMapping
	public ResponseStructure<Menu> saveMenu(@RequestBody Menu menu)
	{
		return service.saveMenu(menu);
		
	}
	@PutMapping
	public ResponseStructure<Menu> updateMenu(@RequestBody Menu menu,@RequestParam int id)
	{
		return service.updateMenu(menu, id);
		
	}
	@GetMapping
	public ResponseStructure<Menu> getMenuById(@RequestParam int id)
	{
		return service.getMenuById(id);
		
	}
	@DeleteMapping
	public ResponseStructure<String> deleteMenu(@RequestParam int id)
	{
		return service.DeleteMenuById(id);
		
	}
	
	
	

}
