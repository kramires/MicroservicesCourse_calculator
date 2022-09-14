package br.com.klaytonramires.demo_calculator.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.klaytonramires.demo_calculator.model.Person;

@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Klayton");
		person.setLastName("Ramires");
		person.setAdress("Apucarana");
		person.setGender("male");
		return person ;
	}
	
	public List<Person> findAll( ) {
		List<Person> persons = new ArrayList<>();
		for (int object = 0; object < 8; object++) {

			Person person = mockPerson(object);
			persons.add(person);
		}
		return persons;

	}

	private Person mockPerson(int object) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Klayton" + object);
		person.setLastName("Ramires");
		person.setAdress("Some adress in Brazil");

		if(object% 2 == 0) {
			person.setGender("male");
		}else {
			person.setGender("female");
		}
		return person ;
	}
}

