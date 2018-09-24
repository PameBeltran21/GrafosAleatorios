package grafos;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Pame Beltran
 */
public class DFS_R {
    public static GrafoCreacion DFS_R(GrafoCreacion g, int nodoInicial){
        Stack<Integer>pila = new Stack<>();
        HashMap<Integer,Vertice> Vertice = new HashMap();
        HashMap<Integer,Arista> Arista = new HashMap();
        GrafoCreacion DFSR = new GrafoCreacion(Vertice,Arista);
        Imprime I = new Imprime();
        int j;
        boolean Visited;
        
        boolean[][] AdjMatrix=new boolean[g.getNodo().size()][g.getNodo().size()];
        for (int i = 0; i < g.getArista().size(); i++) {
            AdjMatrix[g.getArista().get(i).getid1()][g.getArista().get(i).getid2()]=true;
            AdjMatrix[g.getArista().get(i).getid2()][g.getArista().get(i).getid1()]=true;
        }                
        pila.push(g.getNodo().get(0).get_id());
        g.getNodo().get(0).setvisited(true);
        DFSR.getNodo().put(nodoInicial, new Vertice(g.getNodo().get(0)));
             
        while(pila.isEmpty()==false){
            j=pila.peek();
            Visited=false;
            for (int i = 0; i < g.getNodo().size(); i++) {
                if(AdjMatrix[j][i]==true && g.getNodo().get(i).getvisited()==false){
                    g.getNodo().get(i).setvisited(true);
                    DFSR.getArista().put(nodoInicial, new Arista(j,i));
                    nodoInicial++;
                    DFSR.getNodo().put(nodoInicial, new Vertice(g.getNodo().get(i)));
                    pila.push(i);
                    Visited=true;
                    i=g.getNodo().size();
                }
                if (i==g.getNodo().size()-1 && Visited==false) {
                    pila.pop();
                }
            }
        }
        I.ImprimeBusquedaDFSR(Vertice,Arista);
        return DFSR;
    }   
}