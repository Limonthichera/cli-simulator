import java.io.PrintWriter;

public abstract class Command {
	public abstract int execute();
	
	protected PrintWriter cmdOutput = null;
	protected PrintWriter errOutput = null;
	protected Node currentDirectory = null;
	protected String[] args = null;
	protected Bash bash = null;
	
	public void setArgs(String[] args) {
		this.args = args;
	}
	
	public void setBash(Bash bash) {
		this.bash = bash;
		cmdOutput = bash.getCmdOutput();
		errOutput = bash.getErrOutput();
		currentDirectory = bash.getCurrentDirectory();
	}
}
