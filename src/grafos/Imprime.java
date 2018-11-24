package grafos;

import com.sun.javafx.binding.Logging;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
        //File f = new File("C:\\Users\\Pame Beltran\\Desktop\\Erdos-500.gv");
        File f = new File("C:\\Users\\Pame Beltran\\Documents\\NetBeansProjects\\Grafos\\BA-500.gv");
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
        public void ImprimeDijstra(String nombre, GrafoCreacion g){
            FileWriter fichero = null;
        PrintWriter pw = null;
                    System.out.println(g.getNodos().size());
        try{
            //File f = new File("C:\\Users\\Pame Beltran\\Desktop\\grafoErdos.gv");
            fichero = new FileWriter(nombre+".gv");
            //String struct = "graph G {\n";
            pw = new PrintWriter(fichero);
            pw.println("graph G{");
            for(int i=0;i<g.getNodos().size();i++){
                pw.println(g.getNodos().get(i).get_id()+ "  " +"[Label = \""+g.getNodos().get(i).get_id()+" ("+String.format("%.2f", g.getNodos().get(i).getw())+")\"]"+";");
            }
            pw.println();
            for(int i=0;i<g.getAristas().size();i++){
               pw.println(g.getAristas().get(i).getid1()+"--"+g.getAristas().get(i).getid2()+ "  " + "[\"" + String.format("%.2f",g.getAristas().get(i).getp())+"\"]"+";");
              //pw.println(g.getAristas().get(i).getid1()+"-"+"[Label = \"" + String.format("%.0f",g.getAristas().get(i).getp())+"\"]"+"-"+g.getAristas().get(i).getid2()+";\n");
            }
            pw.println("}");          
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        }
}