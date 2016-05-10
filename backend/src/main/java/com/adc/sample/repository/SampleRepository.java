package com.adc.sample.repository;

import com.adc.sample.domain.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * TODO: 코멘트 생성
 *
 * @version 1.0
 *          Created by ChoKwangyo on 2015-10-23.
 */

@Repository
public class SampleRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Sample> listSamples() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT \n")
				.append("SAMPLE_ID, \n")
				.append("SUBJECT, \n")
				.append("DESC, \n")
				.append("IMG_GROUP_ID, \n")
				.append("START_DATE, \n")
				.append("END_DATE, \n")
				.append("REG_ID, \n")
				.append("REG_DATE, \n")
				.append("MOD_ID, \n")
				.append("MOD_DATE, \n")
				.append("USE_YN, \n")
				.append("DEL_YN ")
				.append("FROM SAMPLE");
		String query = sb.toString();
		return jdbcTemplate.query(query, new SampleMapper());
	}

	static class SampleMapper implements RowMapper<Sample> {
		public Sample mapRow(ResultSet rs, int rowNum) throws SQLException {
			Sample sample = new Sample();
			sample.setSubject(rs.getString("SUBJECT"));
			sample.setSampleId(rs.getString("SAMPLE_ID"));
			return sample;
		}
	}
}
