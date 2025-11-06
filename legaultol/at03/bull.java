package legaultol.at03;

public class bull {




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
}
