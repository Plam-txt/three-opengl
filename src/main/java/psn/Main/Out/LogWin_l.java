package psn.Main.Out;

import psn.Util.Keyword.Test;

import static psn.Main.Window.LoggingWindow.textArea;

public class LogWin_l {
	@Test public static void out(String msg){
		textArea.append(msg);
	}
}
