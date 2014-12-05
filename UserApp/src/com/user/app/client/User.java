package com.user.app.client;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;

public class User extends BaseModel {
	
	public User(){
	}
	
	public User(Integer id, String imie,String nazwisko, Date dataUrodzenia, String miasto,
			String pesel, String adresEmail, Boolean newsletter) {
		
		set("id", id);
		set("imie", imie);
		set("nazwisko", nazwisko);
		set("dataUrodzenia", dataUrodzenia);
		set("miasto", miasto);
		set("pesel", pesel);
		set("adresEmail", adresEmail);
		set("newsletter", newsletter);
		
	}
	
	public Integer getId(){
		return (Integer) get("id");
	}
	
	public String getImie(){
		return (String) get("imie");
	}
	
	public String getNazwisko(){
		return (String) get("nazwisko");
	}
	
	public Date getDataUrodzenia(){
		return (Date) get("dataUrodzenia");
	}
	
	public String getMiasto(){
		return (String) get("miasto");
	}
	
	public String getPesel(){
		return (String) get("pesel");
	}
	
	public String getAdresEmail(){
		return (String) get("adresEmail");
	}
	
	public Boolean getNewsletter(){
		return (Boolean) get("newsletter");
	}
	
	public String toString(){
		return getImie();
	}

}
