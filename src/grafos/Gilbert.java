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
public class Gilbert {
    
    private HashMap<Integer,Vertice>nodo;
    private HashMap<Integer,Arista>arista;
    int bandera=0;
    int NumNodos;
    int NumAristas;
    /**
     * 
     * @param NumNodos Numero de nodos
     * @param probabilidad Numero de probabilidad
     */       
    public void Gilbert(int NumNodos, float probabilidad){
        this.nodo = new HashMap<Integer,Vertice>();
        this.arista = new HashMap<Integer,Arista>();
        //this.bandera=0;
        //this.NumAristas=0;
        
        for(int i=0; i<NumNodos;i++){//Creacion de nodos
            nodo.put(i, new Vertice(i));
        }
        //Union de nodos dependiendo de la probabilidad
        for(int i=0;i<NumNodos;i++){
            for(int k=i;k<NumNodos;k++){
                if(k!=i || bandera==1){
                    if(Math.random()<=probabilidad){
                        arista.put(NumAristas, new Arista(nodo.get(i).get_id(),nodo.get(k).get_id()));
                        NumAristas++;
                    }
                }
            }
        }
        File f = new File("C:\\Users\\Pame Beltran\\Desktop\\grafoGilbert-500.gv");
        String struct = "graph Gilbert {\n";
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