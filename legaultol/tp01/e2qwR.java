package legaultol.tp01;

public class e2qwR {

public static void main(String[] args) {
   String[] tab_ville={"Le Claire","New York","Paris","Calcutta","Barcelone","Manille","Montreal","Hong Kong"};
double[] tab_superficie={210,1214,105.4,185,100.4,38.55,363.52,1104};
int[] tab_pupulation={8452409,8391881,211297,4580544,1621537,1660714,1667700,7018636};
double[] tab_densite=new double[8];
CalcDens(tab_superficie, tab_pupulation, tab_densite);
AfficheTableau(tab_superficie, tab_pupulation, tab_densite, tab_ville);
 
}

public static double[] CalcDens(double[]tab_superficie,int[]tab_pupulation,double[]tab_densite){
for (int i=0;i<8;i++) {
tab_densite[i]=tab_pupulation[i]/tab_superficie[i];
   
}
return tab_densite;

}

public static void AfficheTableau(double[]tab_superficie,int[]tab_pupulation,double[]tab_densite,String[]tab_ville) {
    System.out.println("ville   Superficie  Population  Densite");
    System.out.println("========================================");
    for (int i=0;i<8;i++) {
        System.out.println(tab_ville[i]+"   "+tab_superficie[i]+"   "+tab_pupulation[i]+"   "+tab_densite[i]);

    }
}


}
