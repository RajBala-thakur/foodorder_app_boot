package com.ty.food_app.food_app_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app.food_app_boot.dao.ItemsDao;
import com.ty.food_app.food_app_boot.dto.Items;
import com.ty.food_app.food_app_boot.dto.Menu;
import com.ty.food_app.food_app_boot.exception.NoSuchIdFoundException;
import com.ty.food_app.food_app_boot.exception.UnableToDeleteException;
import com.ty.food_app.food_app_boot.exception.UnableToUpdateException;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@Service
public class ItemsService {
	@Autowired
	private ItemsDao dao;
	
	public ResponseStructure<Items> saveItems(Items items)
	{
		ResponseStructure<Items>responseStructure= new ResponseStructure<Items>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveItems(items));
		return responseStructure;
		
	}
	public ResponseStructure<Items> updateItems(Items items,int id)
	
	{
		Items items1=dao.getItemsById(id);
		ResponseStructure<Items>responseStructure= new ResponseStructure<Items>();
		if(items1!=null) {
		
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("updated");
		responseStructure.setData(dao.saveItems(items));
		return responseStructure;
		}
		else
		{
			 throw new UnableToUpdateException();
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("NotFound");
//			responseStructure.setData(null);
//			return responseStructure;
		}
		
	}
	
	public ResponseStructure<Items> getItemsById(int id)
	{
		Items items1=dao.getItemsById(id);
		
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		if(items1!=null) {
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getItemsById(id));
	}else
	{
		throw new NoSuchIdFoundException();
	}
	return responseStructure;
	}
	
	public ResponseStructure<String> DeleteItemsById(int id)
	{    	Items items1=dao.getItemsById(id);
		ResponseStructure<String>responseStructure= new ResponseStructure<String>();
		if(items1!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(dao.deleteItems(id));
		return responseStructure;
	}
		else
		{
			throw new UnableToDeleteException("Unable to delete Exception");
		}
	

	}
	
	
	

}
