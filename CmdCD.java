
public class CmdCD extends Command {

	@Override
	public int execute() {
		String[] path = null;
			
		// here it must be the path (assuming a perfect world where the user never makes mistakes in his commands
		path = Tools.parsePath(args[1]);
		
		currentDirectory = Tools.getDirectory(currentDirectory, path);
		
		if (currentDirectory == null) {
			errOutput.println("cd: " + args[1] + ": No such directory");
			return -1;
		}
		
		bash.setCurrentDirectory(currentDirectory);
		return 0;
	}

}
