package grafos;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Pame Beltran
 */
public class DFS_I {
    public static GrafoCreacion DFS_I(GrafoCreacion g, int nodoInicial){
        Stack<Integer>stack = new Stack<>();
        HashMap<Integer,Vertice> Vertice = new HashMap();
        HashMap<Integer,Arista> Arista = new HashMap();
        GrafoCreacion DFSI = new GrafoCreacion(Vertice,Arista);
        Imprime I = new Imprime();
        int j;
        boolean Visited;
        
        boolean[][] MatriAdj=new boolean[g.getNodo().size()][g.getNodo().size()];
        for (int i = 0; i < g.getArista().size(); i++) {
            MatriAdj[g.getArista().get(i).getid1()][g.getArista().get(i).getid2()]=true;
            MatriAdj[g.getArista().get(i).getid2()][g.getArista().get(i).getid1()]=true;
        }                
        stack.push(g.getNodo().get(0).get_id());
        g.getNodo().get(0).setvisited(true);
        DFSI.getNodo().put(nodoInicial, new Vertice(g.getNodo().get(0)));
             
        while(stack.isEmpty()==false){
            j=stack.peek();
            Visited=false;
            for (int i = 0; i < g.getNodo().size(); i++) {
                if(MatriAdj[j][i]==true && g.getNodo().get(i).getvisited()==false){
                    g.getNodo().get(i).setvisited(true);
                    DFSI.getArista().put(nodoInicial, new Arista(j,i));
                    nodoInicial++;
                    DFSI.getNodo().put(nodoInicial, new Vertice(g.getNodo().get(i)));
                    stack.push(i);
                    Visited=true;
                    i=g.getNodo().size();
                }
                if (i==g.getNodo().size()-1 && Visited==false) {
                    stack.pop();
                }
            }
        }
        I.ImprimeBusquedaDFSI(Vertice,Arista);
        //I.ImprimeBusquedaDFSR(Vertice,Arista);
        return DFSI;
    }   
}