import java.util.Iterator;

/**
 * @author Teodor
 * Basic interface for the Composite classes
 */
public interface Node {
	// --------------- COMPOSITE - BASE COMPONENT ---------------
	
	/**
	 * To be used for getting current object's name
	 * @return Object name
	 */
	public String getName();
	
	/**
	 * To be used for getting current object's absolute path
	 * @return Object path, string format
	 */
	public String getPath();
	
	/**
	 * To be used for getting current object's parent
	 * @return Node parent
	 */
	public Node getParent();
	
	/**
	 * To be used for setting current object's parent to the Node object received as parameter
	 * @param parent Node, current object's new parent
	 */
	public void setParent(Node parent);
	
	// --------------- THIS SECTION DOES APPLY TO FOLDERS ONLY ---------------
	
	/**
	 * To be used for adding received node to the list of children of current node
	 * @param node Node to be added to the list of children
	 */
	public void add(Node node);
	
	/**
	 * To be used for removing received node from the list of children of current node
	 * @param node Node to be removed from the list of children
	 */
	public void remove(Node node);
	
	/**
	 * To be used for getting an iterator through the children list of current node
	 * @return Iterator&lt;Node&gt; through the children list
	 */
	public Iterator<Node> getChildIterator();
	
	/**
	 * To be used for getting a child with given name
	 * @param name String - desired name
	 * @return Node - child of given name if exists, <i>null</i> otherwise
	 */
	public Node getChildByName(String name);
	
}
