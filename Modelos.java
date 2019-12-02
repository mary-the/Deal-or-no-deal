/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marythe.deal_or_no_deal;

/**
 *
 * @author Maryt
 */
public class Modelos {
Maletin inicio=null;
Maletin fin=null;

void Insertar_Final(int n,int val){
Maletin nuevo=new Maletin();
nuevo.num=n;
nuevo.valor=val;
nuevo.sig=null;
nuevo.ant=null;
if(inicio==null){
inicio=nuevo;
fin=nuevo;
}else{
fin.sig=nuevo;
nuevo.ant=fin;
fin=nuevo;
}
}

boolean isHere(int n){
Maletin aux=inicio;
    while((aux.num!=n)&&(aux.sig!=null)){
        aux=aux.sig;
    }
    return aux.num==n;
}

void Recorrer(){
Maletin aux=inicio;
while(aux!=null){
    System.out.println("-----------------");
    System.out.println("num"+aux.num);
    System.out.println("val"+aux.valor);
    System.out.println("-----------------");
    aux=aux.sig;
}
}

void asignar(int n){
Maletin aux=inicio;
while((aux.asig==true)&&(aux.sig!=null)){
aux=aux.sig;
}
if(aux.asig==false){
aux.num=n;
aux.asig=true;
}
}

boolean abierto(int n){
Maletin aux=inicio;
while((aux.num!=n)&&(aux.sig!=null)){
aux=aux.sig;
}
if(aux.num==n){
if(aux.abierto==true){
return true;
}
}
return false;
}

void abrir(int n){
Maletin aux=inicio;
    while((aux.num!=n)&&(aux.sig!=null)){
        aux=aux.sig;
    }
    if(aux.num==n){
        if(aux.abierto==false){
            aux.abierto=true;
            
            System.out.println("  Usted abrió el maletín [$"+aux.valor+"]");
        }
    }
}

void RecorrerValores(){
Maletin aux=inicio;
    for (int j = 0; j < 5; j++) {
        for (int i = 0; i < 5; i++) {
            if(aux.abierto==true){
             System.out.print("[$"+aux.valor+"]");
            }else{
             System.out.print("[######]");
            }
         aux=aux.sig;
        }  
        System.out.println("");    
    }
    if(fin.abierto==true){
        System.out.print("[$"+aux.valor+"]");
    }else{
        System.out.print("[######]");
    }
}

int sumas(){
Maletin aux=inicio;
int suma=0;
while(aux!=null){
    if(aux.abierto==false){
        suma=suma+aux.valor;
    } 
    aux=aux.sig;
}
return suma;
}

int numM(){
Maletin aux=inicio;
int num=0;
while(aux!=null){
    if(aux.abierto==false){
        num++;
    } 
    aux=aux.sig;
}
return num;
}

void revelar(int n){
Maletin aux=inicio;
    while((aux.num!=n)&&(aux.sig!=null)){
        aux=aux.sig;
    }
if(aux.num==n){    
    System.out.println("$"+aux.valor);
}

}

int MaletinMayor(){
Maletin aux=inicio;
int r=0;
    while(aux!=null){
       if(r<aux.valor){
       r=aux.valor;
       }
    }
return r;
}


int MaletinMenor(){
Maletin aux=inicio;
int r=0;
    while(aux!=null){
       if(r>aux.valor){
       r=aux.valor;
       }
    }
return r;
}





}

