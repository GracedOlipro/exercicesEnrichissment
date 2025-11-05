package sandbox;

import java.util.Scanner;

public class Facture {
    public static final float TPS = 0.05f, TVQ = 0.09975f;

	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);

		float total, totalProduit, prixProduit;
		int quantiteProduit;

		System.out.print("Entrez le prix du produit : ");
		prixProduit = clavier.nextFloat();
		System.out.print("Entrez la quantité achetée : ");
		quantiteProduit = clavier.nextInt();
		totalProduit = prixProduit * quantiteProduit;
		total = totalProduit;
		total = total + totalProduit * TPS;
		total = total + totalProduit * TVQ;
		System.out.println(String.format("Le total de la facture est %.2f$.", total));
	}
}
