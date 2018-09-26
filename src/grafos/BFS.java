package grafos;

import java.util.HashMap;

/**
 *
 * @author Pame Beltran
 */
public class BFS {
    public static GrafoCreacion BFS(GrafoCreacion g, Vertice nodoInicial){
            
        Imprime I = new Imprime();
        HashMap<Integer,HashMap> CapaPrincipal = new HashMap();
        HashMap<Integer,Vertice> SubCapa1 = new HashMap();
        HashMap<Integer,Vertice> SubCapa2 = new HashMap();
        
        HashMap<Integer,Vertice> Vertice = new HashMap();
        HashMap<Integer,Arista> Arista = new HashMap();
        
        SubCapa1.put(0, g.getNodo().get(0));
        g.getNodo().get(0).setvisited(true);
        int numL = 0,aux = 0;
        CapaPrincipal.put(numL,(HashMap)SubCapa1.clone());
        Vertice.put(0, g.getNodo().get(0));
        
        for(int x = 0;x<=nodoInicial.get_id();x++){
            SubCapa2.clear();
            int num = -1;
            for(int i = 0;i<SubCapa1.size();i++){
                for(int j = 0;j<g.getArista().size();j++){
                    if(SubCapa1.get(i).get_id()==g.getArista().get(j).getid1() && g.getNodo().get(g.getArista().get(j).getid2()).getvisited()==false){
                        g.getNodo().get(g.getArista().get(j).getid2()).setvisited(true);
                        num++;
                        SubCapa2.put(num, g.getNodo().get(g.getArista().get(j).getid2()));
                        aux++;
                        Arista.put(aux, g.getArista().get(j));
                        Vertice.put(aux+1, g.getNodo().get(g.getArista().get(j).getid2()));
                    }
                    if(SubCapa1.get(i).get_id()== g.getArista().get(j).getid2() && g.getNodo().get(g.getArista().get(j).getid1()).getvisited()==false){
                       g.getNodo().get(g.getArista().get(j).getid1()).setvisited(true);
                       num++;
                       SubCapa2.put(num, g.getNodo().get(g.getArista().get(j).getid1()));
                       aux++;
                       Arista.put(aux,g.getArista().get(j));
                       Vertice.put(aux+1, g.getNodo().get(g.getArista().get(j).getid1()));
                    }
                }
            }
            numL++;
            SubCapa1=(HashMap)SubCapa2.clone();
            CapaPrincipal.put(numL,(HashMap)SubCapa2.clone());
        }
        for (int i=0; i<g.getNodo().size();i++){
            g.getNodo().get(i).setvisited(false);
        }
        GrafoCreacion BFS = new GrafoCreacion(Vertice,Arista);
        I.ImprimeBusquedaBFS(Vertice, Arista);
        return g;}
 }