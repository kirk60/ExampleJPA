import co.computerstuff.JPA.Entities.People;
import co.computerstuff.JPA.Repo.PeopleRepo;

public class Main {

	public static void main(String[] args) {
		for(int j= 0 ; j < 10 ; j++ ){
			People person = new People();
			person.setName("Homer Simpson")
				.setEmail("fred@smith.com")
				.setPhone("123123123");
			PeopleRepo.getRepo().save(person);
		}
		PeopleRepo.getRepo().close();
	}

}
