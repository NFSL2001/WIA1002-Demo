

public class ArrayBagDemo {
    public static void main(String[] args) {
        ArrayBag1<String> bag1 = new ArrayBag1<>();
        ArrayBag1<String> bag2 = new ArrayBag1<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A", "A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string", "A", "B", "A", "C", "B", "C", "D", "another string"};
        testAdd(bag1, contentsOfBag1);
        testAdd(bag2, contentsOfBag2);
        displayBag(bag1);
        displayBag(bag2);

        ArrayBag1<String> bag3 = (ArrayBag1<String>) bag1.union(bag2);
        displayBag(bag3); 
        ArrayBag1<String> bag4 = (ArrayBag1<String>) bag1.intersection(bag2);
        displayBag(bag4);
        ArrayBag1<String> bag5 = (ArrayBag1<String>) bag1.difference(bag2);
        displayBag(bag5);
    }

    private static void testAdd(BagInterface<String> aBag, String[] content){
        for(String str: content){
            aBag.add(str);
        }
    }

    private static void displayBag(BagInterface<String> aBag){
        System.out.printf("The bag contains %d string(s), as follows:\n", aBag.getCurrentSize());
        String str = "";
        Object[] temp = aBag.toArray();
        for(int i=0; i < aBag.getCurrentSize(); i++){
            str += temp[i];
            if(i != aBag.getCurrentSize() - 1)
                str += ", ";
        }
        System.out.println(str);
    }
}
