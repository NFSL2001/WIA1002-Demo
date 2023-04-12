package w4.student_ans;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> charList = new MyLinkedList<>();
        //append = add to end
        charList.addLast('a');
        charList.addLast('b');
        charList.addLast('c');
        charList.addLast('d');
        charList.addLast('e');
        charList.print();
        System.out.println();
        charList.reverse();
        System.out.println("First element is "+ charList.getFirst().toString());
        System.out.println("Last element is "+ charList.getLast().toString());
        //third value = index 2
        charList.remove(2);
        System.out.printf("The location of 'b' (second value) is: %d\n", charList.indexOf('b'));
        System.out.printf("The location of 'd' (third value) is: %d\n", charList.lastIndexOf('d'));
        System.out.printf("Does the list has 'c'? %b\n", charList.contains('c'));
        
        charList.set(0, 'j');
        charList.set(1, 'a');
        charList.set(2, 'v');
        charList.set(3, 'a');
        charList.print();
    }
}
