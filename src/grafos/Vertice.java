package grafos;
/**
 *
 * @author Pame Beltran
 */
public class Vertice {
	public int id;
	public int grado;
        public double x;
        public double y;
        public boolean visited;
        private boolean F;
        private double w;
        public int connected;
        
    public Vertice(){
        this.grado=0;
        this.x=0;
        this.y=0;
        this.connected=0;
        this.F=false;
        this.w=0;
    }
    public Vertice(Vertice v1){
        this.grado=v1.getcoor();
        this.id=v1.get_id();
        this.x=v1.getx();
        this.y=v1.gety();
        this.connected=v1.getconnected();
        this.F=v1.getF();
        this.w=v1.getw();
    }
    public Vertice (int KeyRandom){    
        this.id = KeyRandom;
        this.grado = 0;
        this.x =0;
        this.y =0;
        this.connected=0;
        this.F=false;
        this.w=0;
    }
    public Vertice (int KeyRandom, double x1, double y1){
        this.id= KeyRandom;
        this.grado=0;
        this.x=x1;
        this.y=y1;
        this.F=false;
        this.connected =0;
        this.w=0;
    }
    public Vertice (int KeyRandom, int con, int gra, double x1, double y1, boolean g, double p){    
        this.id = KeyRandom;
        this.connected=con;
        this.grado = gra;
        this.x =x1;
        this.y =y1;
        this.F=g;
        this.w=p;
    }
    public void colocarrect (Vertice n1){
        this.grado=n1.getcoor();
        this.id=n1.get_id();
        this.x=n1.getx();
        this.y=n1.getx();
    }
    public void copiar (Vertice n1){
        this.grado=n1.getcoor();
        this.id=n1.get_id();
        this.x=n1.getx();
        this.y=n1.gety();
        this.connected=n1.getconnected();
        this.F=n1.getF();
        this.w=n1.getw();
    }
 /////////GETTERS Y SETTERS
   
    public int get_id(){
        return this.id;
    }
    public void AumCoor(int i){
        this.grado=this.grado+i;
    }
    public void setcoor (int i){
        this.grado = i;
    }
    public int getcoor (){
        return this.grado;
    }
    public void set (int idAzar){
        this.id=idAzar;
    }
    public double getx(){
        return this.x;
    }
    public void setx (double x1){
        this.x=x1;
    }
    public double gety(){
        return this.y;
    }
    public void sety (double y1){
        this.y=y1;
    }
    public void setvisited(boolean visited){
           this.visited= visited;
    }
    public boolean getvisited(){
          return this.visited;
    }
    public void conectar(){
        this.connected=1;
    }
    public int getconnected(){
        return this.connected;
    }
    public void setF(boolean a){
        this.F=a;
    }
    public boolean getF(){
        return this.F;
    }
    public void setw(double p){
        this.w=p;
    }
    public double getw (){
        return this.w;
    }
}