
public class CmdMV extends Command {

	@Override
	public int execute() {
		String[] srcPath = null;
		String[] destPath = null;
		
		// get source path to desired node; save node
		
		// here it must be the path (assuming a perfect world where the user never makes mistakes in his commands
		srcPath = Tools.parsePath(args[1].replaceAll("[^/]*$", ""));
		
		currentDirectory = Tools.getDirectory(currentDirectory, srcPath);
		
		if (currentDirectory == null) {
			errOutput.println("mv: cannot copy " + args[1] + ": No such file or directory");
			return -1;
		}

		srcPath = Tools.parsePath(args[1]);
		
		Node node = currentDirectory.getChildByName(srcPath[srcPath.length - 1]);
		
		
		if (node == null) {
			errOutput.println("mv: cannot move " + args[1] + ": No such file or directory");
			return -1;
		}
		
		// get destination path
		
		// here it must be the path (assuming a perfect world where the user never makes mistakes in his commands
		destPath = Tools.parsePath(args[2]);
		
		currentDirectory = Tools.getDirectory(bash.getCurrentDirectory(), destPath);
		
		if (currentDirectory == null) {
			errOutput.println("mv: cannot copy into " + args[2] + ": No such directory");
			return -1;
		}
		
		if (currentDirectory.getChildByName(node.getName()) != null) {
			errOutput.println("mv: cannot copy " + args[1] + ": Node exists at destination");
			return -1;
		}

		node.getParent().remove(node);
		currentDirectory.add(node);
		return 0;
	}
}
