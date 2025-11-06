package legaultol.at02;

import java.util.*;
import java.math.*;

public class Ex02 {
public static void main(String[] args) {

     
exercice13(args);
    
 


    
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


    ArrayList<String> Mots = new ArrayList<String>();//déclare la liste


    Scanner entre = new Scanner(System.in);
do{

    System.out.println("entrez un mot :");
    Mots.add(entre.nextLine());
    Mots.getLast().toLowerCase();

}
while(Mots.getLast().equals("stop") == false);
Mots.removeLast();
Mots.sort(null);//sort les mots
System.out.println("le premier mot est "+Mots.getFirst());
System.out.println("le dernier mot est "+Mots.getLast());



}


public static float circon(float fRayon) {
        // Using the correct formula for circumference
        float fCirconference = 2 * (float)Math.PI * fRayon;
        return fCirconference;
    }
public static void exercice9(String[] args) {

    float fRayon;

    Scanner entre= new Scanner(System.in);
    System.out.println("bonjour, entrez le rayon du cercle a calculer en cm");
    fRayon=entre.nextFloat();
    circon(fRayon);
    System.out.println("la circonférence du cercle est de "+circon(fRayon)+" cm");
    

 


}

public static int plusgrand(int iNombreUn,int iNombreDeux){
int iNombreGrand=0;
    if (iNombreUn>iNombreDeux) {
        iNombreGrand=1;
    }
    else if (iNombreDeux>iNombreUn) {
        iNombreGrand=2;
    }
    else{
        iNombreGrand=0;
    }


    return iNombreGrand;
}
public static void exercice10(String[] args) {
int iNombreUn=0,iNombreDeux=0;
Scanner entre1= new Scanner(System.in);
Scanner entre2= new Scanner(System.in);


System.out.println("bonjour, veuillez entrez le premier numéro:");
iNombreUn=entre1.nextInt();
System.out.println("veuillez entrez le deuxième numéro:");
iNombreDeux=entre2.nextInt();

plusgrand(iNombreUn, iNombreDeux);
if (plusgrand(iNombreUn, iNombreDeux)==1) {
    System.out.println("le premier numéro es tle plus grand");
}
else if (plusgrand(iNombreUn, iNombreDeux)==2) {
    System.out.println("le deuxième numéro est le plus grand");    
}
else{
    System.out.println("les deux numéros sont pareil");
}
    
}

public static int factorielle(int iNombre){
    int iFact=1;
    int i;


    
  for(i=1;i<=iNombre;i++){
      iFact=iFact*i;//calcule la factorasitationnn ou wtv ca sepelle 
  }


    return iFact;


}
public static void exercice11(String[] args) {
int iNombre=0;
Scanner entre =new Scanner(System.in);
System.out.println("bonjour, veuillez entrez le numéro: ");
iNombre=entre.nextInt();
System.out.println("la valeur factorielle du nombre "+iNombre+" est de "+factorielle(iNombre));

    
}

    public static int sommeMinMax(int iMin , int iMax){
            int iNumb=iMin;
        
            for (int i=iMin+1; i <= iMax; i++){
                    iNumb+=i;
            }
          
            return iNumb;

    }
public static void exercice12(String[] args) {
    int iMin=0,iMax=0;
    Scanner entre1 = new Scanner(System.in);
    System.out.println("entrez le numéro minimum:");
    iMin=entre1.nextInt();
    Scanner entre2 =new Scanner(System.in);
    System.out.println("entrez le numéro maximum:");
    iMax=entre2.nextInt();
    sommeMinMax(iMin, iMax);
    System.out.println("la somme de ces chiffres est: "+sommeMinMax(iMin, iMax));




    
}

public static float convCel(float fTemp){


    float fTempF=0;

    fTempF=fTemp*9/5+32;
    return fTempF;


}

public static float convFar(float fTemp){


    float fTempC=0;

    fTempC=(fTemp-32)*5/9;
    return fTempC;


}


public static void exercice13(String[] args) {
float ftemp=0;
int choix=0;
Scanner entre1 = new Scanner(System.in);
Scanner entre2 = new Scanner(System.in);



    System.out.println("type de conversion a faire?  C a F [1]   F a C [2] ");
choix=entre2.nextInt();
System.out.println("entrez la température a convertir (en degrés)");
ftemp=entre1.nextFloat();
if (choix==1) {

    System.out.println("la température en farenheit est "+convCel(ftemp)+"° F");
    
}
else if (choix==2) {

    System.out.println("la température en Celcius est "+convFar(ftemp)+"° C");
    
}










    
}


}
