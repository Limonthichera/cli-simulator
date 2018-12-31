import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class CmdLS extends Command {

	@Override
	public int execute() {
		boolean flag_R = false;
		boolean flag_grep = false;
		String[] path = null;
		int pathIndex = 0;
		
		for (int i = 1; i < args.length; i++) {
			if (args[i].charAt(0) == '-') {
				// only possible argument of this type is -R; in a more complex scenario, I would send this to a parser
				// that returns a list of flags, but for the purpose of this project, the following approach will do
				flag_R = true;
				
				continue;
			}
			
			if (args[i].equals("|")) {
				if (args[i + 1].equals("grep")) {
					flag_grep = true;
				} else break;
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
		
		if (!flag_grep) {
			printChildren(cmdOutput, currentDirectory, flag_R);
			return 0;
		}
		
		// print with grep
		
		return 0;
		
	}
	
	private static void printChildren(PrintWriter cmdOutput, Node currentDirectory, boolean R) {
		Iterator<Node> childIterator = currentDirectory.getChildIterator();
		ArrayList<Node> childQueue = new ArrayList<Node>();
		Node child;
		
		cmdOutput.println((currentDirectory.getPath() == "")?("/:"):(currentDirectory.getPath() + ":"));
		
		while (childIterator.hasNext()) {
			child = childIterator.next();
			
			cmdOutput.print(child.getPath());
			if (childIterator.hasNext()) cmdOutput.print(" ");
			
			if (R && child.isDirectory()) {
				childQueue.add(child);
			}
		}
		cmdOutput.println();
		cmdOutput.println();
		childIterator = childQueue.iterator();
		while (childIterator.hasNext()) {
			child = childIterator.next();
			
			printChildren(cmdOutput, child, R);
		}
	}
}
