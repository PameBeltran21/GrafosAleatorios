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
        float  probabilidad;
        float conectividad;
        double Coordenada;
        Erdos M1 = new Erdos();
        Gilbert M2= new Gilbert();
        MGS M3= new MGS();
        BA M4= new BA();
        
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
           M1.Erdos(NumNodos, NumAristas);
         break;
         
       case 2: 
           NumNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           probabilidad = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese la probabilidad: "));
           M2.Gilbert(NumNodos, probabilidad);
           //JOptionPane.showInputDialog(null,"Nodos: "+NumNodos);
         break;
         
       case 3:
           NumNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           conectividad = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese probabilidad: "));
           M3.MGS(NumNodos,conectividad);
         break;
         
       case 4: 
           NumNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de nodos: "));
           Coordenada = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese grado de conexion: "));
           M4.BA(NumNodos,Coordenada);
         break;
                 
       default: JOptionPane.showMessageDialog(null, "Invalido !! ");
         break;
         }
    }
}