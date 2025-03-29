import pack1.*;
// import pack1.subpack1.c1;
public class Demo {
    public int value=4;
    public void display(){
        System.out.println("hello");
    }
    @Override
    public boolean equals(Object d){
        if( (d instanceof Demo ) && ((Demo)d).value==this.value){
            return true;
        }
        return false;
    }
    public static void main(String[] argv){
        c1 cc= new c1();
        c2 bb= new c2();
        c1.test();
        c2.test();
        pack1.c1.test();
        
        System.out.println("in demo.java");
    }
}
