import java.util.Iterator;

/**
 * Abstract class, implements basic functionality for an item in the file system.
 * @author Teodor
 */
public abstract class FilesysBasic implements Node, Comparable<Node> {
	// --------------- COMPOSITE - BASIC ---------------
	
	private String name;
	private Node parent;
	
	/**
	 * Sets node name to given name
	 * @param name Node name; use an empty string for root directory
	 */
	public FilesysBasic(String name) {
		this.name = name;
	}

	// --------------- THIS SECTION DOES APPLY TO BOTH FILES & FOLDERS ---------------
	/**
	 * Get current object's name
	 * @return Object name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get current object's absolute path
	 * @return Object path, string format
	 */
	@Override
	public String getPath() {
		if (parent == null) return getName();
		return parent.getPath() + "/" + getName();
	}

	/**
	 * Get current object's parent
	 * @return Node parent
	 */
	@Override
	public Node getParent() {
		return parent;
	}

	/**
	 * Sets current object's parent to the Node object received as parameter
	 * @param parent Node, current object's new parent
	 */
	@Override
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * Extends Comparable; Orders elements in alphabetical order based on their name
	 * @param node Node to compare to
	 */
	@Override
	public int compareTo(Node node) {
		return getName().compareTo(node.getName());
	}
	
	// --------------- THIS SECTION DOES APPLY TO FOLDERS ONLY ---------------
	// Do nothing so that we can avoid handling this in Files, will override in Folders
	/**
	 * Does nothing, can be implemented by Folder type nodes
	 * <br><b>Known Folder type nodes: {@link Folder}</b>
	 */
	public void add(Node node) {
		return;
	}

	/**
	 * Does nothing, can be implemented by Folder type nodes
	 * <br><b>Known Folder type nodes: {@link Folder}</b>
	 */
	public void remove(Node node) {
		return;
	}

	/**
	 * Does nothing, can be implemented by Folder type nodes
	 * <br><b>Known Folder type nodes: {@link Folder}</b>
	 * @return null
	 */
	public Iterator<Node> getChildIterator() {
		return null;
	}

}
