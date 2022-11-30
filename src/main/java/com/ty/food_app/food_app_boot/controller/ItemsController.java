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

import com.ty.food_app.food_app_boot.dto.Items;
import com.ty.food_app.food_app_boot.dto.Menu;
import com.ty.food_app.food_app_boot.service.ItemsService;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@RestController
@RequestMapping("items")
public class ItemsController {
	@Autowired
	private ItemsService service;
	
	@PostMapping
	public ResponseStructure<Items> saveItems(@RequestBody Items items)
	{
		return service.saveItems(items);
		
	}
	@PutMapping
	public ResponseStructure<Items> updateItems(@RequestBody Items items,@RequestParam int id)
	{
		return service.updateItems(items, id);
		
	}
	@GetMapping
	public ResponseStructure<Items> getItemsById(@RequestParam int id)
	{
		return service.getItemsById(id);
		
	}
	@DeleteMapping
	public ResponseStructure<String> deleteItems(@RequestParam int id)
	{
		return service.DeleteItemsById(id);
		
	}
	
	
	

}
