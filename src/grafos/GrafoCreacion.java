package grafos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
/**
 *
 * @author Pame Beltran
 */
public class GrafoCreacion {

    private HashMap<Integer,Vertice>nodo;
    private HashMap<Integer,Arista>arista;
    private HashMap<Integer,Stack>Pila;
    int NumAristas;
    int NumNodos;
    Imprime I = new Imprime();
    public HashMap<Integer, Stack> getPila() {
        return Pila;
    }

    public void setPila(HashMap<Integer, Stack> Pila) {
        this.Pila = Pila;
    }

    public HashMap<Integer, Vertice> getNodo() {
        return nodo;
    }
    public void setNodo(HashMap<Integer, Vertice> nodo) {
        this.nodo = nodo;
    }
   
    public HashMap<Integer, Arista> getArista() {
        return arista;
    }

    public void setArista(HashMap<Integer, Arista> arista) {
        this.arista = arista;
    }

    public int getNumAristas() {
        return NumAristas;
    }

    public void setNumAristas(int NumAristas) {
        this.NumAristas = NumAristas;
    }

    public int getNumNodos() {
        return NumNodos;
    }

    public void setNumNodos(int NumNodos) {
        this.NumNodos = NumNodos;
    }

     public void setNodos (HashMap<Integer,Vertice> a){
        this.nodo=a;
    }
    public void setAristas (HashMap<Integer,Arista> a){
        this.arista=a;
    }
    public HashMap<Integer,Arista> getAristas (){
        return this.arista;
    }
    public HashMap<Integer,Vertice> getNodos (){
        return this.nodo;
    }
    public void setG (HashMap<Integer,Vertice> a, HashMap<Integer,Arista> b){
        this.nodo = (HashMap)a;
        this.arista = (HashMap)b;
    }
   /* public GrafoCreacion(HashMap<Integer, Vertice> nodo, HashMap<Integer, Arista> arista, int NumAristas, int NumNodos) {
        this.nodo = nodo;
        this.arista = arista;
        this.NumAristas = NumAristas;
        this.NumNodos = NumNodos;
    }
  

    public GrafoCreacion(HashMap<Integer, Vertice> nodo, HashMap<Integer, Arista> arista) {
        this.nodo = nodo;
        this.arista = arista;
       
    }*/
    public GrafoCreacion(HashMap<Integer, Vertice> nodo, HashMap<Integer, Arista> arista) {
        this.nodo = new HashMap();
        for (int i=0;i<nodo.size();i++){
            this.nodo.put(i, new Vertice(nodo.get(i)));
        }
        this.arista = new HashMap();
        for (int i=0;i<arista.size();i++){
            this.arista.put(i, new Arista(arista.get(i)));
        }       
    }
    public GrafoCreacion(){
        this.nodo=new HashMap();
        this.arista=new HashMap();
    }
    public GrafoCreacion (GrafoCreacion g){
        this.nodo=new HashMap();
        for (int i =0; i< g.getNodo().size();i++){
            this.nodo.put(i, new Vertice(g.getNodo().get(i)));
        }
        this.arista=new HashMap();
        for(int i =0; i<g.getArista().size();i++){
            this.arista.put(i, new Arista(g.getArista().get(i)));
        }
    }
    public GrafoCreacion Valores (double min, double max){
       
        int NumAristas = this.arista.size();
        for (int i = 0; i < NumAristas; i++) {
            this.arista.get(i).setp(Math.random()*(max-min)+min);
        }
        GrafoCreacion G = new GrafoCreacion(this.nodo,this.arista);
        return G;
    }
    public static void modificador (GrafoCreacion G){
        for (int i = 0; i < G.getNodos().size(); i++) {
            G.getNodos().get(i).setF(true);
        }
    }
    public GrafoCreacion Dijsktra(Vertice nodoInicial){
        for (int i=0; i<this.nodo.size();i++){
            this.nodo.get(i).setw(Double.POSITIVE_INFINITY);
        }
        double MA[][]= new double[this.nodo.size()][this.nodo.size()];
        for(int i=0; i<this.nodo.size();i++){
            for(int j = 0;j<this.nodo.size();j++){
                MA[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        for(int i=0;i<this.arista.size();i++){
            MA[this.arista.get(i).getid1()][this.arista.get(i).getid2()] = this.arista.get(i).getp();
            MA[this.arista.get(i).getid2()][this.arista.get(i).getid1()] = this.arista.get(i).getp();
        }
        ArrayList<Integer> NodosEncontrados = new ArrayList<Integer>();
        HashMap<Integer,Arista>AZ=new HashMap();
        int numA=0;
        NodosEncontrados.add(this.nodo.get(nodoInicial.get_id()).get_id());
        this.nodo.get(nodoInicial.get_id()).setF(true);
        this.nodo.get(nodoInicial.get_id()).setw(0);
        
        double aux=0;
        int a=0;
        int b=0;
        boolean parar= true;
        
        while(aux!=Double.POSITIVE_INFINITY){
            aux=Double.POSITIVE_INFINITY;
            for(int i=0;i<NodosEncontrados.size();i++){
                for(int j=0;j<this.nodo.size();j++){
                    if(this.nodo.get(j).getF()!= true && MA [NodosEncontrados.get(i)][j]!=Double.POSITIVE_INFINITY){
                        if ((this.nodo.get(NodosEncontrados.get(i)).getw()+MA[NodosEncontrados.get(i)][j]) < aux) {
                            this.nodo.get(j).setw(this.nodo.get(NodosEncontrados.get(i)).getw()+MA[NodosEncontrados.get(i)][j]);
                            aux = this.nodo.get(j).getw();
                            a = NodosEncontrados.get(i);
                            b = j;
                    }
                }
            }
        }
      if (aux != Double.POSITIVE_INFINITY){
          this.nodo.get(b).setF(true);
          NodosEncontrados.add(b);
          AZ.put(numA, new Arista (a,b,MA[a][b]));
          numA++;          
      }
      }
        HashMap<Integer,Vertice> NZ = new HashMap();

        for (int i = 0; i < NodosEncontrados.size(); i++) {
            NZ.put(i, new Vertice(this.nodo.get(NodosEncontrados.get(i))));
        }
        GrafoCreacion G1 = new GrafoCreacion(NZ,AZ);
        return G1;               
    }    
    public GrafoCreacion Prim(){
        GrafoCreacion G = new GrafoCreacion(this.nodo, this.arista);
        Arista MA[][] = new Arista[G.getNodos().size()][G.getNodos().size()];

        for (int i = 0; i < G.getAristas().size(); i++) {
            MA[G.getAristas().get(i).getid1()][G.getAristas().get(i).getid2()] = G.getAristas().get(i);
            MA[G.getAristas().get(i).getid2()][G.getAristas().get(i).getid1()] = G.getAristas().get(i);
        }
        ArrayList<Integer> NodosEncontrados = new ArrayList<Integer>();
        HashMap<Integer, Arista> AZ = new HashMap();
        int numA = 0;
        NodosEncontrados.add(G.getNodos().get(0).get_id());
        G.getNodos().get(0).setF(true);
        PriorityQueue<Arista> pqAristas = new PriorityQueue<>();
        double em = 0;
        for (int z = 0; z < G.getAristas().size(); z++) {
            for (int i = 0; i < NodosEncontrados.size(); i++) {
                for (int j = 0; j < G.getNodos().size(); j++) {
                    if (MA[NodosEncontrados.get(i)][j] != null && G.getNodos().get(j).getF() == false) {
                        pqAristas.add(MA[NodosEncontrados.get(i)][j]);
                    }
                }
            }
            if (pqAristas.isEmpty() == false) {
                if (NodosEncontrados.contains(pqAristas.peek().getid1())) {
                    G.getNodos().get(pqAristas.peek().getid2()).setF(true);
                    NodosEncontrados.add(pqAristas.peek().getid2());
                    AZ.put(numA, MA[pqAristas.peek().getid1()][pqAristas.peek().getid2()]);
                    numA++;
                    em = em + pqAristas.peek().getp();
                    pqAristas.clear();
                } else {
                    G.getNodos().get(pqAristas.peek().getid1()).setF(true);
                    NodosEncontrados.add(pqAristas.peek().getid1());
                    AZ.put(numA, MA[pqAristas.peek().getid1()][pqAristas.peek().getid2()]);
                    numA++;
                    em = em + pqAristas.peek().getp();
                    pqAristas.clear();
                }
            }
            if (AZ.size() == G.getNodos().size() - 1) {
                break;
            }
        }
        System.out.println("Peso total del arbol de expancion minima Prim = ."+em);
        GrafoCreacion A = new GrafoCreacion(G.getNodos(), AZ);
        return A;
    }
    public GrafoCreacion Kruskal_D(){
        GrafoCreacion G = new GrafoCreacion(this.nodo, this.arista);        
        PriorityQueue<Arista> PrioridadAristas = new PriorityQueue<>();
        HashMap<Integer, Arista> MExp = new HashMap();
        HashMap<Integer, Vertice> nodo = new HashMap();
        ArrayList<Integer> L = new ArrayList<Integer>();
        int NumAristas = 0;
        int NumNodos = 0;
        double total = 0;
        
        for (int i = 0; i < G.getAristas().size(); i++) {
            PrioridadAristas.add(G.getAristas().get(i));
        }       
        for (int i = 0; i < G.getAristas().size(); i++) {
            if (L.contains(PrioridadAristas.peek().getid1()) && L.contains(PrioridadAristas.peek().getid2())) {
                GrafoCreacion Cap1 = new GrafoCreacion(G.getNodos(), MExp);
                GrafoCreacion Cap2 = new GrafoCreacion();
                Cap2 = DFS_I.DFS_I(Cap1, Cap1.getNodos().get(PrioridadAristas.peek().getid1()));
                int aux = 0;
                for (int j = 0; j < Cap2.getNodos().size(); j++) {
                    if (Cap2.getNodos().get(j).get_id() == PrioridadAristas.peek().getid2()) {
                        aux = 1;
                    }
                }
                if (aux == 0) {
                    total = total + PrioridadAristas.peek().getp();
                    MExp.put(NumAristas, PrioridadAristas.poll());
                    NumAristas++;
                } else {
                    PrioridadAristas.poll();
                }
            } else {
                if (L.contains(PrioridadAristas.peek().getid1()) == false) {
                    L.add(PrioridadAristas.peek().getid1());
                }
                if (L.contains(PrioridadAristas.peek().getid2()) == false) {
                    L.add(PrioridadAristas.peek().getid2());
                }
                total = total + PrioridadAristas.peek().getp();
                MExp.put(NumAristas, PrioridadAristas.poll());
                NumAristas++;
            }
            if (MExp.size() == G.getNodos().size() - 1) {
                i = G.getAristas().size();
            }
        }
        for (int i = 0; i < L.size(); i++) {
            nodo.put(i, G.getNodos().get(L.get(i)));
        }
        System.out.println("Peso total del arbol de expancion minima Kruskal Dir ="+total);
        GrafoCreacion A = new GrafoCreacion(nodo, MExp);
        return A;
        } 
    public GrafoCreacion Kruskal_I(){
        GrafoCreacion G = new GrafoCreacion(this.nodo, this.arista);        
        PriorityQueue<Arista> PrioridadAristas = new PriorityQueue<>();
        HashMap<Integer, Arista> Mexp = new HashMap();
        HashMap<Integer, Vertice> nodo = new HashMap();
        ArrayList<Integer> Ñ = new ArrayList<Integer>();
        int NumAristas = 0;
        int NumNodos = 0;
        double total = 0;
        for (int i = 0; i < G.getAristas().size(); i++) {
            PrioridadAristas.add(G.getAristas().get(i));
        }
       
        for (int i = 0; i < G.getAristas().size(); i++) {
            if (Ñ.contains(PrioridadAristas.peek().getid1()) && Ñ.contains(PrioridadAristas.peek().getid2())) {
                GrafoCreacion Cap1 = new GrafoCreacion(G.getNodos(), Mexp);
                GrafoCreacion Cap2 = new GrafoCreacion();
                Cap2 = DFS_I.DFS_I(Cap1, Cap1.getNodos().get(PrioridadAristas.peek().getid1()));
                int flag = 0;
                for (int j = 0; j < Cap2.getNodos().size(); j++) {
                    if (Cap2.getNodos().get(j).get_id() == PrioridadAristas.peek().getid2()) {
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    total = total + PrioridadAristas.peek().getp();
                    Mexp.put(NumAristas, PrioridadAristas.poll());
                    NumAristas++;
                } else {
                    PrioridadAristas.poll();
                }
            } else {
                if (Ñ.contains(PrioridadAristas.peek().getid1()) == false) {
                    Ñ.add(PrioridadAristas.peek().getid1());
                }
                if (Ñ.contains(PrioridadAristas.peek().getid2()) == false) {
                    Ñ.add(PrioridadAristas.peek().getid2());
                }
                total = total + PrioridadAristas.peek().getp();
                Mexp.put(NumAristas, PrioridadAristas.poll());
                NumAristas++;
            }
            if (Mexp.size() == G.getNodos().size() - 1) {
                i = G.getAristas().size();
            }
        }
        for (int i = 0; i < Ñ.size(); i++) {
            nodo.put(i, G.getNodos().get(Ñ.get(i)));
        }
        System.out.println("Peso total del arbol de expancion minima Kruskal Inv ="+total);
        GrafoCreacion A = new GrafoCreacion(nodo, Mexp);
        return A;
    }
}