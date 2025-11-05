package sandbox;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class PseudoSyntaxe {
	public static void main(String[] args) throws IOException {
		List<String> typeVars = Arrays.asList("NUMÉRIQUE", "NUMERIQUE", 
				"CARACTÈRE", "CARACTERE", "CHAÎNE", "CHAINE", "BOOLÉEN", "BOOLEEN");
		HashMap<String, Boolean> varNames = new HashMap<String, Boolean>();
		varNames.put("", true);
		String name;
		JTextArea jta = new JTextArea();
		jta.setColumns(80);
		jta.setRows(25);
		JOptionPane.showMessageDialog(null, new JScrollPane(jta),"Pseudo-code", JOptionPane.QUESTION_MESSAGE);
		String[] splitAlgo = jta.getText().split("\n");
		StringReader sr = new StringReader(jta.getText());
		String text = jta.getText();
		StreamTokenizer st = new StreamTokenizer(sr);
		st.wordChars('_', '_');
		st.ordinaryChar('/');
		st.eolIsSignificant(true);

		// Recherche ALGORITHME
		safeNextToken(st);
		skipEmptyLine(st);
		if (st.ttype != StreamTokenizer.TT_WORD || 
				(st.ttype == StreamTokenizer.TT_WORD && !st.sval.toUpperCase().equals("ALGORITHME"))) {
			System.out.println("Un algorithme doit debuter par le mot cle ALGORITHME");
			while (st.ttype != StreamTokenizer.TT_WORD || 
					(st.ttype == StreamTokenizer.TT_WORD && st.sval.toUpperCase() != "ALGORITHME")) {
				nextLine(st);
			}
		}
		if (!st.sval.equals("ALGORITHME")) {
			System.out.println("Le mot cle ALGORITHME doit etre ecrit en majuscule");
		}
		safeNextToken(st);
		name = getName(st);
		validateName(name,"^[a-zA-Z][a-zA-Z0-9]*$");
		if (st.ttype != StreamTokenizer.TT_EOL) {
			System.out.println("Ligne ALGORITHME mal ecrite");			
		}
		nextLine(st);

		// Recherche CONTANTES ou VARIABLES
		skipEmptyLine(st);
		if (st.ttype != StreamTokenizer.TT_WORD || 
				(st.ttype == StreamTokenizer.TT_WORD && 
				(!st.sval.toUpperCase().equals("CONSTANTES")&&!st.sval.toUpperCase().equals("VARIABLES")))) {
			System.out.println("La section CONSTANTES (ou VARIABLES) doit suivre ALGORITHME");
			while (st.ttype != StreamTokenizer.TT_WORD || 
					(st.ttype == StreamTokenizer.TT_WORD && 
					(!st.sval.toUpperCase().equals("CONSTANTES")&&!st.sval.toUpperCase().equals("VARIABLES")))) {
				nextLine(st);
			}
		}
		// Section constantes presente
		if (st.sval.toUpperCase().equals("CONSTANTES")) {
			if (!st.sval.equals("CONSTANTES")) {
				System.out.println("Le mot cle CONSTANTES doit etre ecrit en majuscule");
			}
			safeNextToken(st);
			if (st.ttype != StreamTokenizer.TT_EOL) {
				System.out.println("Le mot cle CONSTANTES doit etre ecrit seul sur sa ligne");				
			}
			nextLine(st);
			while (st.ttype != StreamTokenizer.TT_WORD) {
				safeNextToken(st);
			}
			while (st.ttype == StreamTokenizer.TT_WORD && !st.sval.toUpperCase().equals("VARIABLES")) {
				name = getName(st);
				validateName(name, "^[A-Z][A-Z0-9_]*$");
				if (st.ttype != '=') {
					System.out.println("Une constante doit avoir une valeur");
				}
				if (varNames.containsKey(name)) {
					System.out.println("Constante deja declaree : " +  name);
				}
				varNames.put(name, true);
				int prevToken = st.ttype;
				while (st.ttype != StreamTokenizer.TT_WORD) {
					prevToken = st.ttype;
					safeNextToken(st);
				}
				if (prevToken != StreamTokenizer.TT_EOL && prevToken != ',') {
					System.out.println("Les constantes doivent etre separees par des virgules ou des sauts de lignes");					
				}
			}
		}

		// Section VARIABLES
		if (!st.sval.equals("VARIABLES")) {
			System.out.println("Le mot cle VARIABLES doit etre ecrit en majuscule");
		}
		safeNextToken(st);
		if (st.ttype != StreamTokenizer.TT_EOL) {
			System.out.println("Le mot cle VARIABLES doit etre ecrit seul sur sa ligne");				
		}
		nextLine(st);
		while (st.ttype != StreamTokenizer.TT_WORD) {
			safeNextToken(st);
		}
		boolean typeFound = false;
		while (st.ttype == StreamTokenizer.TT_WORD && 
				(!st.sval.toUpperCase().equals("DEBUT") && !st.sval.toUpperCase().equals("DÉBUT"))) {
			typeFound = false;
			name = getName(st);
			validateName(name, "^[a-z][a-zA-Z0-9]*$");
			if (st.ttype != ',' && (st.ttype == StreamTokenizer.TT_WORD && !st.sval.toUpperCase().equals("TYPE"))) {
				System.out.println("Les variables doivent etre separees par des virgules et avoir un type : " + name);
			}
			if (varNames.containsKey(name)) {
				System.out.println("Variable deja declaree : " +  name);
			}
			varNames.put(name, false);
//			System.out.println(varNames);
			if (st.ttype == StreamTokenizer.TT_WORD && st.sval.toUpperCase().equals("TYPE")) {
				if (!st.sval.equals("TYPE")) {
					System.out.println("Le mot cle TYPE doit etre ecrit en majuscule");
				}
				safeNextToken(st);
				if (st.ttype != StreamTokenizer.TT_WORD) {
					System.out.println("Vous devez spécifier le type de la variable");
				} else if (!typeVars.contains(st.sval.toUpperCase())) {
					System.out.println("Type de variable invalide : " + st.sval);
				} else if (!typeVars.contains(st.sval)) {
					System.out.println("Le type de variable doit etre en majuscule");
					safeNextToken(st);					
					typeFound = true;
				} else {
					safeNextToken(st);
					typeFound = true;
				}
				if (st.ttype != StreamTokenizer.TT_EOL) {
					System.out.println("Le type de variable doit etre en fin de ligne");					
				}
				nextLine(st);
			}
			while (st.ttype != StreamTokenizer.TT_WORD) {
				safeNextToken(st);
			}
		}

		if (!typeFound) {
			System.out.println("Pour certaines variables le type n'est pas indique");
		}
		
//		System.out.print(varNames.toString());
		// Section Algorithme
		if (!st.sval.equals("DEBUT") && !st.sval.equals("DÉBUT")) {
			System.out.println("Le mot cle DEBUT doit etre ecrit en majuscule");
		}
		safeNextToken(st);
		if (st.ttype != StreamTokenizer.TT_EOL) {
			System.out.println("Le mot cle DEBUT doit etre ecrit seul sur sa ligne");				
		}
		nextLine(st);
		if (st.ttype != StreamTokenizer.TT_WORD) {
			if (st.ttype == StreamTokenizer.TT_NUMBER) {
				safeNextToken(st);					
			}
			if (st.ttype != StreamTokenizer.TT_WORD) {
				System.out.println("Une ligne doit debuter par un mot cle ou un nom de variable");
				while (st.ttype != StreamTokenizer.TT_WORD) {
					safeNextToken(st);
				}
			}
		}
		while (st.ttype == StreamTokenizer.TT_WORD && !st.sval.toUpperCase().equals("FIN")) {
			// Cas de AFFICHER
			if (st.sval.toUpperCase().equals("AFFICHER")) {
				if (!st.sval.equals("AFFICHER")) {
					System.out.println("Le mot cle AFFICHER doit etre ecrit en majuscule");
				}
				safeNextToken(st);
				if (st.ttype != '(') {
					System.out.println("Une parenthese devrait apparaitre apres AFFICHER");
				} else {
					safeNextToken(st);
					while (st.ttype != ')') {
						if (st.ttype == '"') {
							safeNextToken(st);							
						} else {
							name = getName(st);
							if (!varNames.containsKey(name)) {
								System.out.println("Variable non declaree: " + name);							
							} else if (!varNames.get(name)) {
								System.out.println("Variable non initialisee: " + name);														
							}
						}
						if (st.ttype != ')') {
							if (st.ttype != ',') {
								System.out.println("Les parametres de AFFICHER doivent etre separes par des virgules");				
							}
							safeNextToken(st);
							while (st.ttype == StreamTokenizer.TT_EOL) {
								safeNextToken(st);
							}
						}
					}
					safeNextToken(st);
					if (st.ttype != StreamTokenizer.TT_EOL) {
						System.out.println("AFFICHER devrait etre seul sur sa ligne");								
					}
				}
				nextLine(st);
			} else if (st.sval.toUpperCase().equals("LIRE")) { // Cas de LIRE
				if (!st.sval.equals("LIRE")) {
					System.out.println("Le mot cle LIRE doit etre ecrit en majuscule");
				}
				safeNextToken(st);
				if (st.ttype != '(') {
					System.out.println("Une parenthese devrait apparaitre apres LIRE");
				} else {
					safeNextToken(st);
					if (st.ttype != StreamTokenizer.TT_WORD) {
						System.out.println("Une variable devrait apparaitre apres LIRE");
					} else {
						name = getName(st);
						if (!varNames.containsKey(name)) {
							System.out.println("Variable non declaree: " + name);
						} else {
							varNames.put(name, true);
						}
						if (st.ttype != ')') {
							System.out.println("Une parenthese devrait apparaitre apres LIRE");
						} else {
							safeNextToken(st);
							if (st.ttype != StreamTokenizer.TT_EOL) {
								System.out.println("LIRE devrait etre seul sur sa ligne");								
							}
						}
					}
				}
				nextLine(st);
			} else { // Autres cas: affectation
				name = getName(st);
				if (!varNames.containsKey(name)) {
					System.out.println("Variable non declaree: " + name);
				} else {
					varNames.put(name, true);
				}
				if (st.ttype == '=') {
					System.out.println("En pseudo-code, vous devez utiliser la fleche pour les affectations");					
				}
				if (st.ttype != StreamTokenizer.TT_EOL) {
					safeNextToken(st);
				}
				while (st.ttype != StreamTokenizer.TT_EOL) {
					if (st.ttype == StreamTokenizer.TT_WORD) {
						name = getName(st);
						if (!varNames.containsKey(name)) {
							System.out.println("Variable non declaree: " + name);							
						} else if (!varNames.get(name)) {
							System.out.println("Variable non initialisee: " + name);														
						}
					} else if (st.ttype == StreamTokenizer.TT_NUMBER) {
						System.out.println("Constante ? " + st.nval);							
						safeNextToken(st);
					} else {
						safeNextToken(st);
					}
				}
				nextLine(st);
			}
			if (st.ttype != StreamTokenizer.TT_WORD) {
				if (st.ttype == StreamTokenizer.TT_NUMBER) {
					safeNextToken(st);					
				}
				if (st.ttype != StreamTokenizer.TT_WORD) {
					System.out.println("Une ligne doit debuter par un mot cle ou un nom de variable");
					while (st.ttype != StreamTokenizer.TT_WORD) {
						safeNextToken(st);
					}
				}
			}

//			if (st.ttype == StreamTokenizer.TT_WORD) {	
//				System.out.println(st.sval);
//				if (motCles.contains(st.sval)) {
//					System.out.println("Mot clé : " + st.sval);
//				} else if (motCles.contains(st.sval.toUpperCase())) {
//					System.out.println("Mot clé incorrect : " + st.sval);					
//				} else {
//					System.out.println(st.sval);					
//				}
//			} else if (st.ttype == StreamTokenizer.TT_NUMBER) {
//				System.out.println(st.nval);				
//			} else if (st.ttype == StreamTokenizer.TT_EOL) {
//				
//			} else if (st.ttype == '"') {
//				System.out.println(st.sval);
//			} else {
//				System.out.println((char) st.ttype);
//			}
//			safeNextToken(st);
		}
		
		for (int i = 0; i < splitAlgo.length; ++i) {
//			System.out.println(splitAlgo[i]);
		}
		
		Iterator<String> namesItr = varNames.keySet().iterator();
		while (namesItr.hasNext()) {
			name = namesItr.next();
			if (!varNames.get(name)) {
				System.out.println("Variable declaree, mais inutilisee: " + name);
			}
		}
//		System.out.println(varNames.toString());
		System.out.println("Analyse terminee");
	}
	
	public static void validateName(String name, String regex) {
		List<String> motCles = Arrays.asList("ALGORITHME", "CONSTANTES", "VARIABLES", "DEBUT", 
				"DÉBUT", "FIN", "AFFICHER", "LIRE", "TYPE", "NUMÉRIQUE", "NUMERIQUE", 
				"CARACTÈRE", "CARACTERE", "CHAÎNE", "CHAINE", "BOOLÉEN", "BOOLEEN");

		if (!name.matches(regex)) {
			System.out.println("Nom invalide : " + name);
		}
		if (motCles.contains(name.toUpperCase())) {
			System.out.println("Le nom choisi est un mot cle");			
		}
	}
	
	public static void nextLine(StreamTokenizer st) throws IOException {
		while (st.ttype != StreamTokenizer.TT_EOF && st.ttype != StreamTokenizer.TT_EOL) {
			safeNextToken(st);
		}
		safeNextToken(st);
	}

	public static void skipEmptyLine(StreamTokenizer st) throws IOException {
		while (st.ttype == StreamTokenizer.TT_EOL) {
			nextLine(st);
		}
	}

	public static String getName(StreamTokenizer st) throws IOException {
		if (st.ttype != StreamTokenizer.TT_WORD || st.sval.toUpperCase().equals("TYPE")) {
			return "";
		}
		if (st.ttype == StreamTokenizer.TT_WORD  && st.sval.length() == 1 && !st.sval.matches("[a-zA-Z]")) {
			safeNextToken(st);
			return "";
		}
		String result  = st.sval;
		safeNextToken(st);
		while (st.ttype == StreamTokenizer.TT_WORD && !st.sval.toUpperCase().equals("TYPE")
				&& (st.sval.length() > 1 || st.sval.matches("[a-zA-Z]"))) {
			result = result + " " + st.sval;
			safeNextToken(st);
		}
		return result;
	}
	
	public static void safeNextToken(StreamTokenizer st) throws IOException {
		st.nextToken();
		if (st.ttype == StreamTokenizer.TT_EOF) {
			System.out.println("Algorithme incomplet");
			System.exit(1);
		}
	}
}

/*


ALGORITHME calculFacture

VARIABLES
    total, totalProduit1, prixProduit1, quantiteProduit  TYPE NUMÉRIQUE

CONSTANTES
    TAUX_TPS = 5%
    TVQ = 9,975% 

DBUT
    AFFICHER("Entrez le prix du produit") 
    LIRE(prixProduit)
    AFFICHER("Entrez la quantité achetée") 
    LIRE(quantiteProduit)
    totalProduit ← prixProduit * quantiteProduit 
    total ← totalProduit
    total ← total + totalProduit * TPS
    total ← total + totalProduit * TVQ 
    AFFICHER("Le total de la facture est ", total)
FIN




ALGORITHME calculFacture

CONSTANTES
    TAUX_TPS = 5%
    TVQ = 9,975% 

VARIABLES
    total, totalProduit, prixProduit, quantiteProduit  TYPE NUMÉRIQUE

DÉBUT
    AFFICHER("Entrez le prix du produit") 
    LIRE(prixProduit)
    AFFICHER("Entrez la quantité achetée") 
    LIRE(quantiteProduit)
    totalProduit <-- prixProduit * quantiteProduit 
    total ← totalProduit
    total ← total + totalProduit * TAUX_TPS
    total ← total + totalProduit * TVQ 
    AFFICHER("Le total de la facture est ", total)
FIN
*/