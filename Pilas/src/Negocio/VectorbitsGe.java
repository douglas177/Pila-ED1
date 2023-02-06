/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author DouglasPC
 */
public class VectorbitsGe {   int V[];
                             int dim;
                             int cantbit;

    public VectorbitsGe(int cant, int nbits) {
        int NE=(cant*nbits)/32; 
        if ((cant*nbits%32)!=0)
            NE++;
        V = new int [NE];
        this.dim = cant;
        this.cantbit=nbits;
    }
    
  public void Insertar(int ele, int pos){
      int ele1=ele;
      int nbit=calcularNbit(pos);
      int nEnt=calcularNent(pos);
      int mask= (int)Math.pow(2,cantbit)-1;
      mask=mask<<(nbit-1); 
      mask=~mask;
      V[nEnt]=V[nEnt]&mask;
      ele=ele<<(nbit-1);
      V[nEnt]=V[nEnt]|ele;
      if ((nbit-1)+7>32){
         int mask1= ((int)Math.pow(2,cantbit)-1);
         mask1=mask1>>>(32-(nbit-1));
         mask1=~mask1;
         V[nEnt+1]=V[nEnt+1]&mask1;
         ele1=ele1>>>(32-(nbit-1));
         V[nEnt+1]=V[nEnt+1]|ele1;
      }
      //System.out.println(Integer.toBinaryString(V[0]));
  }  
 public int Get(int pos){
      int nbit=calcularNbit(pos);
      int nEnt=calcularNent(pos);
      int mask= ((int)Math.pow(2,cantbit)-1);
      mask=mask<<(nbit-1); 
      mask=mask&V[nEnt];
      mask=mask>>>(nbit-1);     
      if ((nbit-1)+7>32){
         int mask1= ((int)Math.pow(2,cantbit)-1);
         mask1=mask1>>>(32-(nbit-1));
         mask1=mask1&V[nEnt+1];
         mask1=mask1<<(32-(nbit-1));
         mask=mask|mask1;
      }
 return mask;
 };
  private int calcularNbit(int pos){
   return((((pos-1)*cantbit)%32)+1);   
  };
  
  private int calcularNent(int pos){
  return(((pos-1)*cantbit/32));
  };
  
    @Override
    public String toString() {
    String S="V=[ ";
        for (int i = 1; i <= dim; i++) {
             S=S+Get(i);
             if(i!=dim) S=S+" , ";
        }
        S=S+ " ]";
        return(S);
    }
}
