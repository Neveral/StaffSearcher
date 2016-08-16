package com.solanteq.repository;

import com.solanteq.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository{

    @Autowired
    private JdbcOperations jdbc;


    public List<Employee> gelAllEmployeesByParams(String firstName, String middleName, String lastName, String position, Date birthday) {
        jdbc.execute("Set @firstName = NULL, @middleName = NULL, @lastName = NULL, @position = NULL, @birthday = NULL;");

        if(firstName != null)
            jdbc.execute("Set @firstName = '" + firstName + "'");
        if(middleName != null)
            jdbc.execute("Set @middleName = '" + middleName + "'");
        if(lastName != null)
            jdbc.execute("Set @lastName = '" + lastName + "'");
        if(position != null)
            jdbc.execute("Set @position = '" + position + "'");
        if(birthday != null)
            jdbc.execute("Set @birthday = '" + birthday + "'");

        return jdbc.query("SELECT * FROM `employee`" +
                "where (@firstName is null or first_name = @firstname)" +
                "AND (@middleName is null or `middle_name` = @middleName)" +
                "AND (@lastName is null or `last_name` = @lastName)" +
                "AND (@position is null or `position` = @position)" +
                "AND (@birthday is null or `birthday` = @birthday);", new EmployeeRowMapper());
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Employee(
                    rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("middle_name"),
                    rs.getString("last_name"),
                    rs.getString("position"),
                    rs.getDate("birthday"));
        }
    }
}
