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
        
    public Vertice(){
        this.grado=0;
        this.x=0;
        this.y=0;
    }
    public Vertice(Vertice v1){
        this.grado=v1.getcoor();
        this.id=v1.get_id();
        this.x=v1.getx();
        this.y=v1.gety();
    }
    public Vertice (int KeyRandom){    
        this.id = KeyRandom;
        this.grado = 0;
        this.x =0;
        this.y =0;
    }
    public Vertice (int KeyRandom, double x1, double y1){    
        this.id = KeyRandom;
        this.grado = 0;
        this.x =x1;
        this.y =y1;
    }
    public void colocarrect (Vertice n1){
        this.grado=n1.getcoor();
        this.id=n1.get_id();
        this.x=n1.getx();
        this.y=n1.getx();
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
}