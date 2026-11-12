package psn.Main;

public record Settings() {
///default
	public static int FULL_WIDTH = 1980;
	public static int FULL_HEIGHT = 1080;

/// OpenGl
	public static int WM_size_w = 800;
	public static int WM_size_h = 600;
	public static String WM_Title = "OpenGL Window";
	public static String WM_ico_path = "src/main/resources/textures/icon/renderer_window_ico.png";

/// TerminalWindow
	public static int TW_size_w = 640;
	public static int TW_size_h = 480;
	public static String TW_Title = "Terminal Window";
	public static String TW_ico_path = "src/main/resources/textures/icon/Window_manager_ico.png";

/// LoggingWindow
	public static int LW_size_w = 640;
	public static int LW_size_h = 480;
	public static String LW_Title = "Log Window";
	public static String LW_ico_path = "src/main/resources/textures/icon/Logging_window_ico.png";

}
