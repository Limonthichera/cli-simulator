import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args){
		Node root = new Folder("");
		
		PrintWriter cmdOutput;
		PrintWriter cmdErr;
		
		try {
			FileWriter cmdOutputFile = new FileWriter("output");
	        cmdOutput = new PrintWriter(cmdOutputFile);
	        
	        FileWriter cmdErrorFile = new FileWriter("errors");
	        cmdErr = new PrintWriter(cmdErrorFile);
		} catch(IOException e) {
			System.out.println("Error creating files: " + e);
			return;
		}
		
		Bash bash = new Bash(root, cmdOutput, cmdErr);
		bash.cmd("cp something here");
		
		cmdOutput.close();
		cmdErr.close();
	}
	
}
