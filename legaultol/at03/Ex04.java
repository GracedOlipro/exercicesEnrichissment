package legaultol.at03;
import java.util.*;
import java.math.*;

public class Ex04 {
    public static void main(String[] args) {
        int [] iTab=new int[5];
        Random random= new Random();
        
        for (int i=0;i<5;i++) {
            iTab[i]=random.nextInt(100);
            
        }
        if (iTab[0]>iTab[1]&& iTab[0]>iTab[2]&&iTab[0]>iTab[3]&&iTab[0]>iTab[4]) {
            System.out.println("le premier nombre est plus grand");
            System.out.println("le plus grand numéro est le: "+iTab[0]);
        }
        else if (iTab[1]>iTab[0]&& iTab[1]>iTab[2]&&iTab[1]>iTab[3]&&iTab[1]>iTab[4]) {
            System.out.println("le deuxieme nombre est plus grand");
            System.out.println("le plus grand numéro est le: "+iTab[1]);
            
        }
        else if (iTab[2]>iTab[0]&& iTab[2]>iTab[1]&&iTab[2]>iTab[3]&&iTab[2]>iTab[4]) {
            System.out.println("le troisieme nombre est plus grand");
            System.out.println("le plus grand numéro est le: "+iTab[2]);
            
        }
        else if (iTab[3]>iTab[0]&& iTab[3]>iTab[1]&&iTab[3]>iTab[2]&&iTab[3]>iTab[4]) {
            System.out.println("le quatrieme nombre est plus grand");
            System.out.println("le plus grand numéro est le: "+iTab[3]);
            
        }
         else if (iTab[4]>iTab[0]&& iTab[4]>iTab[1]&&iTab[4]>iTab[3]&&iTab[4]>iTab[2]) {
            System.out.println("le cinquieme nombre est plus grand");
            System.out.println("le plus grand numéro est le: "+iTab[4]);
            
        }

        if (iTab[0]<iTab[1]&& iTab[0]<iTab[2]&&iTab[0]<iTab[3]&&iTab[0]<iTab[4]) {
            System.out.println("le premier nombre est plus petit");
            System.out.println("le plus petit numéro est le: "+iTab[0]);
        }
        else if (iTab[1]<iTab[0]&& iTab[1]<iTab[2]&&iTab[1]<iTab[3]&&iTab[1]<iTab[4]) {
            System.out.println("le deuxieme nombre est plus petit");
            System.out.println("le plus petit numéro est le: "+iTab[1]);
            
        }
        else if (iTab[2]<iTab[0]&& iTab[2]<iTab[1]&&iTab[2]<iTab[3]&&iTab[2]<iTab[4]) {
            System.out.println("le troisieme nombre est plus petit");
            System.out.println("le plus petit numéro est le: "+iTab[2]);
            
        }
        else if (iTab[3]<iTab[0]&& iTab[3]<iTab[1]&&iTab[3]<iTab[2]&&iTab[3]<iTab[4]) {
            System.out.println("le quatrieme nombre est plus petit");
            System.out.println("le plus petit numéro est le: "+iTab[3]);
            
        }
         else if (iTab[4]<iTab[0]&& iTab[4]<iTab[1]&&iTab[4]<iTab[3]&&iTab[4]<iTab[2]) {
            System.out.println("le cinquieme nombre est plus petit");
            System.out.println("le plus petit numéro est le: "+iTab[4]);
            
        }



        else    {
            System.out.println("tous les numéros s'ont pareils");
        }
        

        



    }

}
