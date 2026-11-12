/*
|   
|	this only used for build a window
|
*/
package psn.Main.Window;

/// import
//self class
import psn.Main.Settings;
import psn.Util.Keyword.Risk;
//install library opengl
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
//native
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class WindowManager { /// as MW
	private static long window;
	@Risk public static void init() {
		GLFW.glfwDefaultWindowHints();
		// Initialize GLFW
		if (!GLFW.glfwInit()) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}
		// Configure window hints
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
		// Create the window
		long window = GLFW.glfwCreateWindow(
				Settings.WM_size_w, //width_size
				Settings.WM_size_h, //height_size
				Settings.WM_Title,  //title_name
				MemoryUtil.NULL, MemoryUtil.NULL);
		if (window == MemoryUtil.NULL) {
			throw new RuntimeException("Failed to create the GLFW window");
		}
		setWindowIcon(window,Settings.WM_ico_path);
		GLFW.glfwMakeContextCurrent(window);// Make the OpenGL context current
		GLFW.glfwSwapInterval(1);// Enable v-sync
		GLFW.glfwShowWindow(window);// Make the window visible
		GL.createCapabilities();// Crucial line: Links Java with the underlying system's OpenGL context
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);//need for black screen

		while (!GLFW.glfwWindowShouldClose(window)) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			// Swap the color buffers and poll events
			GLFW.glfwSwapBuffers(window);
			GLFW.glfwPollEvents();
		}// Main rendering loop

		GLFW.glfwDestroyWindow(window);// Free the window callbacks and destroy the window
		GLFW.glfwTerminate();
	}

	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(window);
	}
	public void update() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GLFW.glfwSwapBuffers(window);
		GLFW.glfwPollEvents();
	}
	public void cleanup() {
		GLFW.glfwDestroyWindow(window);
	}

	public static void setWindowIcon(long windowHandle, String imagePath) {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer width = stack.mallocInt(1);
			IntBuffer height = stack.mallocInt(1);
			IntBuffer channels = stack.mallocInt(1);
			ByteBuffer pixels = STBImage.stbi_load(imagePath, width, height, channels, 4);
			if (pixels == null) { throw new RuntimeException("unable to loaded icon: " + STBImage.stbi_failure_reason()); }
			try (GLFWImage.Buffer imageBuffer = GLFWImage.malloc(1)) {
				imageBuffer.get(0).set(width.get(0), height.get(0), pixels);
				GLFW.glfwSetWindowIcon(windowHandle, imageBuffer);             }
			STBImage.stbi_image_free(pixels);
		}
	}
}
