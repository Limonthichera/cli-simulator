
public class Main {
	public static void main(String[] args) {
		Node root = new Folder("");
		
		Node bin = new Folder("bin");
		root.add(bin);
		
		Node users = new Folder("users");
		bin.add(users);
		
		Node Teo = new Folder("Teo");
		root.add(Teo);
		
		Node teodor = new File("teodor");
		users.add(teodor);
		
		Node ioana = new File("ioana");
		users.add(ioana);
	
		
		System.out.println(ioana.getPath());
	}
	
}
