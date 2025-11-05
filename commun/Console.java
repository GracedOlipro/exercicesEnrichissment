package commun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.Timer;

public class Console {
	private static final boolean GUI = true;	// Permet d'activer l'affichage de la console
	private static final boolean DEBUG = false;	// Permet d'afficher des messages à la console Java

	public Console(String aTitre, int aLargeur, int aHauteur) {
		afficheConsole("CONSOLE INIT: " + aLargeur + ", " + aHauteur + " : " + aTitre);

		titre = aTitre;
		largeur = aLargeur;
		hauteur = aHauteur;
		tamponEntree = new StringBuilder();
		couleursBase = new Color[COULEUR_MAX_IDX];
		couleursBase[COUL_TEXTE_NORM_IDX] = Color.BLACK;
		couleursBase[COUL_FOND_NORM_IDX] = Color.WHITE;
		couleursBase[COUL_TEXTE_ENT_IDX] = Color.GREEN;
		couleursBase[COUL_FOND_ENT_IDX] = Color.WHITE;
		initCasesConsole();

		if (GUI) {
			curseurTick = -15;			
			defilement = true;
			retourLigne = true;

			clavierVerrou = new Object();
			clavierTamponEvenement = new LinkedList<KeyEvent>();
			imageVerrou = new Object();
			image = new BufferedImage(largeur*CAR_LARG, hauteur*CAR_HAUT, BufferedImage.TYPE_INT_ARGB);
			graphique = image.createGraphics();
			
			Font myFont = new Font("Courier New", Font.PLAIN, 13); // Caractère 8x16 environ
			File fontFile = new File("commun/IBM_VGA_8x16.ttf");
			if (!fontFile.exists()) {
				fontFile = new File("src/commun/IBM_VGA_8x16.ttf");
			}
			try {
				myFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(16f); // Caractère 8x16 
			} catch (IOException ex) {
				System.out.println("Font IBM_VGA_8x16 not found, using Courier New");
			} catch (FontFormatException ex) {
				System.out.println("Invalid font file (IBM_VGA_8x16), using Courier New");
			}
			graphique.setFont(myFont);
			graphique.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
			// Creation du thread de la fenetre de console
			try {
				javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
					public void run() { creerGUI(); }
				});
			} catch (InterruptedException | InvocationTargetException e) {
				System.err.println("Erreur: interruption lors de la creation du GUI");
				System.err.println("Exception: " + e);
				System.exit(1);
			}
			
			// Initialise le rappel pour l'animation a 30 images par seconde
			imageChrono = new Timer();
			imageChrono.scheduleAtFixedRate(new CImageChronoTache(), 0, 1000/30);
		}
		
		clear();
		imageSynchronise();
	}

	public boolean hasNext() {
		Scanner sc = new Scanner(getNextToken(false, false));
		return sc.hasNext();
	}
	
	public boolean hasNextBoolean() {
		Scanner sc = new Scanner(getNextToken(false, false));
		return sc.hasNextBoolean();
	}
	
	public boolean hasNextDouble() {
		Scanner sc = new Scanner(getNextToken(false, false));
		return sc.hasNextDouble();
	}
	
	public boolean hasNextFloat() {
		Scanner sc = new Scanner(getNextToken(false, false));
		return sc.hasNextFloat();
	}
	
	public boolean hasNextInt() {
		Scanner sc = new Scanner(getNextToken(false, false));
		return sc.hasNextInt();
	}

	public boolean hasNextInt(int radix) {
		Scanner sc = new Scanner(getNextToken(false, false));
		return sc.hasNextInt(radix);
	}

	public boolean hasNextLine() {
		Scanner sc = new Scanner(getNextToken(true, false));
		return sc.hasNextLine();
	}

	public boolean hasNextLong() {
		Scanner sc = new Scanner(getNextToken(false, false));
		return sc.hasNextLong();
	}

	public boolean hasNextLong(int radix) {
		Scanner sc = new Scanner(getNextToken(false, false));
		return sc.hasNextLong(radix);
	}

	public String next() {
		Scanner sc = new Scanner(getNextToken(false, true));
		return sc.next();
	}
	
	public boolean nextBoolean() {
		Scanner sc = new Scanner(getNextToken(false, true));
		return sc.nextBoolean();
	}
	
	public double nextDouble() {
		Scanner sc = new Scanner(getNextToken(false, true));
		return sc.nextDouble();
	}
	
	public float nextFloat() {
		Scanner sc = new Scanner(getNextToken(false, true));
		return sc.nextFloat();
	}
	
	public int nextInt() {
		Scanner sc = new Scanner(getNextToken(false, true));
		return sc.nextInt();
	}
	
	public int nextInt(int radix) {
		Scanner sc = new Scanner(getNextToken(false, true));
		return sc.nextInt(radix);
	}
	
	public String nextLine() {
		Scanner sc = new Scanner(getNextToken(true, true));
		return sc.nextLine();
	}
	
	public long nextLong() {
		Scanner sc = new Scanner(getNextToken(false, true));
		return sc.nextLong();
	}
	
	public long nextLong(int radix) {
		Scanner sc = new Scanner(getNextToken(false, true));
		return sc.nextLong(radix);
	}

	public void print(boolean b) { write(String.valueOf(b)); }
	public void print(char c) { write(String.valueOf(c)); }
	public void print(char[] s) { write(String.valueOf(s)); }
	public void print(double d) { write(String.valueOf(d)); }
	public void print(float f) { write(String.valueOf(f)); }
	public void print(int i) { write(String.valueOf(i)); }
	public void print(long l) { write(String.valueOf(l)); }
	public void print(Object obj) { write(String.valueOf(obj)); }
	public void print(String s) { write(s); }
	
	public void println() { write("\n"); }
	public void println(boolean x) { write(String.valueOf(x) + "\n"); }
	public void println(char x) { write(String.valueOf(x) + "\n"); }
	public void println(char[] x) { write(String.valueOf(x) + "\n"); }
	public void println(double x) { write(String.valueOf(x) + "\n"); }
	public void println(float x) { write(String.valueOf(x) + "\n"); }
	public void println(int x) { write(String.valueOf(x) + "\n"); }
	public void println(long x) { write(String.valueOf(x) + "\n"); }
	public void println(Object x) { write(String.valueOf(x) + "\n"); }
	public void println(String x) { write(x + "\n"); }

	public void setTextColor(Color col) {
		setColor(COUL_TEXTE_NORM_IDX, col);
	}

	public void setTextColor(float red, float green, float blue) {
		setColor(COUL_TEXTE_NORM_IDX, new Color(red, green, blue));
	}

	public void setTextColor(Color col, int x, int y) {
		setColor(COUL_TEXTE_NORM_IDX, col, x, y);
	}

	public void setTextColor(float red, float green, float blue, int x, int y) {
		setColor(COUL_TEXTE_NORM_IDX, new Color(red, green, blue), x, y);
	}

	public void setBackgroundColor(Color col) {
		setColor(COUL_FOND_NORM_IDX, col);
	}

	public void setBackgroundColor(float red, float green, float blue) {
		setColor(COUL_FOND_NORM_IDX, new Color(red, green, blue));
	}

	public void setBackgroundColor(Color col, int x, int y) {
		setColor(COUL_FOND_NORM_IDX, col, x, y);
	}

	public void setBackgroundColor(float red, float green, float blue, int x, int y) {
		setColor(COUL_FOND_NORM_IDX, new Color(red, green, blue), x, y);
	}

	public void gotoXY(int x, int y) {
		if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
			throw new ArrayIndexOutOfBoundsException("Coordonnées à l'extérieur de la console");
		}
		positionCurseur = new int[] {x, y};
		if (!GUI) { System.out.println(); }
	}

	public void setChar(char ch, int x, int y) {
		if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
			throw new ArrayIndexOutOfBoundsException("Coordonnées à l'extérieur de la console");
		}
		casesConsole[y][x].caractere = ch;		
		if (GUI) {
			casesConsole[y][x].paint();
		} else {
			System.out.print(ch);
		}
	}
	
	public char getChar(int x, int y) {
		if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
			throw new ArrayIndexOutOfBoundsException("Coordonnées à l'extérieur de la console");
		}
		return casesConsole[y][x].caractere;
	}

	public int readKey() { // Flush buffer???
		int key = 0;
		if (GUI) {
			KeyEvent ev;
			synchronized (clavierVerrou) {
				if (clavierTamponEvenement.size() == 0) {
					try {
						clavierVerrou.wait();
					} catch (InterruptedException e) {
						// Nothing to do
					}			
				}
				ev = clavierTamponEvenement.remove();
			}
			key = ev.getKeyChar();
			if (key == 0xFFFF) {
				key = ev.getKeyCode() + 0x10000;
			}
		} else {
			try {
				key = System.in.read();
			} catch (IOException ex) {
				// Nothing to do
			}
		}
		return key;
	}

	public void clear() {
		afficheConsole("Effacement de l'image: " + couleursBase[COUL_FOND_NORM_IDX]);
		initCasesConsole();
		if (GUI) {
			synchronized (image) {
				Color c = graphique.getColor();
				graphique.setColor(couleursBase[COUL_FOND_NORM_IDX]);
				graphique.fillRect(0, 0, largeur*CAR_LARG, hauteur*CAR_HAUT);
				graphique.setColor(c);
			}
			panel.repaint();
		} else {
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}

	public void sleep(long delay) {
		if (GUI) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException ex) {
				// Nothing to do
			}
		}
	}

	public boolean waitNextFrame() {
		if (GUI && imageChrono != null) {
			synchronized (imageVerrou) {
				try {
					imageVerrou.wait();
				} catch (InterruptedException ex) {
					// Nothing to do
				}
			}
		}
		return !GUI || imageChrono != null;
	}
	
	public void dump() {
		System.out.println();
		System.out.println("------------------------- CONSOLE DEBUT -------------------------");
		for (int i = 0; i < hauteur; ++i) {
			for (int j = 0; j < largeur; ++j) {
				if (casesConsole[i][j].caractere == 0) {
					System.out.print(' ');
				} else {
					System.out.print(casesConsole[i][j].caractere);
				}
			}
			System.out.println();
		}
		System.out.println("-------------------------  CONSOLE FIN  -------------------------");
		System.out.println();
	}
	
	
	// ------------------------- PRIVATE SECTION -------------------------
	private void write(String str) { 
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != '\n') {
				casesConsole[positionCurseur[1]][positionCurseur[0]].caractere = str.charAt(i);
				casesConsole[positionCurseur[1]][positionCurseur[0]].couleurs[COUL_TEXTE_NORM_IDX] = couleursBase[COUL_TEXTE_NORM_IDX];
				casesConsole[positionCurseur[1]][positionCurseur[0]].couleurs[COUL_FOND_NORM_IDX] = couleursBase[COUL_FOND_NORM_IDX];
				if (GUI) {
					casesConsole[positionCurseur[1]][positionCurseur[0]].paint();
				} else {
					System.out.print(str.charAt(i));
				}
				positionCurseur[0]++;
			}
			if (positionCurseur[0] >= largeur || str.charAt(i) == '\n') {
				positionCurseur[0] = 0;
				incCurseurY(false);
			}
		}
	}
	
	private void incCurseurY(boolean input) {
		positionCurseur[1]++;
		if (positionCurseur[1] >= hauteur) {
			positionCurseur[1] = hauteur-1;
			for (int i = 0; i < hauteur-1; ++i) {
				casesConsole[i] = casesConsole[i+1];
				for (int j = 0; j < largeur; ++j) {
					casesConsole[i][j].position[1]--;
				}
			}
			casesConsole[hauteur-1] = new CaseCon[largeur];
			for (int j = 0; j < largeur; ++j) {
				casesConsole[hauteur-1][j] = new CaseCon(j, hauteur-1, couleursBase);
			}
			if (GUI) { refresh(); }
		}
		if (!GUI && !input) { System.out.println(); }
	}

	private String getNextToken(boolean line, boolean remove) {
		String delim;
		String token;
		int endPos;
		
		if (line) {
			delim = "\n";
			while (tamponEntree.indexOf(delim) == -1) {
				keyEventToBuffer();				
			}
			token = tamponEntree.toString().split(delim, -1)[0] + delim;
			endPos = token.length();
		} else {
			delim = "[ \t\n\r\f]+";
			while (tamponEntree.toString().replaceAll(delim, "").length() == 0) {
				keyEventToBuffer();
			}
			token = tamponEntree.toString().replaceFirst("^" + delim, "").split(delim)[0];
			endPos = tamponEntree.indexOf(token) + token.length();
		}
		if (remove) {
			tamponEntree.delete(0, endPos);			
		}
		return token;
	}
	
	private void keyEventToBuffer() {
		if (tamponEntree.toString().trim().length() == 0) {
			char ch = 0xFFFF;
			do {
				if (GUI) {
					synchronized (clavierVerrou) {
						KeyEvent ev;
						if (clavierTamponEvenement.size() == 0) {
							try {
								clavierVerrou.wait();
							} catch (InterruptedException e) {
								// Nothing to do
							}
						}
						ev = clavierTamponEvenement.remove();
						ch = ev.getKeyChar();
					}
				} else {
					try {
						ch = (char) System.in.read();
					} catch (IOException ex) {
						// Nothing to do
					}
				}
				if (ch == '\b') {
					deleteChar();
				} else if (ch != 0xFFFF) {
					insertChar(ch);
				}
			} while (ch != '\n');
		}
	}
	
	private void insertChar(char ch) {
		tamponEntree.append(ch);
		if (ch == '\n') {
			positionCurseur[0] = 0;
			incCurseurY(true);
		} else {
			casesConsole[positionCurseur[1]][positionCurseur[0]].caractere = ch;
			casesConsole[positionCurseur[1]][positionCurseur[0]].entree = true;
			if (GUI) { casesConsole[positionCurseur[1]][positionCurseur[0]].paint(); }
			positionCurseur[0]++;
			if (positionCurseur[0] >= largeur) {
				positionCurseur[0] = 0;
				incCurseurY(true);
			}
		}
	}

	private void deleteChar() {
		if (tamponEntree.length() > 0 && tamponEntree.charAt(tamponEntree.length()-1) != '\n') {
			tamponEntree.deleteCharAt(tamponEntree.length()-1);
			positionCurseur[0]--;
			if (positionCurseur[0] < 0) {
				positionCurseur[0] = largeur-1;
				positionCurseur[1]--;
				if (positionCurseur[1] < 0) {
					positionCurseur[1] = 0;
				}
			}
			casesConsole[positionCurseur[1]][positionCurseur[0]].caractere = 0;
			casesConsole[positionCurseur[1]][positionCurseur[0]].entree = false;
			if (GUI) { casesConsole[positionCurseur[1]][positionCurseur[0]].paint(); }
		}
	}

	private void setColor(int colIdx, Color col) {
		afficheConsole("Couleur[" + colIdx + "] : " + col);
		couleursBase[colIdx] = col;
	}

	private void setColor(int colIdx, Color col, int x, int y) {
		if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
			throw new ArrayIndexOutOfBoundsException("Coordonnées à l'extérieur de la console");
		}
		casesConsole[y][x].couleurs[colIdx] = col;
		if (GUI) { casesConsole[y][x].paint(); }
	}

	private void initCasesConsole() {
		casesConsole = new CaseCon[hauteur][largeur];
		for (int i = 0; i < hauteur; ++i) {
			for (int j = 0; j < largeur; ++j) {
				casesConsole[i][j] = new CaseCon(j, i, couleursBase);
			}
		}
		positionCurseur = new int[] {0, 0};
	}

	private void refresh() {
		if (GUI) {
			for (int i = 0; i < hauteur; ++i) {
				for (int j = 0; j < largeur; ++j) {
					casesConsole[i][j].paint();
				}
			}
			panel.repaint();
		}
	}
	
	private void imageSynchronise() {
		if (GUI) {
			panel.repaint();
			try {
				javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
					public void run() { }
				});
			} catch (InterruptedException | InvocationTargetException ex) {
				// Nothing to do
			}
		}
	}
	
	private void afficheConsole(String message) {
		if (DEBUG) { System.out.println(message); }
	}

	// A etre execute sur un thread separe pour la gestion de la fenetre de console
	private void creerGUI() {
		panel = new CPanel();
		frame = new JFrame(titre);
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(new CGestionClavier());
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	// ******************** PANNEAU D'AFFICHAGE DE L'IMAGE ********************
	private class CPanel extends JPanel {
		CPanel() {
			Console w = Console.this;
			Dimension dimension = new Dimension(w.largeur*CAR_LARG, w.hauteur*CAR_HAUT);
			super.setMinimumSize(dimension);
			super.setMaximumSize(dimension);
			super.setPreferredSize(dimension);
		}

		public void paint(Graphics g) {
			Console w = Console.this;
			synchronized (w.image) { g.drawImage(w.image, 0, 0, null); }
		}

		private static final long serialVersionUID = 0;
	}

	// ******************** CLASSES POUR LES RAPPELS I/O ********************
	private class CGestionClavier extends KeyAdapter {
		public void keyPressed(KeyEvent ev) {
			Console w = Console.this;
			synchronized (w.clavierVerrou) {
				w.clavierTamponEvenement.add(ev);
				clavierVerrou.notifyAll();
			}
		}
	}

	private class CImageChronoTache extends TimerTask {
		int[] curDrawPos = {0, 0};
		public void run() {
			Console w = Console.this;
			synchronized (w.imageVerrou) {
				if (positionCurseur[0] != curDrawPos[0] || positionCurseur[1] != curDrawPos[1]) {
					casesConsole[curDrawPos[1]][curDrawPos[0]].paint();
					curDrawPos = positionCurseur.clone();
					curseurTick = -15;
				}
				if (curseurTick == 0 || curseurTick == -15) {
					casesConsole[curDrawPos[1]][curDrawPos[0]].paint();
				}
				if (curseurTick == -15) {
					synchronized (w.image) {
						graphique.setColor(casesConsole[curDrawPos[1]][curDrawPos[0]].couleurs[COUL_TEXTE_NORM_IDX]);
						graphique.drawChars(new char[] {'_'}, 0, 1, curDrawPos[0]*CAR_LARG, curDrawPos[1]*CAR_HAUT+CAR_BASE);
					}
				}
				curseurTick++;
				if (curseurTick > 15) { curseurTick = -15; }
				imageVerrou.notifyAll();
			}
		}
	}
	
	private class CaseCon {
		public char caractere;
		public int[] position;
		public Color[] couleurs;
		public boolean entree, selection;
		
		CaseCon(int posX, int posY, Color[] couleursIni) {
			caractere = 0;
			position = new int[] {posX, posY}; 
			couleurs = couleursIni.clone(); 
			entree = false;
			selection = false;
		}
		
		public void paint() {
			Color couleurFond, couleurTexte;
			afficheConsole("Rectangle: " + position[0] + ", " + position[1]);
			if (GUI) {
				synchronized (image) {
					if (entree) {
						couleurFond = couleurs[COUL_FOND_ENT_IDX];
						couleurTexte = couleurs[COUL_TEXTE_ENT_IDX];
					} else {
						couleurFond = couleurs[COUL_FOND_NORM_IDX];
						couleurTexte = couleurs[COUL_TEXTE_NORM_IDX];
					}
					graphique.setColor(couleurFond);
					graphique.fillRect(position[0]*CAR_LARG, position[1]*CAR_HAUT, CAR_LARG, CAR_HAUT);
					graphique.setColor(couleurTexte);
					if (caractere != 0) {
						graphique.drawChars(new char[] {caractere}, 0, 1, position[0]*CAR_LARG, position[1]*CAR_HAUT + CAR_BASE);
					}
				}
				panel.repaint(position[0]*CAR_LARG, position[1]*CAR_HAUT, CAR_LARG, CAR_HAUT);
			}
		}
	}

	private static final int COUL_TEXTE_NORM_IDX = 0;
	private static final int COUL_FOND_NORM_IDX = 1;
	private static final int COUL_TEXTE_ENT_IDX = 2;
	private static final int COUL_FOND_ENT_IDX = 3;
	private static final int COUL_TEXTE_SEL_IDX = 4;
	private static final int COUL_FOND_SEL_IDX = 5;
	private static final int COULEUR_MAX_IDX = 6;

	private static final int CAR_LARG = 8;
	private static final int CAR_HAUT = 16;
	private static final int CAR_BASE = 12;
	
	private final String titre; // Titre de la fenetre
	public final int largeur; // Nombre de caractères en largeur (8 pixels / caractère)
	public final int hauteur; // Nombre de caractères en hauteur (16 pixels / caractère)
	private CaseCon[][] casesConsole;
	private Color[] couleursBase; //
	private int[] positionCurseur; // Position actuelle du curseur [x, y]
	private int curseurTick; // Pour clignoter le curseur 
	private boolean defilement;
	private boolean retourLigne;
	
	private JFrame frame; // Fenetre principale
	private CPanel panel; // Panneau contenant l'image
	private BufferedImage image; // Le tampon de l'image a afficher
	private Graphics2D graphique; // Le contexte graphique associe a l'image
	private Object clavierVerrou; // Verrou pour les evenements du clavier
	private LinkedList<KeyEvent> clavierTamponEvenement; // Tampon evenements clavier
	private StringBuilder tamponEntree; 
	private Object imageVerrou; // Verrou associe a l'image
	private Timer imageChrono; // Chrono pour synchroniser les animations
}
