/**
 * PWD Command implementation
 * @author Teodor
 *
 */
public class CmdPWD extends Command {

	/**
	 * Executes the PWD command
	 * @return 0 on success, -1 on failure (bash environment variables are not valid)
	 */
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
		return 0;
	}
}
