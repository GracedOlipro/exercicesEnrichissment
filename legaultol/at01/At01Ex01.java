package legaultol.at01;
import java.util.*;

public class At01Ex01 {

public static void main(String[] args) {
    
    







    }

    public static void ex1(String[] args){


        int inombreUn;
     int inombreDeux; 
       
        Scanner ientréUN = new Scanner (System.in);
         System.out.println("bonjour,entrer le premier numéro:");
        inombreUn = ientréUN.nextInt();

         Scanner ientréDeux = new Scanner (System.in);
         System.out.println("bonjour,entrer le deuxième numéro:");
        inombreDeux = ientréDeux.nextInt();

        if (inombreUn>inombreDeux) {
            System.out.println("le premier numéro "+inombreUn+ " est plus grand");
        }
        else if (inombreDeux>inombreUn) {
            System.out.println("le deuxième numéro "+inombreDeux+ " est plus grand");
        }    
        else{
            System.out.println("les deux numéros s'ont égales");
        }

    }



    public static void ex2(String[] args){

        
        float fSalaire;
        float fHeuresTravaillés;

        System.out.println("entrez le salaire horraire:");
        Scanner fEntréUn =new Scanner(System.in);
        fSalaire=fEntréUn.nextFloat();


        System.out.println("entrez les heures travaillées:");
        Scanner fEntréDeux =new Scanner(System.in);
        fHeuresTravaillés=fEntréDeux.nextFloat();

        System.out.println("le salaire de la quinzaine de cet employé est:"+fSalaire*fHeuresTravaillés+"$");
    }



    public static void ex3(String[] args){
                 int age1,age2;
        System.out.println("entrez le premier age:");
        Scanner iEntrée1 = new Scanner (System.in);
        age1=iEntrée1.nextInt();

        System.out.println("entrez le deuxième age:");
        Scanner iEntrée2 = new Scanner (System.in);
        age2=iEntrée2.nextInt();
        
         System.out.println("la moyenne des deux ages est de "+(age1+age2)/2+" ans");
        
    }
    
    
    
    public static void ex4(String[] args){

         int iResultat;
        System.out.println("entrez la note de l'élève:");
        Scanner iEntrée1 = new Scanner (System.in);
        iResultat=iEntrée1.nextInt();
            if (iResultat>60) {
                System.out.println("l'élève a réussi!");
            }
            else{
                System.out.println("l'élève a échoué!");
            }
       
    }



    public static void ex5(String[] args){

             float prix;
     
     System.out.println("entrez le prix de l'item");
     Scanner entreUn= new Scanner(System.in);
     prix=entreUn.nextFloat();
     System.out.println("le nouveaux pris de l'item est: "+ (prix-(prix/4))+ "$");
    }



    public static void ex6(String[] args){

        String sNomClient;
    float prix,surface,logueur,largeur,bois;
    System.out.println("bonjour!, veuillez entrer votre nom:");
    Scanner EntreNom= new Scanner (System.in);
    sNomClient=EntreNom.next();

    System.out.println("longueur du plancher? (M)");
    Scanner EntreLongueur = new Scanner (System.in);
    logueur=EntreLongueur.nextFloat();

    System.out.println("largeur du plancher? (M)");
    Scanner EntreLargeur = new Scanner (System.in);
    largeur=EntreLargeur.nextFloat();
    
    System.out.println("entrez le type de bois désirer (1) chêne  (2) érable (3) Pin");
    Scanner EntreBois = new Scanner(System.in);
    bois=EntreBois.nextFloat();
    if (bois==1) {

        System.out.println(sNomClient+", pour une surface de "+logueur*largeur+" mètres carrés en chêne, le prix seras de "+(logueur*largeur)*5+"$");
        
    }
    else if (bois==2) {
        System.out.println(sNomClient+", pour une surface de "+logueur*largeur+" mètres carrés en érable, le prix seras de "+(logueur*largeur)*12+"$");
    }

    else if (bois==3) {
        System.out.println(sNomClient+", pour une surface de "+logueur*largeur+" mètres carrés en pin, le prix seras de "+(logueur*largeur)*10+"$");
    }
    else{
        System.out.println("Vous n’avez pas choisit le bon type de plancher");
    }

        
    }
}




