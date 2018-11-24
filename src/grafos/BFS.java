package grafos;

import java.util.HashMap;

/**
 *
 * @author Pame Beltran
 */
public class BFS {
    public static GrafoCreacion BFS(GrafoCreacion G1, Vertice nodoInicial){
        
        GrafoCreacion G = new GrafoCreacion(G1.getNodos(),G1.getAristas());
        Imprime I = new Imprime();
        HashMap<Integer,HashMap> CapaPrincipal = new HashMap();
        HashMap<Integer,Vertice> SubCapa1 = new HashMap();
        HashMap<Integer,Vertice> SubCapa2 = new HashMap();
        HashMap<Integer,Vertice> Vertice = new HashMap();
        HashMap<Integer,Arista> Arista = new HashMap();
        int numL = 0,aux = 0,cv=0;
       /* G.getNodo().get(0).setvisited(true);
        SubCapa1.put(0, G.getNodo().get(0));*/
        
        G.getNodos().get(nodoInicial.get_id()).setF(true);
        SubCapa1.put(0,G.getNodos().get(nodoInicial.get_id()));
        CapaPrincipal.put(numL,(HashMap)SubCapa1.clone());
        Vertice.put(cv, G.getNodos().get(nodoInicial.get_id()));
        
        
        /*CapaPrincipal.put(numL,(HashMap)SubCapa1.clone());
        Vertice.put(0, G1.getNodo().get(0));*/
        
        for(int x = 0;x<=nodoInicial.get_id();x++){
            SubCapa2.clear();
            int num = -1;
            for(int i = 0;i<SubCapa1.size();i++){
                for(int j = 0;j<G.getArista().size();j++){
                    if(SubCapa1.get(i).get_id()==G.getAristas().get(j).getid1() && G.getNodos().get(G.getAristas().get(j).getid2()).getF()==false){
                        G.getNodos().get(G.getAristas().get(j).getid2()).setF(true);
                        num++;
                        SubCapa2.put(num, G.getNodos().get(G.getAristas().get(j).getid2()));
                        Arista.put(cv, G.getAristas().get(j));
                        cv++;
                        Vertice.put(aux+1, G.getNodos().get(G.getAristas().get(j).getid2()));
                    }
                    if(SubCapa1.get(i).get_id()== G.getAristas().get(j).getid2() && G.getNodos().get(G.getAristas().get(j).getid1()).getF()==false){
                       G.getNodos().get(G.getAristas().get(j).getid1()).setF(true);
                       num++;
                       SubCapa2.put(num, G.getNodos().get(G.getAristas().get(j).getid1()));                      
                       Arista.put(cv,G.getAristas().get(j));
                       cv++;
                       Vertice.put(cv, G.getNodos().get(G.getAristas().get(j).getid1()));
                    }
                }
            }
            numL++;
            SubCapa1=(HashMap)SubCapa2.clone();
            CapaPrincipal.put(numL,(HashMap)SubCapa2.clone());
        }
        for (int i=0; i<G1.getNodo().size();i++){
            G1.getNodo().get(i).setvisited(false);
        }
        GrafoCreacion BFS = new GrafoCreacion(Vertice,Arista);
        BFS.setG(Vertice, Arista);
        I.ImprimeBusquedaBFS(Vertice, Arista);
        return BFS;}
 }