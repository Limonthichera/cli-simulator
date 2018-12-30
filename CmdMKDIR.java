
public class CmdMKDIR extends Command {

	@Override
	public int execute() {
		String[] path = null;
		
		// here it must be the path (assuming a perfect world where the user never makes mistakes in his commands
		path = Tools.parsePath(args[1].replaceAll("[^/]*$", ""));
		
		currentDirectory = Tools.getDirectory(currentDirectory, path);
		
		if (currentDirectory == null) {
			errOutput.println("mkdir: " + args[1].replaceAll("/[^/]*$", "") + ": No such directory");
			return -1;
		}

		path = Tools.parsePath(args[1]);
		currentDirectory.add(new Folder(path[path.length - 1]));
		
		return 0;
	}
}
