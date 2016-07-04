package toDoList;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Person;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String[][] users = new String[99][99];
		int menu1 = 0;
		int menu2 = 0;
		int count = 0;
		int ucheck = 0;
		String element_list; // = new String
		String username;
		String pword;
		String kayit;

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("list2");
		EntityManager entitymanager = emfactory.createEntityManager();

		Scanner input = new Scanner(System.in);
		while (menu1 != 3) {
			System.out.println("ToDo-List Programına Hoşgeldiniz.");
			System.out.println("1. Giriş yapın.");
			System.out.println("2. Üyelik alın.");
			System.out.println("3. Çıkış yapın.");
			System.out.println("Lütfen yapmak istediğiniz işlemin numarasını giriniz.");
			menu1 = input.nextInt();

			if (menu1 == 1) {
				System.out.println("Lütfen kullanici adini giriniz.");
				username = input.next();
				for (int i = 1; i <= count; i++) {
					Person person = entitymanager.find(Person.class, i);
					if (person.getuname().equals(username)) {
						System.out.println("Lütfen şifrenizi giriniz.");
						pword = input.next();
						if (person.getpassword().equals(pword)) {
							System.out.println("Şifre doğru.");
							while (menu2 != 4) {
								System.out.println("Aşağıdaki menüden yapmak istediğiniz işlemin numarasını seçiniz.");
								System.out.println("1. Listenize yeni bir eleman ekleyin.");
								System.out.println("2. Listenizdeki elemanları gözden geçirin.");
								//System.out.println("3. Listenizden eleman silin.");
								System.out.println("4. Çıkış yapın.");
								menu2 = input.nextInt();

								if (menu2 == 1) {
									System.out.println("Eklemek istediğiniz metni giriniz");
									element_list = input.next();
									if (person.getlist_todo() != null) {
										person.setlist_todo((person.getlist_todo()) + " " + (person.getlcount() + 1)
												+ "." + element_list);
									} else
										person.setlist_todo(person.getlcount() + "." + element_list);
									// users[person.getuId()-1][person.getlcount()]
									// = element_list[person.getlcount()];

									person.setlcount(person.getlcount() + 1);
								} else if (menu2 == 2) {
									// for(int k=0; k < person.getlcount();
									// k++){
									// System.out.print( (k+1) + " " +
									// users[person.getuId()-1][k] + " ");
									System.out.println(person.getlist_todo());
								}
								// System.out.println();
								// }
								/*
								 * else if(menu2 == 3){ System.out.
								 * println("Silmek istediğiniz elamanın numarasını giriniz."
								 * ); menu2 = input.nextInt(); for(int k =
								 * menu2; menu2 < person.getlcount() - 1; menu2
								 * ++){ users[person.getuId()-1][k] =
								 * users[person.getuId()][k + 1];
								 * 
								 * } person.setlcount(person.getlcount() -1); }
								 */
								else if (menu2 == 4) {
									System.exit(0);
								}

								else
									System.out.println("Hatalı giriş yaptınız. Tekrar deneyiniz.");
							}
						}

						else {
							System.out.println("Hatalı giriş yaptınız. Tekrar deneyiniz.");

						}

					}

				}

				System.out.println("Aradığınız kullanıcı adı bulunamamıştır.");

			} else if (menu1 == 2) {
				System.out.println("Lütfen kullanıcı adınızı giriniz.");
				username = input.next();
				for (int i = 1; i <= count; i++) {
					Person person = entitymanager.find(Person.class, i);
					if (person.getuname().equals(username)) {
						System.out.println("Seçtiğiniz kullanıcı adı sistemimizde kayıtlıdır.");
						ucheck = 1;
					}
				}
				if (ucheck != 1) {

					entitymanager.getTransaction().begin();

					Person person = new Person();
					System.out.println("Lütfen adınızı giriniz.");
					kayit = input.next();
					person.setname(kayit);
					System.out.println("Lütfen soyadınızı giriniz.");
					kayit = input.next();
					person.setlname(kayit);
					System.out.println("Lütfen şifrenizi giriniz");
					kayit = input.next();
					person.setpassword(kayit);
					person.setuname(username);
					person.setlcount(0);
					count++;

					System.out.println("COMIITING");
					entitymanager.persist(person);
					entitymanager.getTransaction().commit();
				}

			}

			else if (menu1 == 3) {
				System.out.println("Programımızı kullandığınız için teşekkür ederiz");
				System.exit(0);
			}

			else
				System.out.println("Hatalı giriş yaptınız. Tekrar deneyiniz.");

		}

	}

}
