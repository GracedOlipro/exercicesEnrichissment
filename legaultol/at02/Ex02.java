package legaultol.at02;

import java.util.*;

public class Ex02 {
public static void main(String[] args) {
exercice8(args);
 


    
}






public static void exercice1(String[] args) {
       String sMot;
        //variables


    System.out.println("entrez le mot ou la phrase: "); //le print 
    Scanner entre = new Scanner (System.in);
    sMot=entre.next();
    System.out.println(sMot.toUpperCase());//met le string en majuscule et l'affiche
}


public static void exercice2(String[] args) {
        
 String sMot="";
        //variables


    System.out.println("entrez le mot ou la phrase: "); //le print 
    Scanner entre = new Scanner (System.in);
    sMot=entre.nextLine();
    System.out.println(sMot.replace(" ", "").length());//affiche le nombre de lettre dans la phrase ou le mot sans compter les espaces


}

public static void exercice3(String[] args) {
    
String sMot="";
 char CharCompte='a';
 int NBa=0;
        //variables





    System.out.println("entrez le mot ou la phrase: "); //le print 
    Scanner entre = new Scanner (System.in);
    sMot=entre.nextLine();
            for (int i = 0; i < sMot.length(); i++) {
            // Check if the current character matches the target character
            if (sMot.charAt(i) ==CharCompte) {
                NBa++; // Increment the count if it matches
            }
        }




    System.out.println(sMot.replace("a", "$".toUpperCase())+"la lettre a apparait "+NBa+" fois");//affiche le nombre de lettre dans la phrase ou le mot sans compter les espaces


}

public static void exercice4(String[] args) {
    
        int iNombre;

do{
    System.out.println("bonjour, entrez un nombre entre 1 et 100");
    Scanner Entre1 = new Scanner (System.in);
    iNombre=Entre1.nextInt();

}
while(iNombre<1||iNombre>100);
    


}

public static void exercice5(String[] args) {
      String iAlphabet="ABCDEFGHIJKLMNOPQRSTUVWYZ";
        String iReverseAlphabet ="ZYWVUTSRQPONMLKJIHGFEDCBA";


          for (int i = 0; i < 1; i++){
      
            System.out.println(iAlphabet);
            if (i==0) {
                System.out.println();
                System.out.println(iReverseAlphabet);
            }
         
    } 

}

public static void exercice6(String[] args) {
    
int iNumb[];
ArrayList<Integer> nombres = new ArrayList<Integer>();
Scanner entre = new Scanner(System.in);
do{

    System.out.println("entrez un numéro :");
    nombres.add(entre.nextInt());

}
while(nombres.getLast()!=0);
nombres.removeLast();
nombres.sort(null);
System.out.println("le plus grand nombre est: "+nombres.getLast());
System.out.println("le plus petit nombre est: "+nombres.getFirst());

int i;
int somme=0,moyenne;
for( i = 0; i < nombres.size(); i++) somme += nombres.get(i);
moyenne=somme/nombres.size();


System.out.println("la moyenne est de :"+moyenne);




}

public static void exercice7(String[] args) {
  int iConsonne=0, iVoyelles=0;
  String sMot;
    Scanner entre= new Scanner(System.in);
    System.out.println("veuillez entrez le mot:");
    sMot=entre.nextLine();

     for (int i = 0; i < sMot.length(); i++) {
            // Check if the current character matches the target character
            if (sMot.charAt(i) =='a'||sMot.charAt(i) =='e'||sMot.charAt(i) =='i'||sMot.charAt(i) =='o'||sMot.charAt(i) =='u'||sMot.charAt(i) =='y') {
                iVoyelles++; // Increment des voyelles
            }
            else{
                iConsonne++; //incrément des consonnes
            }
        }
        System.out.println("dans la phrase il y a "+iVoyelles+" voyelles et "+iConsonne+" consonnes");

    
}
public static void exercice8(String[] args) {
    
}

public static void exercice9(String[] args) {
    
}

public static void exercice10(String[] args) {
    
}

public static void exercice12(String[] args) {
    
}


public static void exercice13(String[] args) {
    
}


}
