package grafos;

import java.util.HashMap;

/**
 *
 * @author Pame Beltran
 */
public class BA {
    
    /*private HashMap<Integer,Vertice>nodo;
    private HashMap<Integer,Arista>arista;
    int bandera=0;    
    int NumAristas;
    double Coordenada;    
    /**
     * 
     * @param NumNodos Numero de nodos
     * @param Coordenada Es el grado a evaluar
     */       
    public static GrafoCreacion BA(int NumNodos, double Coordenada){
        HashMap<Integer,Vertice>nodo;
        HashMap<Integer,Arista>arista;
        Imprime I = new Imprime();
        int bandera=0;
        int NumAristas=0;
        //double Coordenada=0;
         nodo = new HashMap<Integer, Vertice>();
        arista = new HashMap<Integer,Arista>();
	      
        for (int i=0;i<NumNodos;i++){//Creacion de nodos
             nodo.put(i, new Vertice(i));
        }
        //Proceso de colocar vertices en rectangulo y colocar una arista entre cada par que queda a distancia menor del num random generado
        for(int i=0;i<NumNodos;i++){int k=0;
            while(k<=i && nodo.get(i).getcoor()<=Coordenada){
                if(k !=i || bandera ==1){
                    if(Math.random()<=1-nodo.get(k).getcoor()/Coordenada){
                        arista.put(NumAristas, new Arista(nodo.get(i).get_id(),nodo.get(k).get_id()));
                        Vertice nodo1=new Vertice();
                        nodo1.colocarrect(nodo.get(i));
                        nodo1.AumCoor(1);
                        nodo.put(i, new Vertice (nodo1));
                        
                        if(k!=i){
                            nodo1.colocarrect(nodo.get(k));
                            nodo1.AumCoor(1);
                            nodo.put(k, new Vertice (nodo1));
                        }
                        NumAristas++;
                    }
                }
                k++;
            }
        }
        GrafoCreacion g = new GrafoCreacion(nodo, arista);
       I.Imprime(nodo, arista);
       return g;
      }
    }