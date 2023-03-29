package w2;

public class MyGeneric<E> {
    E e;

    public MyGeneric(){}

    public MyGeneric(E e){
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
    
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj = new MyGeneric<>();

        strObj.setE("Hello World");
        intObj.setE(1234);

        System.out.println(strObj.getE());
        System.out.println(intObj.getE().toString());
    }
}
