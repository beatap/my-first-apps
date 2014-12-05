package com.user.app.client;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.extjs.gxt.ui.client.widget.Info;

public class CheckService {

	/*
	 * Funkcja sprawdza, czy podany numer PESEL.
	 * Jeżeli jest prawidłowy funkcja zwraca true,
	 * w przeciwnym wypadku false.
	 * 
	 * @param PESEL przyjmuje wartość numeru PESEL
	 */
	public static Boolean sprawdz(String PESEL) {
		
		int[] wagi = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
		int suma = 0;
		int sumaKontr = 0;
		
		if(PESEL.equals("00000000000"))
			return false;
		else if(PESEL.equals("22222222222"))
			return false;
		else if(PESEL.equals("44444444444"))
			return false;
		else if(PESEL.equals("66666666666"))
			return false;
		else if(PESEL.equals("88888888888"))
			return false;
		else {
			
			for(int i=0; i <10; i++)
				suma += wagi[i] * Integer.parseInt(PESEL.substring(i, i+1));
			
			suma %= 10;
			suma = 10 - suma;
			suma %= 10;
			sumaKontr = Integer.parseInt(PESEL.substring(10, 11));
			
			return (suma == sumaKontr);			
		}

	}
	
	/*
	 * Funkcja sprawdza, czy nowy użytkownik
	 * jest pełnoletni.
	 */
	public static Boolean sprawdzWiek(String wiek){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		
		String systemowa = formatDate.format(cal.getTime());
		
		String pomWiek = wiek.substring(0, 4);
		String pomSys = systemowa.substring(0, 4);

		int liczbaWiek = Integer.parseInt(pomWiek);
		int liczbaSys = Integer.parseInt(pomSys);
		int wynik = liczbaSys - liczbaWiek;

		if(wynik >=18){
			return true;
		}
		
		return false;
	}
}
