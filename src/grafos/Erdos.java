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
public class Erdos {
    
private HashMap<Integer,Vertice>nodo;
private HashMap<Integer,Arista>arista;
int NumAristas;
int NuevasAristas;
/**
 * 
 * @param NumNodos Numero de nodos 
 * @param NumAristas Numero de aristas
 */
    public void Erdos(int NumNodos, int NumAristas){
	this.nodo = new HashMap<Integer, Vertice>();
        this.arista = new HashMap<Integer,Arista>();
	
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
        File f = new File("C:\\Users\\Pame Beltran\\Desktop\\grafoErdos-500.gv");
        String struct = "graph Erdos {\n";
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