package mathoscore.data.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 * 
 * @author Artem Los (arteml@kth.se), Mathos Project.
 * @version 2015.04.24
 */
public class HashGraph implements Graph {
	/**
	 * The map edges[v] contains the key-value pair (w, c) if there is an edge
	 * from v to w; c is the cost assigned to this edge. The maps may be null
	 * and are allocated only when needed.
	 */
	private final Map<Integer, Integer>[] edges;
	private final static int INITIAL_MAP_SIZE = 4;

	/** Number of edges in the graph. */
	private int numEdges;

	/**
	 * Constructs a HashGraph with n vertices and no edges. Time complexity:
	 * O(n)
	 * 
	 * @throws IllegalArgumentException
	 *             if n < 0
	 */
	public HashGraph(int n) {
		if (n < 0)
			throw new IllegalArgumentException("n = " + n);

		// The array will contain only Map<Integer, Integer> instances created
		// in addEdge(). This is sufficient to ensure type safety.
		@SuppressWarnings("unchecked")
		Map<Integer, Integer>[] a = new HashMap[n];
		edges = a;
	}

	/**
	 * A method that checks that v may exist in the array.
	 * @remark It does not check whether v has a value associated with it.
	 */
	private void vBound(int v)
	{
		if(v >= edges.length || v < 0)
		{
			throw new IllegalArgumentException();
		}
	}
	/**
	 * Add an edge without checking parameters.
	 */
	private void addEdge(int from, int to, int cost) {
		if (edges[from] == null)
			edges[from] = new HashMap<Integer, Integer>(INITIAL_MAP_SIZE);
		if (edges[from].put(to, cost) == null)
			numEdges++;
	}

	/**
	 * {@inheritDoc graph} Time complexity: O(1).
	 */
	@Override
	public int numVertices() {
		return edges.length;
	}

	/**
	 * {@inheritDoc graph} Time complexity: O(1).
	 */
	@Override
	public int numEdges() {
		return numEdges;
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public int degree(int v) throws IllegalArgumentException {
		// TODO

		//how can v be out of bound?
		vBound(v);
		
		Map<Integer,Integer> obj = edges[v];
		
		if(obj != null)
		{
			return obj.size();
		}
		else
		{
			return 0;
		}
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public VertexIterator neighbors(final int v) {
		// TODO
		vBound(v);
		
		if (edges[v] == null || (edges[v]!=null && edges[v].keySet() == null))
		{
			return new VertexIterator() {
				
				@Override
				public int next() throws NoSuchElementException {
					// TODO Auto-generated method stub
					throw new NoSuchElementException();
				}
				
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return false;
				}
			};
		}
		else
		{
			VertexIterator vi = new VertexIterator() {
			
			Iterator<Integer> it = edges[v].keySet().iterator();
			@Override
			public int next() throws NoSuchElementException {
				return it.next();
			}
			
			@Override
			public boolean hasNext() {
				return it.hasNext();
			}
		};
		
		return vi;
		}
		
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public boolean hasEdge(int v, int w) {
		// TODO
		vBound(v);
		vBound(w);
		
		Map<Integer, Integer> obj = edges[v];
		
		if(obj == null)
			return false;
		else
		{
			if(obj.containsKey(w))
				return true;
			else
				return false;
		}
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public int cost(int v, int w) throws IllegalArgumentException {
		
		vBound(v);
		
		Map<Integer,Integer> obj = edges[v];
		
		int cost = NO_COST;
		
		if(obj != null && obj.containsKey(w))
			cost=obj.get(w);
		
		return cost;
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public void add(int from, int to) {
		// TODO
		this.add(from, to, NO_COST);
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public void add(int from, int to, int c) {
		//kosten måste uppdateras
		// 0 ,0 en kant.
		vBound(to);
		vBound(from);
		
		Map<Integer, Integer> obj = edges[from];
		if(obj == null)
		{
			obj = new HashMap<Integer, Integer>();
			obj.put(to, c);
			numEdges++;
		}
		else if(obj.containsKey(to))
		{
			
			obj.put(to, obj.get(to) + c==NO_COST ? 0:c); // updating cost.
			/*if(!hasEdge(to, from))
			{
				numEdges++;
			}*/
		}
		else
		{
			obj.put(to, c);
			numEdges++;
		}
		
		edges[from] = obj;

		//numEdges++;
		
		
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public void addBi(int v, int w) {
		// TODO
		
		this.addBi(v, w, NO_COST);
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public void addBi(int v, int w, int c) {
		// TODO
		// code duplication. reuse add method.
		vBound(v);
		vBound(w);
		
		this.add(v,w,c);
		this.add(w,v,c);
		
		if(v==w)
		{
			//numEdges--;
		}
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public void remove(int from, int to) {
		// TODO
		
		vBound(from);
		vBound(to);
		
		Map<Integer, Integer> obj = edges[from];
		
		if(obj != null && obj.containsKey(to))
		{
			obj.remove(to);
			numEdges--;
			
			if(hasEdge(to, from) && to==from)
			{
				numEdges--;
			}
		}
	
	}

	/**
	 * {@inheritDoc graph}
	 */
	@Override
	public void removeBi(int v, int w) {
		// TODO
		
		this.remove(v, w);
		this.remove(w, v);
		


	}

	/**
	 * Returns a string representation of this graph.
	 * 
	 * @return a String representation of this graph
	 */
	@Override
	public String toString() {
		// TODO
		
		if(edges == null  || (edges != null && numEdges==0))
		{
			return "{}";
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("{");
		
		for(int i = 0; i< edges.length; i++)
		{
			
				
			//VertexIterator vi = neighbors(i);
			if(edges[i] != null && edges[i].keySet().size() > 0 )
			{
				
				if(i>1 && edges[i-1]!=null)
				{
					sb.append(", ");
				}
				Set<Integer> set = edges[i].keySet();
				for(int key : set)
				{
					if(edges[i].get(key) != NO_COST)
					{
						sb.append("(" + i + ","+ key + "," + edges[i].get(key) + ")");
					}
					else
					{
						sb.append("(" + i + ","+ key+")");
					}
					
	
					
				}

			}
		}
		
		sb.append("}");
		
		return sb.toString();
	}
}