/**
 * Adds File functionality over the FilesysBasic Basic Node
 * @author Teodor
 *
 */
public class File extends FilesysBasic {
	// --------------- COMPOSITE - LEAF ---------------
	
	/**
	 * Creates a File node with given name; Can't have children
	 * @param name File name
	 */
	public File(String name) {
		super(name);
	}
	
	/**
	 * Always false; this is a file
	 * @return false
	 */
	@Override
	public boolean isDirectory() {
		return false;
	}

}
