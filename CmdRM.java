
public class CmdRM extends Command {

	@Override
	public int execute() {
		String[] destPath = null;

		// get destination path
		
		// here it must be the path (assuming a perfect world where the user never makes mistakes in his commands
		destPath = Tools.parsePath(args[1].replaceAll("[^/]*$", ""));
		
		currentDirectory = Tools.getDirectory(currentDirectory, destPath);
		
		destPath = Tools.parsePath(args[1]);
		
		if (currentDirectory == null || currentDirectory.getChildByName(destPath[destPath.length - 1]) == null) {
			errOutput.println("rm: cannot remove " + args[1] + ": No such file or directory");
			return -1;
		}
		
		Node node = currentDirectory.getChildByName(destPath[destPath.length - 1]);
		
		Node testNode = bash.getCurrentDirectory();
		while (testNode != node && testNode != null) {
			testNode = testNode.getParent();
		}
		
		if (testNode == null) {
			currentDirectory.remove(node);
			node.setParent(null);
		}
		
		return 0;
	}
}
