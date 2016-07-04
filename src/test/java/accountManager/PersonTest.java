package accountManager;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import Entities.Person;

public class PersonTest {
				
		

	    @Test
	    public void testConcatenate() {
	    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("list2");

			EntityManager entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();

			Person person = new Person();
			//person.setuId( 1 );
			person.setname("ugur");
			person.setlname("saritepe");
			person.setpassword("1994");
			person.setuname("saritepe");
			person.setlcount(0);
			person.setlist_todo("abc");

			entitymanager.persist(person);
			entitymanager.getTransaction().commit();

	        String result = person.getname();
	        String result2 = person.getlname();
	        String result3 = person.getpassword();
	        String result4 = person.getuname();
	        int result5 = person.getlcount();
	        String result6 = person.getlist_todo();

	        assertEquals("ugur", result);
	        assertEquals("saritepe", result2);
	        assertEquals("1994", result3);
	        assertEquals("saritepe", result4);
	        assertEquals(0, result5);
	        assertEquals("abc", result6);
	        System.out.println("Test Başarılı");

	    }
	}