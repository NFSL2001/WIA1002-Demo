package w9;
// WIA/WIB1002 Data Structures
// part of Graphs implementation using List
public class Vertex<T extends Comparable<T>, N extends Comparable <N>> {
   public T vertexInfo;
   public int indeg;
   public int outdeg;
   public Vertex<T,N> nextVertex;
   public Edge<T,N> firstEdge;
    
   public Vertex() {
      vertexInfo=null;
      indeg=0;
      outdeg=0;
      nextVertex = null;
      firstEdge = null;
   }
	
   public Vertex(T vInfo, Vertex<T,N> next) {
      vertexInfo = vInfo;
      indeg=0;
      outdeg=0;
      nextVertex = next;
      firstEdge = null;
   }	
}

