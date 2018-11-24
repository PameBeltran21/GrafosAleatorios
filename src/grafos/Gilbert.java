package grafos;

import java.util.HashMap;

/**
 *
 * @author Pame Beltran
 */
public class Gilbert {
    
   /* private HashMap<Integer,Vertice>nodo;
    private HashMap<Integer,Arista>arista;
    int bandera=0;
    int NumNodos;
    int NumAristas;
    /**
     * 
     * @param NumNodos Numero de nodos
     * @param probabilidad Numero de probabilidad
     */       
    public static GrafoCreacion Gilbert(int NumNodos, float probabilidad){
        HashMap<Integer,Vertice>nodo;
        HashMap<Integer,Arista>arista;
        Imprime I = new Imprime();
        int bandera=0;
        int NumAristas=0;
        nodo = new HashMap<Integer, Vertice>();
        arista = new HashMap<Integer,Arista>();
        
        for(int i=0; i<NumNodos;i++){//Creacion de nodos
            nodo.put(i, new Vertice(i));
        }
        //Union de nodos dependiendo de la probabilidad
        for(int i=0;i<NumNodos;i++){
            for(int k=i;k<NumNodos;k++){
                if(k!=i || bandera==1){
                    if(Math.random()<=probabilidad){
                        arista.put(NumAristas, new Arista(nodo.get(i).get_id(),nodo.get(k).get_id()));
                        nodo.get(i).conectar();
                        nodo.get(k).conectar();
                          if(i!=k){   nodo.get(i).AumCoor(1);    }
                       nodo.get(k).AumCoor(1);
                        NumAristas++;
                    }
                }
            }
        }
        GrafoCreacion g = new GrafoCreacion(nodo, arista);
        I.Imprime(nodo, arista);
        return g;}    
}