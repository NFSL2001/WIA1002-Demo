package w9;
// WIA/WIB1002 Data Structures
// part of Graphs implementation using List
public class Edge<T extends Comparable<T>, N extends Comparable <N>> {
	public Vertex<T,N> toVertex;
	public N weight;
	public Edge<T,N> nextEdge;
	
	public Edge()	{
		toVertex = null;
		weight = null;
		nextEdge = null;
	}
	
	public Edge(Vertex<T,N> destination, N w, Edge<T,N> a)	{
		toVertex = destination;
		weight = w;
		nextEdge = a;
	}

	public Edge(Vertex<T,N> destination, Edge<T,N> a)	{
		toVertex = destination;
		nextEdge = a;
	}
}
