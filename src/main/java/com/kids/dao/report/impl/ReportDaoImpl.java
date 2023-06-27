package com.kids.dao.report.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kids.dao.report.ReportDao;
import com.kids.dto.report.ReportDto;

@Repository
public class ReportDaoImpl implements ReportDao{
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<ReportDto> selectReportedList() {
		// TODO Auto-generated method stub
		
		List<ReportDto> list = 
				sqlSessionTemplate.selectList("report_mapper.select_reported_user_list");		
		
		return list;
	}

	@Override
	public List<ReportDto> selectReportedListById(ReportDto reportDto) {
		// TODO Auto-generated method stub
		
		List<ReportDto> list = 
				sqlSessionTemplate.selectList("report_mapper.select_reported_user_list_by_id", reportDto);		
		
		return list;
	}

	@Override
	public int updateReportedStatusAsConfirmed(ReportDto reportDto) {
		// TODO Auto-generated method stub
		
		int result = sqlSessionTemplate.update("report_mapper.update_report_confirm_status_as_Y", reportDto);
		
		return result;
	}
	
	@Override
	public int updateReportedStatusAsRejected(ReportDto reportDto) {
		// TODO Auto-generated method stub
		
		int result = sqlSessionTemplate.update("report_mapper.update_report_confirm_status_as_Rejected", reportDto);
		
		return result;
	}

	@Override
	public int updateReportCount(ReportDto reportDto) {
		// TODO Auto-generated method stub
		
		int result = sqlSessionTemplate.update("report_mapper.update_report_count", reportDto);
		
		return result;
	}
	
}
