package legaultol.at03;

import java.util.Scanner;

public class Ex02 {

    public static void main(String[] args) {
        int Tableau[]=new int[10];

        int iCompteur=0,iCompteur2=0;
        Scanner entScanner =new Scanner(System.in);
        int inombre;

            for (int i = 0; i < 10; i++){
                System.out.println("entrez le numéro");
                inombre=entScanner.nextInt();
                Tableau[iCompteur]=inombre;
                iCompteur++;
            }

          for (int i = 0; i < 10; i++) { System.out.print(Tableau[iCompteur2]);
          iCompteur2++;}

            

    }

}
