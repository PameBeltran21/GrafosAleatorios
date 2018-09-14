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
public class MGS {
    private HashMap<Integer,Vertice>nodo;
    private HashMap<Integer,Arista>arista;
    int bandera;
    double dimension;
    int NumAristas;
      /**
       * 
       * @param NumNodos Numero de nodos
       * @param conectividad Probabilidad
       */
   public void MGS (int NumNodos, float conectividad){
        this.nodo=new HashMap<Integer,Vertice>();
        this.arista = new HashMap<Integer,Arista>();
        this.bandera = 1;
        this.dimension=Math.sqrt(2);
        
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
	File f = new File("C:\\Users\\Pame Beltran\\Desktop\\grafoMGS-500.gv");
        String struct = "graph MGS {\n";
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