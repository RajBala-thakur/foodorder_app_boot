package com.ty.food_app.food_app_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.food_app.food_app_boot.dao.UserDao;
import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.exception.NoSuchIdFoundException;
import com.ty.food_app.food_app_boot.exception.UnableToDeleteException;
import com.ty.food_app.food_app_boot.exception.UnableToUpdateException;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseStructure<User> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveUser(user));
		return responseStructure;
	}

	public ResponseStructure<User> updateUser(User user, int id) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		User user1 = dao.getUserById(id);
		if (user1 != null) {
			user.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.saveUser(user));
			

		} else {
			  throw new UnableToUpdateException();
			
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("NotFound");
//			responseStructure.setData(null);
//			return responseStructure;
		}
		return responseStructure;
	}

	public ResponseStructure<User> getUserById(int id) {
		User user2=dao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if(user2!=null) {
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getUserById(id));
	}else
	{
		throw new NoSuchIdFoundException();
	}
	return responseStructure;
	}

	public ResponseStructure<String> deleteUserById(int id) {
		User user3=dao.getUserById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if(user3!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteUser(id));
		return responseStructure;
		}
		else
		{
			throw new UnableToDeleteException("Unable To Delete exception");
		}
	}

}
