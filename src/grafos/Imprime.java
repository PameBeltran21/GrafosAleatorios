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
public class Imprime {
    private HashMap<Integer,Vertice>nodo;
    private HashMap<Integer,Arista>arista;    
    public void Imprime(HashMap<Integer,Vertice>nodo,HashMap<Integer,Arista>arista){
        File f = new File("C:\\Users\\Pame Beltran\\Desktop\\Erdos-500.gv");
        String struct = "graph G {\n";
        
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
        public void ImprimeBusquedaBFS(HashMap<Integer,Vertice>nodo,HashMap<Integer,Arista>arista){
        File f = new File("C:\\Users\\Pame Beltran\\Desktop\\ErdosBFS-500.gv");
        String struct = "graph G {\n";
        
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
        public void ImprimeBusquedaDFSI(HashMap<Integer,Vertice>nodo,HashMap<Integer,Arista>arista){
        File f = new File("C:\\Users\\Pame Beltran\\Desktop\\ErdosDFSI-500.gv");
        String struct = "graph G {\n";
        
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
        public void ImprimeBusquedaDFSR(HashMap<Integer,Vertice>nodo,HashMap<Integer,Arista>arista){
        File f = new File("C:\\Users\\Pame Beltran\\Desktop\\ErdosDFSR-500.gv");
        String struct = "graph G {\n";
        
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