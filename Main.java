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
		Node lab = new Folder("lab");
		Node labIOCLA = new Folder("labIOCLA");
		Node labPOO = new Folder("labPOO");
		Node labSD = new Folder("labSD");
		Node labi01 = new File("lab01");
		Node labi02 = new File("lab02");
		Node labi03 = new File("lab03");
		Node labp01 = new File("lab01");
		Node labp02 = new File("lab02");
		Node labp03 = new File("lab03");
		Node labs01 = new File("lab01");
		Node labs02 = new File("lab02");
		Node labs03 = new File("lab03");
		
		root.add(bin);
		root.add(user);
		bin.add(sys);
		user.add(Teodor);
		user.add(Maria);
		Teodor.add(Desktop);
		Desktop.add(src);
		src.add(lab);
		lab.add(labIOCLA);
		lab.add(labPOO);
		lab.add(labSD);
		labIOCLA.add(labi01);
		labIOCLA.add(labi02);
		labIOCLA.add(labi03);
		labPOO.add(labp01);
		labPOO.add(labp02);
		labPOO.add(labp03);
		labSD.add(labs01);
		labSD.add(labs02);
		labSD.add(labs03);
		
		
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
		bash.cmd("ls -R /user/Maria/../Teodor/Desktop/../");
		
		
		
		cmdOutput.close();
		cmdErr.close();
	}
	
}
