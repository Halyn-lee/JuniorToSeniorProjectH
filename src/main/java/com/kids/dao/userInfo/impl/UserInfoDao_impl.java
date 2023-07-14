package com.kids.dao.userInfo.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kids.dao.UserInfo_Dao;
import com.kids.dto.UserInfo_Dto;
import com.kids.dto.parents.ParentsDetailDto;
import com.kids.dto.senior.SeniorDetailDto;
import com.kids.dto.user.UserDto;

@Repository
public class UserInfoDao_impl implements UserInfo_Dao{
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertUser(UserInfo_Dto userInfo_dto) {

		int result = sqlSessionTemplate.insert("userInfo_mapper.insertUser", userInfo_dto);


		return result;
	}
	
	@Override
	public int insertUser2(UserInfo_Dto userInfo_dto) {

		int result = sqlSessionTemplate.insert("userInfo_mapper.insert_userInfo2", userInfo_dto);

		return result;
	}

	@Override
	public List<UserInfo_Dto> selectUesrList(UserInfo_Dto userInfo_dto) {


		return sqlSessionTemplate.selectList("userInfo_mapper.select_userList", userInfo_dto);
	
	}
	//
	@Override
	public int insertUserPar(UserInfo_Dto userInfo_dto) {

		int result = sqlSessionTemplate.insert("userInfo_mapper.insert_parent_userInfo", userInfo_dto);


		return result;
	}


	//
	@Override
	public int insertUserSnr(UserInfo_Dto userInfo_dto) {

		int result = sqlSessionTemplate.insert("userInfo_mapper.insert_senior_userInfo", userInfo_dto);


		return result;
	}

	@Override
	public int inserAgreement(UserInfo_Dto userInfo_dto) {

		int result = sqlSessionTemplate.insert("userInfo_mapper.insert_agreement_userInfo", userInfo_dto);


		return result;
	}

	@Override
	public int idChk(String id) {
		UserInfo_Dto userInfo_Dto = new UserInfo_Dto();
		userInfo_Dto.setId(id);
		System.out.println("DAO ID  : "+ id);
		int result = sqlSessionTemplate.selectOne("userInfo_mapper.idChk", userInfo_Dto);

		return result;
	}

	@Override
	public int insertUserDao(UserInfo_Dao userInfo_dao) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertUserDto(UserInfo_Dto userInfo_dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo_Dto logInChk(UserInfo_Dto userInfo_Dto) {
		UserInfo_Dto result = sqlSessionTemplate.selectOne("userInfo_mapper.logInChk", userInfo_Dto);
		return result;
	}

	@Override
	public int insertSnrSchedule(Map<String, String> map) {
		// TODO Auto-generated method stub
		
		int result = sqlSessionTemplate.insert("userInfo_mapper.insert_senior_schedule", map);
		
		return result ;
		
	}
	

	@Override
	public List<UserInfo_Dto> selectParInfoList() {
		// TODO Auto-generated method stub
		List<UserInfo_Dto> list = 
				sqlSessionTemplate.selectList("userInfo_mapper.select_par_info_list");
		
		return list;
	}

	@Override
	public List<UserInfo_Dto> selectSnrInfoList() {
		// TODO Auto-generated method stub
		List<UserInfo_Dto> list = 
				sqlSessionTemplate.selectList("userInfo_mapper.select_snr_info_list");
		
		return list;
	}

	@Override
	public ParentsDetailDto selectParInfoById(String id) {
		// TODO Auto-generated method stub
		ParentsDetailDto par = sqlSessionTemplate.selectOne("userInfo_mapper.select_par_info_by_id", id);
		return par;
	}

	@Override
	public SeniorDetailDto selectSnrInfoById(String id) {
		// TODO Auto-generated method stub
		SeniorDetailDto snr = sqlSessionTemplate.selectOne("userInfo_mapper.select_snr_info_by_id", id);
		return snr;
	}

//	@Override
//	public int insertSnrSchedule(Map<String, String> map) {
//		// TODO Auto-generated method stub
//		return 0;
//	}






	
	
}
