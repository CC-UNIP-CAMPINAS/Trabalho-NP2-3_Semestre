package application;

import services.Carregar;
import services.Menu;

public class Program {

	public static void main(String[] args) {

		Carregar.carregar();
		Menu.escolheMenu();
		
	}
}
