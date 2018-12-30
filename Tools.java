
public final class Tools {

	private Tools() {
		// prevents instantiation by anyone thus simulating a static class
	}
	
	public static String[] parsePath(String path) {
		if (path.charAt(0) == '/') {
			// is absolute path. At split, this information will be lost. To prevent that, add a space at the beginning
			path = " " + path;
		}
		String[] words = path.split("[/]+");
		if (words[0].equals(" ")) {
			// is absolute path; Set to "/"
			words[0] = "/";
		}
		
		return words;
	}
	
	public static Node getDirectory(Node currentDirectory, String[] path) {
		if (path == null) return currentDirectory;
		
		for (int i = 0; i < path.length; i++) {
			if (currentDirectory == null) return null;
			if (currentDirectory.isDirectory() == false) return null;
			
			switch(path[i]) {
			case "/":
				Node root = currentDirectory.getParent();
				while (root != null) {
					currentDirectory = root;
					root = currentDirectory.getParent();
				}
				break;
			case ".":
				break;
			case "..":
				currentDirectory = currentDirectory.getParent();
				break;
			default:
				currentDirectory = currentDirectory.getChildByName(path[i]);
				break;
			}
		}
		
		if (currentDirectory == null) return null;
		if (currentDirectory.isDirectory() == false) return null;
		return currentDirectory;
		
	}
}
