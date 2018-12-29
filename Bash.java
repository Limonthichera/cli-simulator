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
	
	public int cmd(String cmd) {
		errOutput.println("Command is: " + cmd);
		return -1;
	}
}
