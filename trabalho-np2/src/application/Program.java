package application;

import java.util.Scanner;

import services.Carregar;
import services.Menu;

public class Program {

	public static void main(String[] args) {

		Carregar.carregar();

		Scanner leia = new Scanner(System.in);
		String menu1;

		do {
			Menu.mostraMenu();

			menu1 = leia.next();
			Menu.fazEscolha(menu1);

		} while (Integer.parseInt(menu1) != 0);

		leia.close();
	}
}
