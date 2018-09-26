package grafos;

import java.util.HashMap;
/**
 *
 * @author Pame Beltran
 */
public class Erdos {
    
/*private HashMap<Integer,Vertice>nodo;
private HashMap<Integer,Arista>arista;
int NumAristas;
int NuevasAristas;
/**
 * 
 * @param NumNodos Numero de nodos 
 * @param NumAristas Numero de aristas
 */
    public static GrafoCreacion Erdos(int NumNodos, int NumAristas){
         HashMap<Integer,Vertice>nodo;
         HashMap<Integer,Arista>arista;
        Imprime I = new Imprime();
        
        int NuevasAristas;
	nodo = new HashMap<Integer, Vertice>();
        arista = new HashMap<Integer,Arista>();
	
        for(int i=0; i< NumNodos; i++){//Creacion de nodos
            nodo.put(i, new Vertice(i));
        }
        //Generacion aristas Random 
        int L=0, bandera=1;
        int aris1=(int)(Math.random()*NumNodos),aris2=(int)(Math.random()*NumNodos);
        //Asigna al id
        arista.put(0,new Arista(nodo.get(aris1).get_id(),nodo.get(aris2).get_id()));
        //Para aceptacion de autoaristas
        while(aris1==aris2 && bandera==0){
            aris1=(int)(Math.random()*NumNodos);
            aris2=(int)(Math.random()*NumNodos);
            arista.put(0,new Arista(nodo.get(aris1).get_id(),nodo.get(aris2).get_id()));
        } 
        NuevasAristas = 1;//Aristas creadas
        
        while(L<NumAristas){
            aris1=(int)(Math.random()*NumNodos);
            aris2=(int)(Math.random()*NumNodos);
           
            if(aris1 != aris2 || bandera==1){
                int bandera2 = 1;
                int P=0;
                
                while (bandera2==1 && P<NuevasAristas){
                    int a=arista.get(P).getid1(),b=arista.get(P).getid2();
                    
                    if((aris1 == a && aris2 ==b)||(aris1 == b && aris2 == a))   bandera2=0;
                        P++;
                 }
                if (bandera2==1){
                    arista.put(NuevasAristas, new Arista(nodo.get(aris1).get_id(),nodo.get(aris2).get_id()));
                    NuevasAristas++;
                    L++;
                }
            }
        }
        GrafoCreacion g = new GrafoCreacion(nodo, arista);
        I.Imprime(nodo,arista);
        return g;}
}