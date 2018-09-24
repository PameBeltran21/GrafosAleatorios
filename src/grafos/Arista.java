package grafos;
/**
 *
 * @author Pame Beltran
 */
public class Arista {  
    private int id1;
    private int id2;
    
    public Arista (int id1, int id2){
        this.id1=id1;
        this.id2=id2;
    }
    public Arista(){
     
    }
    /////////GETTERS Y SETTERS
    public int getid1(){
        return this.id1;
    }
    public int getid2(){
        return this.id2;
    }
    public void setid1(int KeyNodo){
        this.id1=KeyNodo;
    }
    public void setid2(int KeyNodo){
    this.id2=KeyNodo;
    }            
}