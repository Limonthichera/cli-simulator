import java.io.PrintWriter;

/**
 * Base command infrastructure
 * @author Teodor
 *
 */
public abstract class Command {
	public abstract int execute();
	
	protected PrintWriter cmdOutput = null;
	protected PrintWriter errOutput = null;
	protected Node currentDirectory = null;
	protected String[] args = null;
	protected Bash bash = null;
	
	/**
	 * Sets the arguments for the command
	 * @param args args[0] is the command, next items are the arguments
	 */
	public void setArgs(String[] args) {
		this.args = args;
	}
	
	/**
	 * Gets the bash environment variables (PrintWriter cmdOutput, PrintWriter errOutput, Node currentDir)
	 *  and uses it to execute the command
	 * @param bash source bash
	 */
	public void setBash(Bash bash) {
		this.bash = bash;
		cmdOutput = bash.getCmdOutput();
		errOutput = bash.getErrOutput();
		currentDirectory = bash.getCurrentDirectory();
	}
}
