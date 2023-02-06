/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Estudiante
 */
public class PilaV {
    int P[];
    int Cima;

    public PilaV(int cant) {
        P = new int[cant];
        Cima = -1;
    }
    public void Push(int elemento){
        if(Llena()){
            System.out.println("Error:PilaLlena"); 
        }
        else{
            Cima++;
            P[Cima] = elemento;
        }
    }
    public boolean Llena(){
        return P.length -1 == Cima;
    }
    public boolean Vacia(){
        return Cima==-1;
    }
    public int Pop(){
        Cima--;
        return P[Cima+1];
    }
    public int Get(){
        return P[Cima];
    }

    @Override
    public String toString() {
        String S = "";
        for (int i = Cima; i >= 0; i--) {
            S  = S + P[i] + "\n";
        }
        S= S + "P";
        return S;
    }

    
}
