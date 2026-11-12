package psn.Main;

import psn.Main.Core.Runner;
import psn.Main.Window.LoggingWindow;
import psn.Main.Window.TerminalWindow;
import psn.Main.Window.WindowManager;
import psn.Util.Keyword.Risk;

public class Main {
static WindowManager window;
public static TerminalWindow terminal;
static Runner runner =  new Runner();

@Risk
public static void main(String[] args) {
	System.out.println("< Program > : Program Started");
///spawn two window to used that window
	try {
		///run the terminal window
		Thread terminalThread = new Thread(() -> {
			try {
				//run the terminal window
				TerminalWindow.createWindow();
				System.out.println("< Program > : open Terminal Window");
			} catch (Exception e) { e.printStackTrace(); }
		});
		terminalThread.start();
		///run the logging window
		Thread loggingThread = new Thread(() -> {
			try {
				LoggingWindow.log_build();
				System.out.println("< Program > : open Logging Window");
			} catch (Exception e) { e.printStackTrace(); }
		});
		loggingThread.start();
		///run the render window
/*		Thread RendererThread = new Thread(() -> {
			try {
				runner.start();
				runner.run();
				System.out.println("< Program > : open Rendering Window");
			} catch (Exception e) { e.printStackTrace(); }
		});
		RendererThread.start(); */

	} catch (Exception e) { e.printStackTrace(); }
}
public static WindowManager getWindow() {
	return window;
}}
