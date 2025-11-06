package legaultol.at03;
import java.text.RuleBasedCollator;
import java.util.*;

public class Ex03 {

    public static void main(String[] args) {

        List<Integer> tab = new ArrayList<>();
      
        int iChoix=0,iCompteur1=0,iCompteur2=0;
        Random random= new Random();
        int iRandomNumber=0;
        Scanner entre1 =new Scanner(System.in);
        System.out.println("bonjour, entrez le nombre de chiffres aléatoires");
        iChoix=entre1.nextInt();
    
        

         for (int i=0; i <iChoix; i++)
            {
                tab.add(random.nextInt(100));
                
            }
            
        

            for (int i = 0; i < tab.size(); i++) { System.out.print(tab.get(iCompteur2)+" ");
          iCompteur2++;}
          tab.reversed();
         for (int i = 0; i < tab.size(); i++) { System.out.print(tab.get(iCompteur1)+" ");
          iCompteur1++;}


         
    }





}
