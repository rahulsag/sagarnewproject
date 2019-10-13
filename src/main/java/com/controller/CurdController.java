package com.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserDetailBean;
import com.dao.UserDeatilDao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="CURD Operation",description = "Test CURD operation." )
public class CurdController {

	@Autowired
	UserDeatilDao user_detailDao ;

	@ApiOperation(value="Insert Data")
	@RequestMapping(value="/Insert_Data",method = RequestMethod.POST,produces ="application/json")
	public UserDetailBean of_get_request(@RequestBody UserDetailBean user_detailbean )
	{
		System.out.println("In insert API");
		System.out.println(user_detailbean.getLs_username());
		int li_ret;
		li_ret=user_detailDao.of_insert_data(user_detailbean);
		return user_detailbean;
	}

	@ApiOperation("Show list of users")
	@RequestMapping(value="/View_detail",method=RequestMethod.GET)
	public ArrayList<UserDetailBean> of_get_detail()
	{
		ArrayList<UserDetailBean> user_data_list =new ArrayList<UserDetailBean>();
		user_data_list=user_detailDao.of_get_user_detail();
		return user_data_list;
	}

	@RequestMapping(value="/Delete_User", method=RequestMethod.GET)
	public ResponseEntity Delete_user_data (@RequestParam("user_nm") String ls_user_nm
			/*@PathVariable(value="user_nm", required=false)String ls_user_nm
			@PathVariable(value="user_pass",required=false)String ls_password*/)
	{
		int il_ret;
		System.out.println("user_name:-"+ls_user_nm);
		il_ret=user_detailDao.of_delete_data(ls_user_nm);
		//return il_ret+" Row Deleted.";
		return new ResponseEntity("il_ret+\" Row Deleted.\"",HttpStatus.OK);
	}
}