package psn.Main.command;

import psn.Main.Out.LogWin_l;

public class Terminal {
	// <log "Text">./func<
	//                    <move(up 2),(left 4)>
	//                    <send.log("Log")>
	//                   >
	public static void use_terminal(String msg) {
		String[] subject = msg.split(",");
		System.out.println(subject[0]);
	}

	private static void Log(String msg) {
		LogWin_l.out(msg);
	}
}
