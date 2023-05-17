package w8;

public class ComparableBook implements Comparable<ComparableBook> {
    private int id;
    private String name;

    public ComparableBook() {
    }

    public ComparableBook(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(ComparableBook o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "Book " + Integer.toString(this.id) + " \"" + this.name + "\"";
    }
}
