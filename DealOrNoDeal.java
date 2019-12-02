/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marythe.deal_or_no_deal;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Maryt
 */
public class DealOrNoDeal {

    Modelos model=new Modelos();
//#######################################################################################################################################
    void Juego(){
         
        if(inicio()==true){
        maletines();
        }
    
    }
   
//#######################################################################################################################################    
 
    boolean inicio(){
    Scanner scan=new Scanner(System.in);
    System.out.println("----------------------------[D E A L] OR [N O - D E A L]----------------------------");
    System.out.println("                           *Presiona ENTER para comenzar*");    
    String in=scan.nextLine();
    if(in.isEmpty()){
    return true;
    }else{
        System.out.println("      ~Solo presione ENTER~");
    inicio();
    }
    return true;
    }

    void maletines(){
        Scanner scan=new Scanner(System.in);
            System.out.println("");System.out.println("");System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.println("                 Escoge un Maletín");
        System.out.println("------------------------------------------------");
        LlenarMaletines();
        TodoMaletines();
        int pick=scan.nextInt();
        System.out.println("       [Usted escogió el maletín "+pick+ "]");        
        Ronda(pick);
    }

            void LlenarMaletines(){
            model.Insertar_Final(0, 0);
            model.Insertar_Final(0, 1);
            model.Insertar_Final(0, 5);
            model.Insertar_Final(0, 10);
            model.Insertar_Final(0, 25);
            model.Insertar_Final(0, 50);
            model.Insertar_Final(0, 75);
            model.Insertar_Final(0, 100);
            model.Insertar_Final(0, 200);
            model.Insertar_Final(0, 300);
            model.Insertar_Final(0, 400);
            model.Insertar_Final(0, 500);
            model.Insertar_Final(0, 750);
            model.Insertar_Final(0, 1000);
            model.Insertar_Final(0, 5000);
            model.Insertar_Final(0, 10000);
            model.Insertar_Final(0, 25000);
            model.Insertar_Final(0, 50000);
            model.Insertar_Final(0, 75000);
            model.Insertar_Final(0, 100000);
            model.Insertar_Final(0, 200000);
            model.Insertar_Final(0, 300000);
            model.Insertar_Final(0, 400000);
            model.Insertar_Final(0, 500000);
            model.Insertar_Final(0, 750000);
            model.Insertar_Final(0, 1000000);
            
            for (int i = 0; i < 26; i++) {    
               int j=ValorRandom();
                model.asignar(j); 
            }
            }
            
            
            
            int ValorRandom(){
            int num;
            do{
                Random r = new Random();
                num = r.nextInt(26)+1; //me da un número random
            }while(model.isHere(num)==true);
            return num;
            }
            
            void TodoMaletines(){
                int n=1;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("["+n++ +"]");    
                    }
                    System.out.println("");
                }
                System.out.println("[26]");
            }
            
                     
            void MaletinesDisponibles(int no){
                int n=1;
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if(n==no){n++;}
                            if(model.abierto(n)==false){
                            System.out.print("["+n++ +"]");    }
                            else{
                            n++;
                                System.out.print("[X]");
                            }
                        }
                        System.out.println("");
                    }
            }
            
    void Ronda(int pick){
        Scanner scan=new Scanner(System.in);
        int male=6;
        int off=1;//
        for (int j = 0; j < 9; j++) {
          for (int i = male; i >=1; i--) {
            Abrir(i,pick); 
          } 
            valores();
            
            //int op=Oferta(male);
            int op=prom(off);//
            off++; //
            System.out.println("");
            System.out.println("~~~~~~~~~~~~~~~~~LA BANCA TE OFRECE POR TU MALETÍN~~~~~~~~~~~~~~~~~");
            System.out.println("                            $"+op+"                            ");
            System.out.println("________________________________________________________________");
            System.out.println("|             ¿D E A L    O R    N O    D E A L?               |");
            System.out.println("________________________________________________________________");
            System.out.println("            1.-[DEAL]                     2.-[NO DEAL]");
            int respuesta=scan.nextInt();
            if(respuesta==1){
            System.out.println("~~~~~~~~~~~~~~~~~LO QUE TE LLEVAS~~~~~~~~~~~~~~~~~");
            System.out.println("                            $"+op+"                            ");                
            System.out.println("~~~~~~~~~~~~~~~~~L O    Q U E    T U     M A L E T Í N     T E N Í A~~~~~~~~~~~~~~~~~");
            System.out.println("________________________________________________________________");
            System.out.print("|                              ");
            model.revelar(pick);        
            return;
            }
        if(male>1){
            male--;
          }    
        }
        
            System.out.println("~~~~~~~~~~~~~~~~~L O    Q U E    T U     M A L E T Í N     T I E N E~~~~~~~~~~~~~~~~~");
            System.out.println("________________________________________________________________");
            System.out.print("|                              ");
            model.revelar(pick);        
            System.out.println("_________________________________________________________________");
    }
            
    
    void Abrir(int m,int no){
    Scanner scan=new Scanner(System.in);    
    int escoge;
    do{
    System.out.println("");System.out.println("");System.out.println("");
    System.out.println("------------------------------------------------");
    System.out.println("                Escoga 1 maletín");
    System.out.println("------------------------------------------------");
    System.out.println("Maletines restantes a escoger: ["+m+"]");
    MaletinesDisponibles(no);
    System.out.println("Usted escoge: ");
    escoge=scan.nextInt();
    }while(model.abierto(escoge)==true);
    if(model.abierto(escoge)==false){
    model.abrir(escoge);
    }
    
    }

    void valores(){
        System.out.println("------------------------------------------------");
        System.out.println("                  B A N C A" );
        System.out.println("------------------------------------------------");
        model.RecorrerValores();
    }
    
    
    int Oferta(int vuelta){
    int suma=model.sumas();
    int of=0;
    Random r = new Random();
    switch(vuelta){
        case 6:
            of = r.nextInt(10000)+45000;
            break;
        case 5:
            if(suma<1709208){
            of = r.nextInt(15000)+45000; 
            }else{
            of = r.nextInt(15000)+50000; 
            }
            break;
        case 4:
            if(suma<1709208){
            of = r.nextInt(20000)+60000; 
            }else{
            of = r.nextInt(40000)+100000; 
            }
            break;
        case 3:
            if(suma<1709208){
            of = r.nextInt(20000)+80000; 
            }else{
            of = r.nextInt(40000)+100000; 
            }
            break;
        case 2:
            if(suma<1000000){
            of = r.nextInt(40000)+80000; 
            }else{
            of = r.nextInt(400000)+100000; 
            }
            break;
        case 1:
            if ((suma<1000)&&(suma>0)){
            of=50;
            }
            if ((suma>1000)&&(suma<5000)){
            of=1000;
            }
            if((suma<10000)&&(suma>5000)){
            of = r.nextInt(1000)+1000;
            }
            if((suma>10000)&&(suma<20000)){
            of = r.nextInt(1000)+4000;
            }
            if((suma<30000)&&(suma>20000)){
            of = r.nextInt(1000)+4500;
            }
            if((suma>30000)&&(suma<40000)){
            of = r.nextInt(1000)+15000;
            }
            if((suma<50000)&&(suma>40000)){
            of = r.nextInt(1000)+20000;
            }
            if((suma>50000)&&(suma<60000)){
            of = r.nextInt(1000)+25000;
            }
            if((suma>60000)&&(suma<70000)){
            of = r.nextInt(1000)+30000;
            }
            if((suma>70000)&&(suma<80000)){
            of = r.nextInt(1000)+40000;
            }
            if((suma>80000)&&(suma<90000)){
            of = r.nextInt(1000)+45000;
            }
            if((suma>90000)&&(suma<100000)){
            of = r.nextInt(1000)+80000;
            }
            if((suma>100000)&&(suma<200000)){
            of = r.nextInt(1000)+90000;
            }
            if((suma>200000)&&(suma<300000)){
            of = r.nextInt(1000)+100000;
            }
            if((suma>300000)&&(suma<400000)){
            of = r.nextInt(1000)+130000;
            }
            if((suma>400000)&&(suma<500000)){
            of = r.nextInt(1000)+300000;
            }
            if((suma>500000)&&(suma<600000)){
            of = r.nextInt(1000)+400000;
            }
            if((suma>600000)&&(suma<700000)){
            of = r.nextInt(1000)+450000;
            }
            if((suma>700000)&&(suma<800000)){
            of = r.nextInt(1000)+500000;
            }
            if((suma>800000)&&(suma<900000)){
            of = r.nextInt(1000)+600000;
            }
            if((suma>900000)&&(suma<1000000)){
            of = r.nextInt(1000)+700000; 
            }
            
            if((model.MaletinMayor()-model.MaletinMenor())>200000){
            
            }
            if((model.MaletinMayor()-model.MaletinMenor())>200000){
            
            }
            if((model.MaletinMayor()-model.MaletinMenor())>200000){
            
            }
            break;  
            
    }
    return of;    
    }
    
    
    int prom(int off){ //
    int suma=model.sumas();
    int numM=model.numM();
    
    return suma/numM *off/10;
    }
    
    boolean SeguirJugando(){
     Scanner scan=new Scanner(System.in);
        char dec;
        do{
        System.out.println("");System.out.println("");System.out.println("");    
        System.out.println("____________________________________________________");
        System.out.println("|             ¿Quiere seguir Jugando?               |");
        System.out.println("____________________________________________________");
        System.out.println("          [X.-Sí]               [O.-No]");
        String decision=scan.nextLine();
        if(decision.isEmpty()){
            dec=0;
        }else{
        dec = decision.charAt(0); }
        }while((dec!=88)&&(dec!=120)&&(dec!=79)&&(dec!=111));
            if((dec==88)||(dec==120)){
                return true;
            }
        return false;
    }
    
    


}
