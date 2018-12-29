import java.util.Iterator;
import java.util.TreeSet;

/**
 * Adds Folder functionality over the FilesysBasic Basic Node
 * @author Teodor
 *
 */
public class Folder extends FilesysBasic{
	// --------------- COMPOSITE - COMPOSITE ---------------
	
	/**
	 * Creates a Folder node with given name; Can have children
	 * @param name Folder name
	 */
	public Folder(String name) {
		super(name);
		children = new TreeSet<Node>();
	}

	// --------------- THIS SECTION DOES APPLY TO FOLDERS ONLY ---------------
	
	private TreeSet<Node> children;

	/**
	 * Adds node received to the list of children and sets its parent to this folder
	 * @param node New child
	 */
	public void add(Node node) {
		node.setParent(this);
		children.add(node);
	}

	/**
	 * Removes node received from the list of children and sets its parent to null
	 * @param node Former child
	 */
	public void remove(Node node) {
		node.setParent(null);
		children.remove(node);
	}

	/**
	 * Gets an iterator through the list of children
	 * @return Iterator&lt;Node&gt; through the children list
	 */
	public Iterator<Node> getChildIterator() {
		return children.iterator();
	}
}
