package legaultol.at03;
import java.util.*;
import java.math.*;

public class Ex08 {
    public static void main(String[] args) {
        Object[][]TableauNotes={
            {"Etudiants","Tp1","Tp2","Exam1"},
            {"Pierre",65,45,34},
            {"André",78,55,65},
            {"Julie",43,67,21},
            {"Brigitte",82,89.67},
            {"Anne",76,100,75},
            {"Olivier",91,95,54},
            {"Simon",71,92,69},
            {"Nadine",96,81,54}};


            System.out.println(moyEval(TableauNotes,1));
            
            System.out.println(MoyEtu(TableauNotes, 2));
    }

   
   
   
   public static float MoyEtu(Object[][] TableauNotes,int eleve){
 float fSomme=0,fMoyenne=0;

         for (int j=1; j<=3 ; j++) {
            fSomme+=(int)TableauNotes[eleve][j];}
       
         fMoyenne=fSomme/3;
        
        

        return fMoyenne;






   }
    public static float moyEval(Object[][] TableauNotes,int eval){




        
        float fSomme=0,fMoyenne=0;

         for (int j=eval; j<=8 ; j++) {
            fSomme+=(int)TableauNotes[j][1];}
       
         fMoyenne=fSomme/8;
        
        

        return fMoyenne;

        
    }





}
