package grafos;
import java.util.Collections;
/**
 *
 * @author Pame Beltran
 */
public class Arista implements Comparable <Arista> {  
    private int id1;
    private int id2;
    private double w;
    
    public Arista (int id1, int id2){
        this.id1=id1;
        this.id2=id2;
        this.w=0;
    }
    public Arista (int id1, int id2, double p){
        this.id1=id1;
        this.id2=id2;
        this.w = p;
    }
    public Arista (Arista a1){
        this.id1=a1.getid1();
        this.id2=a1.getid2();
        this.w=a1.getp();
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
    public double getp(){
        return this.w;
    }
    public void setp(double p){
        this.w=p;
    }
    public void setid1(int KeyNodo){
        this.id1=KeyNodo;
    }
    public void setid2(int KeyNodo){
    this.id2=KeyNodo;
    }
    public void Copiar (Arista a1){
        this.id1=a1.getid1();
        this.id2=a1.getid2();
        this.w=a1.getp();
    }

    @Override
    public int compareTo(Arista A1) {
        if (this.w > A1.getp())return 1;
        else if(this.w < A1.getp()) return -1;
        else return 0;
    }
}