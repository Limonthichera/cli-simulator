import java.io.PrintWriter;
import java.util.Iterator;

public class CmdLS extends Command {

	@Override
	public int execute() {
		boolean flag_R = false;
		String[] path = null;
		int pathIndex = 0;
		
		for (int i = 1; i < args.length; i++) {
			if (args[i].charAt(0) == '-') {
				// only possible argument of this type is -R; in a more complex scenario, I would send this to a parser
				// that returns a list of flags, but for the purpose of this project, the following approach will do
				flag_R = true;
				
				continue;
			}
			
			// here it must be the path (assuming a perfect world where the user never makes mistakes in his commands
			path = Tools.parsePath(args[i]);
			pathIndex = i;
		}
		
		currentDirectory = Tools.getDirectory(currentDirectory, path);
		
		if (currentDirectory == null) {
			errOutput.println("ls: " + args[pathIndex] + ": No such directory");
			return -1;
		}
		
		printChildren(cmdOutput, currentDirectory, flag_R, 0, false);
		return 0;
	}
	
	private static void printChildren(PrintWriter cmdOutput, Node currentDirectory, boolean R, int rank, boolean submit) {
		Iterator<Node> childIterator = currentDirectory.getChildIterator();
		Node child;
		while (childIterator.hasNext()) {
			child = childIterator.next();
			
			if (!submit) {
				for (int i = 0; i < rank; i++) {
					cmdOutput.print("  ");
				}
			}
			
			cmdOutput.print(child.getName() + " ");
			
			if (!submit) cmdOutput.println();
			
			if (R && child.isDirectory()) {
				printChildren(cmdOutput, child, R, rank + 1, submit);
			}
		}
	}
}
