package legaultol.at03;
import java.util.*;
import java.math.*;
public class Ex06 {

    public static void main(String[] args) {
        int[] iTableau1={-65,-34,7,-3,-43,14,23,-9,45,11};
        int iCompteur2=0;
        int iSommePos=0,iSommeNeg=0;
        int[] iTableau2=new int[10];
        Random random =new Random();
        for (int i=0;i<10;i++) {

            iTableau2[i]=random.nextInt(-100,100);
            
        }

            for (int i = 0; i < iTableau1.length; i++) { 

                if (iTableau1[iCompteur2]<0) {
                    iSommeNeg+=iTableau1[iCompteur2];
                }
                else if (iTableau1[iCompteur2]>0) {
                    iSommePos=+iTableau1[iCompteur2];
                    
                }
                iCompteur2++;
            }
            System.out.println(iSommeNeg +" "+iSommePos);
            CalculeSomme(iTableau2);


    }
    public static void CalculeSomme(int[]iTableau2){
        int iCompteur2=0;
        int iSommeNeg=0,iSommePos=0;

        for (int i = 0; i < iTableau2.length; i++) { 

                if (iTableau2[iCompteur2]<0) {
                    iSommeNeg+=iTableau2[iCompteur2];
                }
                else if (iTableau2[iCompteur2]>0) {
                    iSommePos=+iTableau2[iCompteur2];
                    
                }
                iCompteur2++;
            }
            System.out.println(iSommeNeg +" "+iSommePos);
            

    }
}
