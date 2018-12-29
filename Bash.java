import java.io.PrintWriter;

public class Bash {
	private Node currentDir;
	private PrintWriter errOutput;
	private PrintWriter cmdOutput;
	
	public Bash(Node dir, PrintWriter cmdOutput, PrintWriter errOutput) {
		currentDir = dir;
		this.cmdOutput = cmdOutput;
		this.errOutput = errOutput;
	}
	
	private CommandList parseCommandName(String cmd) {
		switch(cmd) {
		case "cd":
			return CommandList.cd;
		case "cp":
			return CommandList.cp;
		case "grep":
			return CommandList.grep;
		case "ls":
			return CommandList.ls;
		case "mkdir":
			return CommandList.mkdir;
		case "mv":
			return CommandList.mv;
		case "pwd":
			return CommandList.pwd;
		case "rm":
			return CommandList.rm;
		case "touch":
			return CommandList.touch;
		}
		
		return null;
	}
	
	public int cmd(String cmdLine) {
		System.out.println("Command is: " + cmdLine);
		String[] words = cmdLine.split("[\\s]+");
		CommandList cmdToken = parseCommandName(words[0]);
		
		if (cmdToken == null) return -1;
		
		Command cmd = CommandFactory.getInstance().createCommand(cmdToken);
		cmd.setArgs(words);
		cmd.setBash(this);
		
		return cmd.execute();
	}
	
	// Change bash variables
	public void setCurrentDirectory(Node dir) {
		currentDir = dir;
	}
	
	// Get bash variables
	public Node getCurrentDirectory() {
		return currentDir;
	}
	
	public PrintWriter getCmdOutput() {
		return cmdOutput;
	}
	
	public PrintWriter getErrOutput() {
		return errOutput;
	}
}
