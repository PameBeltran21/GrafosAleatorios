package grafos;
import java.util.ArrayList;
import java.util.HashMap;
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
  }