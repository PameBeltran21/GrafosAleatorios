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
        Imprime I = new Imprime();
        
        
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
           GrafoCreacion Val1 = new GrafoCreacion(erdos.Valores(0, 50));
           //GrafoCreacion dij1 = new GrafoCreacion(erdos.Dijsktra(erdos.getNodos().get(nodoInicial)));
           //GrafoCreacion prim1 = new GrafoCreacion(erdos.Prim());
           GrafoCreacion krusd1 = new GrafoCreacion(erdos.Kruskal_D());
           //GrafoCreacion krusi1 = new GrafoCreacion(erdos.Kruskal_I());
           //I.Imprime("Erdos-500 Prim", prim1);
           I.Imprime("Erdos-500 Kruskal_D", krusd1);
           //I.Imprime("Erdos-30 Kruskal_I", krusi1);
           //I.Imprime("Erdos-500 Dijkstra", dij1);
           //GrafoCreacion bfserdos = BFS.BFS(erdos, erdos.getNodo().get(nodoInicial));
           //GrafoCreacion dfsierdos = DFS_I.DFS_I(erdos, erdos.getNodo().get(nodoInicial));
           //GrafoCreacion dfsrerdos = DFS_R.DFS_R(erdos, erdos.getNodo().get(nodoInicial));
         break;
         
       case 2: 
           NumNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           probabilidad = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la probabilidad: "));
           nodoInicial=Integer.parseInt(JOptionPane.showInputDialog(null, "Nodo Inicial: "));
           GrafoCreacion gilbert = Gilbert.Gilbert(NumNodos, probabilidad);
           GrafoCreacion Val2 = new GrafoCreacion(gilbert.Valores(0, 50));
           //GrafoCreacion prim2 = new GrafoCreacion(gilbert.Prim());
           GrafoCreacion krusd2 = new GrafoCreacion(gilbert.Kruskal_D());
           //GrafoCreacion krusi2 = new GrafoCreacion(gilbert.Kruskal_I());
           //I.Imprime("Gilbert-500 Prim", prim2);
           I.Imprime("Gilbert-500 Kruskal_D", krusd2);
           //I.Imprime("Gilbert-30 Kruskal_I", krusi2);
           //GrafoCreacion dij2 = new GrafoCreacion(gilbert.Dijsktra(gilbert.getNodos().get(nodoInicial)));
           //I.Imprime("Gilbert-500 Dijkstra", dij2);
           //GrafoCreacion bfsgilbert = BFS.BFS(gilbert, gilbert.getNodo().get(nodoInicial));
           //GrafoCreacion dfsigilbert = DFS_I.DFS_I(gilbert, gilbert.getNodo().get(nodoInicial));
           //GrafoCreacion dfsrgilbert = DFS_R.DFS_R(gilbert, gilbert.getNodo().get(nodoInicial));           
         break;
         
       case 3:
           NumNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           conectividad = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese probabilidad: "));
           nodoInicial=Integer.parseInt(JOptionPane.showInputDialog(null, "Nodo Inicial: "));
           GrafoCreacion mgs = MGS.MGS(NumNodos, conectividad);
           GrafoCreacion Val3 = new GrafoCreacion(mgs.Valores(0, 50));
           //GrafoCreacion prim3 = new GrafoCreacion(mgs.Prim());
           GrafoCreacion krusd3 = new GrafoCreacion(mgs.Kruskal_D());
           //GrafoCreacion krusi3 = new GrafoCreacion(mgs.Kruskal_I());
           //I.Imprime("MGS-500 Prim", prim3);
           I.Imprime("MGS-500 Kruskal_D", krusd3);
          // I.Imprime("MGS-30 Kruskal_I", krusi3);
           //GrafoCreacion dij3 = new GrafoCreacion(mgs.Dijsktra(mgs.getNodos().get(nodoInicial)));
           //I.Imprime("MGS-500 Dijkstra", dij3);
           //GrafoCreacion bfsmgs = BFS.BFS(mgs, mgs.getNodo().get(nodoInicial));
           //GrafoCreacion dfsimgs = DFS_I.DFS_I(mgs, mgs.getNodo().get(nodoInicial));
           //GrafoCreacion dfsrmgs = DFS_R.DFS_R(mgs, mgs.getNodo().get(nodoInicial));
         break;
         
       case 4: 
           NumNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           Coordenada = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese grado de conexion: "));
           nodoInicial=Integer.parseInt(JOptionPane.showInputDialog(null, "Nodo Inicial: "));
           GrafoCreacion ba = BA.BA(NumNodos, Coordenada);
           GrafoCreacion Val4 = new GrafoCreacion(ba.Valores(0, 50));
          //GrafoCreacion prim4 = new GrafoCreacion(ba.Prim());
           GrafoCreacion krusd4 = new GrafoCreacion(ba.Kruskal_D());
          // GrafoCreacion krusi4 = new GrafoCreacion(ba.Kruskal_I());
           //I.Imprime("BA-500 Prim", prim4);
           I.Imprime("BA-500 Kruskal_D", krusd4);
           //I.Imprime("BA-30 Kruskal_I", krusi4);
           //GrafoCreacion dij4 = new GrafoCreacion(ba.Dijsktra(ba.getNodos().get(nodoInicial)));
           //I.Imprime("BA-500 Dijkstra", dij4);
           //GrafoCreacion bfsba = BFS.BFS(ba, ba.getNodo().get(nodoInicial));
           //GrafoCreacion dfsiba = DFS_I.DFS_I(ba, ba.getNodo().get(nodoInicial));
           //GrafoCreacion dfsrba = DFS_R.DFS_R(ba, ba.getNodo().get(nodoInicial));
         break;
                 
       default: JOptionPane.showMessageDialog(null, "Invalido !! ");
         break;
         }
    }
}