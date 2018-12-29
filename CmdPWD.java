
public class CmdPWD extends Command {

	@Override
	public int execute() {
		try {
			String path = currentDirectory.getPath();
			if (path.equals("")) {
				// is root directory
				path = "/";
			}
			cmdOutput.println(path);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}
}
