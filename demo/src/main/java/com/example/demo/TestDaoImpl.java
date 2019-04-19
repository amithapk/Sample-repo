package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
@Component
public class TestDaoImpl {

	@Autowired
	JdbcTemplate jdbcTemplate;

	List<Employee> empList = new ArrayList<Employee>();

	public List<Employee> getEmp(List<String> names) {

		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());

		try {

			empList = template.query("SELECT id,name,dept,description FROM employee where name in(:name)",

					new MapSqlParameterSource().addValue("name", names), new RowMapper<Employee>() {

						@Override
						public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

							Employee employee = new Employee();
					        Set<String> hSet = new HashSet<String>(); 

							employee.setId(resultSet.getInt("id"));
							employee.setName(resultSet.getString("name"));
							employee.setDept(resultSet.getString("dept"));
							hSet.add(resultSet.getString("description"));
							employee.setDescription(hSet);
							return employee;
						}
					});

			System.out.println("empList :: " + empList);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return empList;
	}

}
