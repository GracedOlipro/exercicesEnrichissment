package legaultol.at03;

import java.util.Random;

public class Ex05 {
    public static void main(String[] args) {
        int iTableauRandom[]=new int[10],iCompteur1=0,iCompteur2=0;
        
        Random random= new Random();
        for (int i=0;i<10;i++) {
            iTableauRandom[i]=random.nextInt(100);
            
        }
        for (int i = 0; i < iTableauRandom.length; i++) { System.out.print(iTableauRandom[iCompteur1]+" ");
          iCompteur1++;}
          System.out.println();
        AfficheTableau(iTableauRandom);
          






    }

    public static void AfficheTableau(int[]iTableauRandom){
            int[] iTableau2=new int[10];
            int iCompteur2=0;
            

            iTableau2[9]=iTableauRandom[0];
            iTableau2[8]=iTableauRandom[1];
              iTableau2[7]=iTableauRandom[2];
                iTableau2[6]=iTableauRandom[3];
                  iTableau2[5]=iTableauRandom[4];
                    iTableau2[4]=iTableauRandom[5];
                      iTableau2[3]=iTableauRandom[6];
                        iTableau2[2]=iTableauRandom[7];
                          iTableau2[1]=iTableauRandom[8];
                            iTableau2[0]=iTableauRandom[9];
          for (int i = 0; i < iTableau2.length; i++) { System.out.print(iTableau2[iCompteur2]+" ");
          iCompteur2++;}



    }

}
