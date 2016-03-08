package co.computerstuff.JPA.Repo;

import static org.junit.Assert.*;

import org.junit.Test;

import co.computerstuff.JPA.Entities.People;
import co.computerstuff.telosys.Entities.jpa.PeopleEntity;


public class testPeople {

	@Test
	public void test() {
		PeopleRepo repo = PeopleRepo.getRepo();
		People person = new People();
		person.setName("Homer Simpson")
			.setEmail("fred@smith.com")
			.setPhone("123123123");
		repo.save(person);
		assertNotNull(person.getId());
	}

}
