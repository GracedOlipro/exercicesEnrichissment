package sandbox;

import java.awt.Color;
import commun.FenetreDessin;

public class FenetreDessinTest {
	public static void main(String[] args) {
		FenetreDessin fd = new FenetreDessin("Test", 640, 480);

		int nb;
		
		nb = fd.litEntier("Entrez un nombre");
		fd.couleurCrayon(Color.RED);
		fd.dessineRectangle(160, 120, 480, 360);
		fd.couleurCrayon(Color.BLUE);
		fd.dessineTexte(288, 248, String.format("▒ %04d ▒", nb));
		fd.couleurCrayon(Color.GREEN);
		fd.dessineCercle(320, 240, 120);
	}
}
