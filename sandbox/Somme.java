package sandbox;

import java.util.Scanner;

public class Somme {
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		int nombre1;
		int nombre2;
		int somme;
		
		System.out.print("Entrez le premier nombre: ");
		nombre1 = clavier.nextInt();
		System.out.print("Entrez le deuxième nombre: ");
		nombre2 = clavier.nextInt();
		
		somme = nombre1 + nombre2;
		
		System.out.println("Le résultat est " + somme);
	}
}
