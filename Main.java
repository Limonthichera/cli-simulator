import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		Node root = new Folder("");
		
		PrintWriter cmdOutput;
		PrintWriter cmdErr;
		BufferedReader inStream;
		
		try {
			FileReader inFile = new  FileReader(args[0]);
	        inStream = new BufferedReader(inFile);
			
			FileWriter cmdOutputFile = new FileWriter(args[1]);
	        cmdOutput = new PrintWriter(cmdOutputFile);
	        
	        FileWriter cmdErrorFile = new FileWriter(args[2]);
	        cmdErr = new PrintWriter(cmdErrorFile);
		} catch(IOException e) {
			System.out.println("Error creating files: " + e);
			return;
		}
		
		Bash bash = new Bash(root, cmdOutput, cmdErr);
		
		String cmd = inStream.readLine();
		
		for (int i = 1; cmd != null && !cmd.equals(""); cmd = inStream.readLine(), i++) {
			cmdOutput.println(i);
			cmdErr.println(i);
			bash.cmd(cmd);
		}

		inStream.close();
		cmdOutput.close();
		cmdErr.close();
	}
	
}
