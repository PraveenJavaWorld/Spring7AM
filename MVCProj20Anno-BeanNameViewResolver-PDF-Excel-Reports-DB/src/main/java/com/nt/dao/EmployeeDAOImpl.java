package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("dao")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_ALL_EMPS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<Employee> getEmps() {
		List<Employee> listEmps = jt.query(GET_ALL_EMPS, new EmployeeExtractor());
		return listEmps;
	}
	
	private static class EmployeeExtractor implements ResultSetExtractor<List<Employee>>{

		@Override
		public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
			//convert rs to list
			List<Employee> listEmps = new ArrayList<>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getFloat(4));
				emp.setDeptno(rs.getInt(5));
				listEmps.add(emp);
			}//while
			return listEmps;
		}
		
	}

}
