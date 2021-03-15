package com.spring.database.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.database.database.jdbc.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setLocation(rs.getString("location"));
			p.setBirthDate(rs.getDate("birth_date"));
			return null;
		}

	}

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person",
				//new BeanPropertyRowMapper<>(Person.class));
				new PersonRowMapper());
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ?",
				new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id = ?", new Object[] {id});
	}

	public int insert(Person p) {
		return jdbcTemplate.update("insert into person values (?,?,?,?)",
				new Object[]{p.getId(), p.getName(), p.getLocation(),
						new Timestamp(p.getBirthDate().getTime())});
	}
}
