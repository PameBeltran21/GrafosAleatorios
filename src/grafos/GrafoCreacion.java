package grafos;
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

    public GrafoCreacion(HashMap<Integer, Vertice> nodo, HashMap<Integer, Arista> arista, int NumAristas, int NumNodos) {
        this.nodo = nodo;
        this.arista = arista;
        this.NumAristas = NumAristas;
        this.NumNodos = NumNodos;
    }
  

    public GrafoCreacion(HashMap<Integer, Vertice> nodo, HashMap<Integer, Arista> arista) {
        this.nodo = nodo;
        this.arista = arista;
       
    }
}