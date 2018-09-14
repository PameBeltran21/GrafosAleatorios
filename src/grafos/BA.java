package grafos;

import com.sun.javafx.binding.Logging;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Pame Beltran
 */
public class BA {
    
    private HashMap<Integer,Vertice>nodo;
    private HashMap<Integer,Arista>arista;
    int bandera=0;    
    int NumAristas;
    double Coordenada;
    
    /**
     * 
     * @param NumNodos Numero de nodos
     * @param Coordenada Es el grado a evaluar
     */       
    public void BA(int NumNodos, double Coordenada){
        this.nodo = new HashMap<Integer,Vertice>();
        this.arista = new HashMap<Integer,Arista>();
               
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
        File f = new File("C:\\Users\\Pame Beltran\\Desktop\\grafoBA-500.gv");
        String struct = "graph BA {\n";
        Iterator<HashMap.Entry<Integer, Vertice>> it2 = nodo.entrySet().iterator(); 
        while (it2.hasNext()) {
            struct += it2.next().getValue().id+ ";\n";
        }
        Iterator<HashMap.Entry<Integer, Arista>> it = arista.entrySet().iterator();
        Iterator<HashMap.Entry<Integer, Arista>> it3 = arista.entrySet().iterator();
        while (it.hasNext()) {
            struct += it.next().getValue().getid1()+"--"+it3.next().getValue().getid2()+";\n";
        }
        PrintWriter pw;
        try {
            pw = new PrintWriter(f);
            pw.write(struct);
            pw.close();
        } catch (FileNotFoundException e) {
            Logging.getLogger();
        }
      }
    }