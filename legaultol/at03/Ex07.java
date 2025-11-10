package legaultol.at03;
import java.util.*;
import java.math.*;

public class Ex07 {
    public static void main(String[] args) {
        Random random=new Random();
   int  iTableau[]=new int[10];

    for (int i = 0; i < iTableau.length; i++) { 
        iTableau[i]=random.nextInt(5);


       }    
       Calcule(iTableau);



 




       
   
   
   
   
 }
 public static void Calcule(int[]iTableau){
    int iCompteur0=0,iCompteur1=0,iCompteur2=0,iCompteur3=0,iCompteur4=0;
    for (int i = 0; i < iTableau.length; i++){
        switch (iTableau[i]) {
            case 0:
                iCompteur0++;
                break;
            case 1:
                iCompteur1++;
                break;
            case 2:
                iCompteur2++;
                break;
            case 3:
                iCompteur3++;
                break;
            case 4:
                iCompteur4++;
                break;
            }
           
        }
    System.out.println();
        System.out.println("il y a "+iCompteur0+" zéros");
        System.out.println("il y a "+iCompteur1+" un");
        System.out.println("il y a "+iCompteur2+" deux");
        System.out.println("il y a "+iCompteur3+" trois");
        System.out.println("il y a "+iCompteur4+" quatres");


 }
   
   



    
    


 



}
