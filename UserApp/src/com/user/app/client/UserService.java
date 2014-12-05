package com.user.app.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.i18n.client.DateTimeFormat;

public class UserService {

	private static List<User> users = new ArrayList<User>();
	
	public static List<User> getUsers() {
		
		DateTimeFormat format = DateTimeFormat.getFormat("yyyy-mm-dd");
		
		users.add(new User(1, "Jan", "Kowalski", format.parse("1980-11-12"), "Warszawa", "80111245914", "jan.kow@wp.pl", true));
		users.add(new User(2, "Maria", "Laskowska", format.parse("1976-01-24"), "Warszawa", "76012445611", "lasek@o2.pl", true));
		users.add(new User(3, "Grzegorz", "Malinowski", format.parse("1990-04-03"), "Wrocław", "90040312890", "g.malina@wp.pl", false));
		users.add(new User(4, "Adrian", "Nowak", format.parse("1961-09-15"), "Gdańsk", "61091545661", "nowaczek11@wp.pl", true));
		users.add(new User(5, "Małgorzata", "Radomska", format.parse("1954-05-09"), "Lublin", "54050909698", "gocha.rad@interia.pl", false));
		users.add(new User(6, "Joanna", "Jagodzińska", format.parse("1982-06-21"), "Wrocław", "82062112953", "joasia69@gmail.com", true));
		users.add(new User(7, "Martyna", "Sadzawka", format.parse("1969-12-25"), "Lublin", "69122522017", "martusia@gmail.com", true));
		users.add(new User(8, "Adrianna", "Wolińska", format.parse("1981-02-29"), "Lublin", "81022924342", "ada.wol@o2.pl", false));
		users.add(new User(9, "Jakub", "Wesołowski", format.parse("1966-02-14"), "Lublin", "66021411678", "kuba_wesolek@o2.pl", false));
		users.add(new User(10, "Karol", "Antkowiak", format.parse("1974-10-19"), "Gdańsk", "74101999602", "karol.antkowiak@interia.pl", true));
		users.add(new User(11, "Dawid", "Bogusik", format.parse("1965-08-29"), "Gdańsk", "65082922395", "bog34@o2.pl", true));
		users.add(new User(12, "Agnieszka", "Radosińska", format.parse("1980-01-25"), "Warszawa", "80012534569", "aga_radosc@interia.pl", false));
		
		
		return users;
	}
	
	public static void zapiszUzytkownika(User user){
		users.add(user);
	}
	
	public static User pobierzUzytkownika(Integer id){
		for(User user : users){
			if(user.getId().equals(id)){
				return user;
			}
		}
		return null;
	}
	
	public static void edytujUzytkownika(int id, User user){
		//if((!user.equals(null)) && (id >= 0)){
			users.set(id, user);
		//}
	}
	
	public static void usunUzytkownika(User user){
		if(!user.equals(null)){
			users.remove(user);
		}
	}
	
	
}
