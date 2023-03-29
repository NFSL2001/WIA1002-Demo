package w2.student_ans;

public class MyGeneric<T> {

    T e;

    public MyGeneric() {
    }

    public MyGeneric(T e) {
        this.e = e;
    }

    public T getE() {
        return e;
    }

    public void setE(T e) {
        this.e = e;
    }

}

class Tester {

    public static void main(String[] args) {

        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj = new MyGeneric<>();

        strObj.setE("RC");
        intObj.setE(77);

        System.out.println("String object: " + strObj.getE());
        System.out.println("Integer object: " + intObj.getE());
    }

}
