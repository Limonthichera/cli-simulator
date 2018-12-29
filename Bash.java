import java.io.PrintWriter;

/**
 * Bash able to execute several commands on a filesystem
 * @author Teodor
 *
 */
public class Bash {
	private Node currentDir;
	private PrintWriter errOutput;
	private PrintWriter cmdOutput;
	
	/**
	 * Creates a bash terminal in the directory <b>dir</b>. Will write command outputs in <b>cmdOutput</b> and errors
	 * in <b>errOutput</b>.
	 * @param dir Bash directory
	 * @param cmdOutput PrintWriter - command output destination
	 * @param errOutput PrintWriter - command error destination
	 */
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
	
	/**
	 * Executes the command received as parameter.
	 * <table>
	 * <tr><th>Command</th><th>Parameters</th><th>Functional</th></tr>
	 * <tr><td>ls</td><td>&lt;path&gt; [-R]</td><td>No</td></tr>
	 * <tr><td>pwd</td><td>N/A</td><td>Yes</td></tr>
	 * <tr><td>cd</td><td>&lt;path&gt;</td><td>No</td></tr>
	 * <tr><td>cp</td><td>&lt;source&gt; &lt;destination_folder&gt;</td><td>No</td></tr>
	 * <tr><td>mv</td><td>&lt;source&gt; &lt;destination_folder&gt;</td><td>No</td></tr>
	 * <tr><td>rm</td><td>&lt;path&gt;</td><td>No</td></tr>
	 * <tr><td>touch</td><td>&lt;path&gt;</td><td>No</td></tr>
	 * <tr><td>mkdir</td><td>&lt;path&gt;</td><td>No</td></tr>
	 * <tr><td>grep</td><td>&lt;regex&gt;</td><td>No</td></tr>
	 * <caption>Supported Commands</caption>
	 * </table>
	 * @param cmdLine Command
	 * @return 0 - success<br>-1/1 - failure
	 * @see Command
	 */
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
	/**
	 * Changes the current working directory of this bash
	 * @param dir New current working directory
	 */
	public void setCurrentDirectory(Node dir) {
		currentDir = dir;
	}
	
	// Get bash variables
	/**
	 * Gets the current working directory of this bash
	 * @return current working directory
	 */
	public Node getCurrentDirectory() {
		return currentDir;
	}
	
	/**
	 * Gets the current command output PrintWriter
	 * @return PrintWriter - current command output
	 */
	public PrintWriter getCmdOutput() {
		return cmdOutput;
	}
	
	/**
	 * Gets the current command error output PrintWriter
	 * @return PrintWriter - current command error output
	 */
	public PrintWriter getErrOutput() {
		return errOutput;
	}
}
