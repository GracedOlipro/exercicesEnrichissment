package sandbox;

import java.awt.Color;
import commun.FenetreDessin;

public class DemoColor {
	public static void main(String[] args) {
		FenetreDessin fd = new FenetreDessin("Demo couleur", 800, 600);
		int x, y, inc;
		
		fd.couleurCrayon((float) 0.9, (float) 0.9, (float) 0.9);
		fd.couleurRemplissage((float) 0.9, (float) 0.9, (float) 0.9);
		fd.dessineRectanglePlein(0, 0, 799, 599);
		x = 100;
		y = 100;
		inc = 16;
		fd.couleurCrayon(Color.BLACK);
		fd.dessineTexte(100, 68, "import java.awt.Color;");
		fd.dessineTexte(x, y, "Color.BLACK");
		y += inc;
		fd.couleurCrayon(Color.BLUE);
		fd.dessineTexte(x, y, "Color.BLUE");
		y += inc;
		fd.couleurCrayon(Color.CYAN);
		fd.dessineTexte(x, y, "Color.CYAN");
		y += inc;
		fd.couleurCrayon(Color.DARK_GRAY);
		fd.dessineTexte(x, y, "Color.DARK_GRAY");
		y += inc;
		fd.couleurCrayon(Color.GRAY);
		fd.dessineTexte(x, y, "Color.GRAY");
		y += inc;
		fd.couleurCrayon(Color.GREEN);
		fd.dessineTexte(x, y, "Color.GREEN");
		y += inc;
		fd.couleurCrayon(Color.LIGHT_GRAY);
		fd.dessineTexte(x, y, "Color.LIGHT_GRAY");
		y += inc;
		y = 100;
		x = 260;
		fd.couleurCrayon(Color.MAGENTA);
		fd.dessineTexte(x, y, "Color.MAGENTA");
		y += inc;
		fd.couleurCrayon(Color.ORANGE);
		fd.dessineTexte(x, y, "Color.ORANGE");
		y += inc;
		fd.couleurCrayon(Color.PINK);
		fd.dessineTexte(x, y, "Color.PINK");
		y += inc;
		fd.couleurCrayon(Color.RED);
		fd.dessineTexte(x, y, "Color.RED");
		y += inc;
		fd.couleurCrayon(Color.WHITE);
		fd.dessineTexte(x, y, "Color.WHITE");
		y += inc;
		fd.couleurCrayon(Color.YELLOW);
		fd.dessineTexte(x, y, "Color.YELLOW");
		
		fd.couleurCrayon(Color.BLACK);
		fd.dessinePoint(300,300); // Point
		fd.dessineTexte(288,316,"x,y"); // Point
		fd.dessineSegment(300, 350, 400, 350); // Segment
		fd.dessineTexte(280,350,"x1,y1"); // Segment
		fd.dessineTexte(380,350,"x2,y2"); // Segment
		fd.dessineRectangle(300, 400, 400, 450); // Rectangle
		fd.dessineTexte(280,400,"x1,y1"); // Rectangle
		fd.dessineTexte(380,468,"x2,y2"); // Rectangle
		fd.dessineCercle(150, 300, 50); // Cercle
		fd.dessineTexte(138,316,"x,y"); // Cercle
		fd.couleurCrayon(Color.LIGHT_GRAY);
		fd.dessineSegment(150, 300, 200, 300); // Cercle
		fd.couleurCrayon(Color.BLACK);
		fd.dessineTexte(171,300,"r"); // Cercle
		fd.dessinePoint(150,300); // Cercle
		fd.dessineTriangle(150, 400, 100, 450, 200, 450); // Triangle
		fd.dessineTexte(130, 400, "x1,y1"); // Triangle
		fd.dessineTexte(80, 468, "x2,y2"); // Triangle
		fd.dessineTexte(180, 468, "x3,y3"); // Triangle
		fd.couleurCrayon(Color.GRAY);
		fd.dessineRectangle(150,550,157,535); // Char
		fd.dessineTexte(150, 535, "8"); // Char
		fd.dessineTexte(162, 550, "16"); // Char
		fd.couleurCrayon(Color.BLACK);
		fd.dessineTexte(150, 550, "Q"); // Char
		fd.dessineTexte(138, 568, "x,y"); // Char
		fd.dessinePoint(150,550); // Char
	}

}
