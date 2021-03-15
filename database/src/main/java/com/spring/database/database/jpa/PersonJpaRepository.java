package com.spring.database.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.database.database.jpa.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_person", Person.class);
		return namedQuery.getResultList();
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public Person update(Person p) {
		return entityManager.merge(p);
	}

	public void deleteById(int id) {
		Person p = findById(id);
		entityManager.remove(p);
	}
}
