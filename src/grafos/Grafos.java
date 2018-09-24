package grafos;

import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/**
 *
 * @author Pame Beltran
 */
public class Grafos {
    
    public static void main(String[] args) {
      
        int op;
        int NumNodos;
        int NumAristas;
        int nodoInicial;
        float  probabilidad;
        float conectividad;
        double Coordenada;
        
        /*Erdos M1 = new Erdos();
        Gilbert M2= new Gilbert();
        MGS M3= new MGS();
        BA M4= new BA();*/
        
	String menu = "\n   Metodos    \n"+

    "1.- Erdös y Rényi\n"+
    "2.- Gilbert\n"+
    "3.- Modelo geografico simple\n"+
    "4.- Barabási-Albert  \n"+
    "0.- Salida "+
    "\n Opcion: ";
    
    op = parseInt(JOptionPane.showInputDialog(null, menu));

    switch (op)
    {
       case 0:                  
            JOptionPane.showMessageDialog(null, "Programa Terminado");
         break;
       case 1: 
           NumNodos=Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           NumAristas=Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de aristas: "));
           nodoInicial=Integer.parseInt(JOptionPane.showInputDialog(null, "Nodo Inicial: "));
           GrafoCreacion erdos = Erdos.Erdos(NumNodos, NumAristas);
           //GrafoCreacion bfserdos = BFS.BFS(erdos, nodoInicial);
           GrafoCreacion dfsierdos = DFS_I.DFS_I(erdos, nodoInicial);
           //GrafoCreacion dfsrerdos = DFS_R.DFS_R(erdos, nodoInicial);
           //M1.Erdos(NumNodos, NumAristas);
         break;
         
       case 2: 
           NumNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           probabilidad = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la probabilidad: "));
           nodoInicial=Integer.parseInt(JOptionPane.showInputDialog(null, "Nodo Inicial: "));
           GrafoCreacion gilbert = Gilbert.Gilbert(NumNodos, probabilidad);
           GrafoCreacion bfsgilbert = BFS.BFS(gilbert, nodoInicial);
           //GrafoCreacion dfsigilbert = DFS_I.DFS_I(gilbert, nodoInicial);
           //GrafoCreacion dfsrgilbert = DFS_R.DFS_R(gilbert, nodoInicial);
            //M2.Gilbert(NumNodos, probabilidad);
           //JOptionPane.showInputDialog(null,"Nodos: "+NumNodos);
         break;
         
       case 3:
           NumNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           conectividad = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese probabilidad: "));
           nodoInicial=Integer.parseInt(JOptionPane.showInputDialog(null, "Nodo Inicial: "));
           GrafoCreacion mgs = MGS.MGS(NumNodos, conectividad);
           GrafoCreacion bfsmgs = BFS.BFS(mgs, nodoInicial);
           //GrafoCreacion dfsimgs = DFS_I.DFS_I(mgs, nodoInicial);
           //GrafoCreacion dfsrmgs = DFS_R.DFS_R(mgs, nodoInicial);
            //M3.MGS(NumNodos,conectividad);
         break;
         
       case 4: 
           NumNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           Coordenada = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese grado de conexion: "));
           nodoInicial=Integer.parseInt(JOptionPane.showInputDialog(null, "Nodo Inicial: "));
           GrafoCreacion ba = BA.BA(NumNodos, Coordenada);
           GrafoCreacion bfsba = BFS.BFS(ba, nodoInicial);
           //GrafoCreacion dfsiba = DFS_I.DFS_I(ba, nodoInicial);
           //GrafoCreacion dfsrba = DFS_R.DFS_R(ba, nodoInicial);
            //M4.BA(NumNodos,Coordenada);
         break;
                 
       default: JOptionPane.showMessageDialog(null, "Invalido !! ");
         break;
         }
    }
}