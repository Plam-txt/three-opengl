package psn.Main.Core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;

import psn.Main.Main;
import psn.Main.Window.WindowManager;
import psn.Util.Variable;

public class Runner {
	public static final long NANOSECOND = Variable.NANOSECOND;
	public static final float FRAMERATE = Variable.FRAMERATE;
	private static int fps;
	private static float frametime = 1.0f/FRAMERATE;
	private boolean isRunning;
	private WindowManager window;

	private GLFWErrorCallback errorCallback;
	private void init() throws Exception{
		GLFW.glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));
		window = Main.getWindow();
		WindowManager.init();
	}

	public void start() throws Exception{
		init();
		if(isRunning){
			return;
		}
	}

	public void run() {
		this.isRunning = true;
		int frames = 0;
		long frameCounter = 0;
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		while (isRunning) {
			boolean render = false;
			long start = System.nanoTime();
			long passed = start - lastTime;
			lastTime = start;
			unprocessed += passed / (double) NANOSECOND;
			frameCounter += passed;
			input();
			while (unprocessed >= frametime) {
				render = true;
				unprocessed -= frametime;
				if (window.shouldClose()) {
					stop();
				} if (frameCounter >= NANOSECOND) {
					setFps(frames);
					frames = 0;
					frameCounter = 0;
				}
			} if (render) {
				update();   // poll events + clear + swap buffers
				render();
				frames++;
			} else {try { Thread.sleep(1); } catch (InterruptedException ignored) {} }
		}
		cleanup();
	}

	private void stop(){
		if(!isRunning){
			return;
		}
		isRunning = false;
	}
	private void input(){}
	private void render(){}
	private void update(){
		window.update();
	}
	private void cleanup(){
		window.cleanup();
		errorCallback.free();
		GLFW.glfwTerminate();
	}
	public static int getFps() {
		return fps;
	}
	public static void setFps(int fps) {
		Runner.fps = fps;
	}
}
