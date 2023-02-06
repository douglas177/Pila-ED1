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
public class PilaBits {
    /*
    http = lenguaje de hipertexto 
    ftp = descarga de archivos
    telnet =  Control Remoto de computadora
    smtp = Envios de correos electronicos
    irc = Mensajes de Whatsapp
    udp = Datos de juegos
    */
    /*
    Metodos de la clase pila
    constructor
    push(apilar elemento)
    pop() desapilar
    get()Consulta
    Vacia()
    Llena()(solo vector y bits)*/
    VectorbitsGe P;
    int Cima;
    int nbits;

    public PilaBits(int cant, int nbit) {
        P = new VectorbitsGe(cant, nbit);
        Cima = 0;
        this.nbits = nbit;
    }
    public void Push(int elemento){
        if(Llena()){
            System.out.println("Error:PilaLlena"); 
            //System.exit(1);
        }
        else{
            Cima++;
            P.Insertar(elemento, Cima);
        }
    }
    public boolean Llena(){
        return Cima == P.dim;
    }
    public boolean Vacia(){
        return Cima==0;
    }
    public int Get(){
        return P.Get(Cima); 
    }
    public int Nbit(){
        return nbits; 
    }
    public int Pop(){
        Cima--;
        return P.Get(Cima+1);
    }

    @Override
    public String toString() {
        String S = "";
        for (int i = Cima; i > 0; i--) {
            S = S + P.Get(i) + " \n";
        }
        S = S + "P"; 
        return S;
    }
    
}
