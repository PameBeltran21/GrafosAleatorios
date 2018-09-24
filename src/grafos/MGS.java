package grafos;

import java.util.HashMap;
/**
 *
 * @author Pame Beltran
 */
public class MGS {
    /*private HashMap<Integer,Vertice>nodo;
    private HashMap<Integer,Arista>arista;
    int bandera;
    double dimension;
    int NumAristas;
      /**
       * 
       * @param NumNodos Numero de nodos
       * @param conectividad Probabilidad
       */
   public static GrafoCreacion MGS (int NumNodos, float conectividad){
        HashMap<Integer,Vertice>nodo;
        HashMap<Integer,Arista>arista;
        int bandera = 1;
        double dimension=Math.sqrt(2);
        int NumAristas=0;
        Imprime I = new Imprime();
        nodo = new HashMap<Integer, Vertice>();
        arista = new HashMap<Integer,Arista>();
	        
	for(int i=0; i<NumNodos; i++){//inicaliza los id de cada nodo
		nodo.put(i, new Vertice(i,Math.random(),Math.random()));
	}
		//recorre solo la diagonal de arriba a la derecha
		for(int i=0; i<NumNodos; i++){
                    for(int k=i; k<NumNodos; k++){
                        if(k!=i || bandera==1){
                            dimension=Math.sqrt((Math.pow(nodo.get(k).getx()-nodo.get(i).getx(), 2)+Math.pow(nodo.get(k).gety()-nodo.get(i).gety(), 2)));
                            if(dimension<=conectividad){
                                arista.put(NumAristas, new Arista(nodo.get(i).get_id(),nodo.get(k).get_id()));
                                NumAristas++;
                            }
                        }
                    }
                } 
                GrafoCreacion g = new GrafoCreacion (nodo, arista);
                I.Imprime(nodo, arista);
                return g;
    }
}