package w5.SList;

public class TestSList {
    public static void main(String[] args) {
        SList<String> slist = new SList<>();
        slist.appendEnd("Linked list");
        slist.appendEnd("is");
        slist.appendEnd("easy.");
        System.out.println("List contains:");
        slist.display();
        System.out.println(slist.removeInitial());
        System.out.printf("‘difficult’ is in the list? %b\n", slist.contains("difficult"));
        slist.clear();
    }
}
