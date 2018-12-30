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
	
	public Node getCopy() {
		Node node = new Folder(getName());
		node.setParent(getParent());
		
		Iterator<Node> childIterator = getChildIterator();
		while (childIterator.hasNext()) {
			node.add(childIterator.next().getCopy());
		}
		
		return node;
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
	
	/**
	 * Gets a child with given name
	 * @param name String - desired name
	 * @return Node - child of given name if exists, <i>null</i> otherwise
	 */
	public Node getChildByName(String name) {
		Iterator<Node> childIterator = children.iterator();
		Node child;
		while (childIterator.hasNext()) {
			child = childIterator.next();
			if (child.getName().equals(name)) return child;
		}
		
		return null;
	}
	
	/**
	 * Always true; is directory
	 * @return true
	 */
	@Override
	public boolean isDirectory() {
		return true;
	}
}
