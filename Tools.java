
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
}
