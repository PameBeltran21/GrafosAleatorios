package grafos;
import java.util.HashMap;

/**
 *
 * @author Pame Beltran
 */
public class DFS_R {
    public static GrafoCreacion DFS_R(GrafoCreacion g, Vertice nodoInicial){        
        HashMap<Integer,Vertice> Vertice = new HashMap();
        HashMap<Integer,Arista> Arista = new HashMap();
        GrafoCreacion DFSR = new GrafoCreacion(Vertice,Arista);
        GrafoCreacion Regresa;
        Imprime I = new Imprime();
             
        boolean[][] AdjMatrix=new boolean[g.getNodo().size()][g.getNodo().size()];
        for (int i = 0; i < g.getArista().size(); i++) {
            AdjMatrix[g.getArista().get(i).getid1()][g.getArista().get(i).getid2()]=true;
            AdjMatrix[g.getArista().get(i).getid2()][g.getArista().get(i).getid1()]=true;
        }                
        g.getNodo().get(nodoInicial.get_id()).setvisited(true);
        DFSR.getNodo().put(0, new Vertice (g.getNodo().get(nodoInicial.get_id())));   
        for (int i = 0; i < g.getNodo().size(); i++) {

            if(AdjMatrix[nodoInicial.get_id()][i]==true && g.getNodo().get(i).getvisited()==false){
                Regresa=DFS_R(g,g.getNodo().get(i));
                int aux = DFSR.getNodo().size();
                for (int j = 0; j < Regresa.getNodo().size(); j++) {
                        DFSR.getNodo().put(aux+j, Regresa.getNodo().get(j));
                }
                DFSR.getArista().put(DFSR.getArista().size(), new Arista(nodoInicial.get_id(),i));
                aux=DFSR.getArista().size();
                if (Regresa.getArista().isEmpty()!=true) {
                    for (int j = 0; j < Regresa.getArista().size(); j++) {
                        DFSR.getArista().put(aux+j, Regresa.getArista().get(j));
                    }
                }
            }
        }
        I.ImprimeBusquedaDFSR(Vertice,Arista);
        return DFSR;
    }   
}