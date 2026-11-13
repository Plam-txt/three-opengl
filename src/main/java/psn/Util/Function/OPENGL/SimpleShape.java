package psn.Util.Function.OPENGL;

import org.lwjgl.opengl.GL11;
import psn.Util.Keyword.Test;

@Test
public class SimpleShape {
	public static void RECTANGLE(float x, float y, float width, float height) {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + width, y);
		GL11.glVertex2f(x + width, y + height);
		GL11.glVertex2f(x, y + height);
		GL11.glEnd();
	}
}
