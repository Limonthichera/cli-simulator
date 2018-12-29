
public class CommandFactory {
	// --------------- SINGLETON ---------------
	private static final CommandFactory factoryInstance = new CommandFactory();
	
	private CommandFactory(){}
	
	public static CommandFactory getInstance() {
		return factoryInstance;
	}
	
	// --------------- FACTORY ---------------
	
	public Command createCommand(CommandList cmd) {
		switch(cmd) {
		case cd:
			return new CmdCD();
		case cp:
			return new CmdCP();
		case grep:
			return new CmdGREP();
		case ls:
			return new CmdLS();
		case mkdir:
			return new CmdMKDIR();
		case mv:
			return new CmdMV();
		case pwd:
			return new CmdPWD();
		case rm:
			return new CmdRM();
		case touch:
			return new CmdTOUCH();
		}
		return null;
	}
}
