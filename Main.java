import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args){
		Node root = new Folder("");
		Node bin = new Folder("bin");
		Node user = new Folder("user");
		Node sys = new Folder("sys");
		Node Teodor = new Folder("Teodor");
		Node Maria = new Folder("Maria");
		Node Desktop = new Folder("Desktop");
		Node src = new Folder("src");
		
		root.add(bin);
		root.add(user);
		bin.add(sys);
		user.add(Teodor);
		user.add(Maria);
		Teodor.add(Desktop);
		Desktop.add(src);
		
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
		
		bash.setCurrentDirectory(root);
		bash.cmd("pwd");
		
		bash.setCurrentDirectory(bin);
		bash.cmd("pwd");
		
		bash.setCurrentDirectory(user);
		bash.cmd("pwd");
		
		bash.setCurrentDirectory(sys);
		bash.cmd("pwd");
		
		bash.setCurrentDirectory(Teodor);
		bash.cmd("pwd");
		
		bash.setCurrentDirectory(Maria);
		bash.cmd("pwd");
		
		bash.setCurrentDirectory(Desktop);
		bash.cmd("pwd");
		
		bash.setCurrentDirectory(src);
		bash.cmd("pwd");
		
		
		
		cmdOutput.close();
		cmdErr.close();
	}
	
}
