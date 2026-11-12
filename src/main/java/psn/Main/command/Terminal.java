package psn.Main.command;

import psn.Main.Out.LogWin_l;
import psn.Util.Function.General.Function;
import psn.Util.Keyword.Test;

@Test
public class Terminal {
	// <log "Text">./func<
	//                    <move(up 2),(left 4)>
	//                    <send.log("Log")>
	//                   >
	// log="Text"./func::move{(up 2),(left 4)},send.log("Log")
	public static void use_terminal(String msg) {
		String[] subject = msg.split("./func::");
		process_terminal(subject);
	}

	private static void process_terminal(String[] msg) {
		String[] BF = new String[]{msg[0]};//Before function
		String[] function = Function.remove_selected_array(msg,0);
		LOG(function);
	}

	private static void LOG(String[] msg) {
		Function.print_all_arrays(msg);
//		LogWin_l.out(msg);
	}
}
