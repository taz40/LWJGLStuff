package PiWalker.com.lwjgl;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class PhysicsObject {
	
	float x, y, width, height;
	int fps, ups;
	float forceTimer = .1f;
	float mass = 10;
	float v=0;
	long lastUpdate = System.nanoTime();
	
	public PhysicsObject(float x, float y, float width, float height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void render(){
		glBegin(GL_QUADS);
     		glVertex2f(x,y);
     		glVertex2f(x+width, y);
     		glVertex2f(x+width,y+height);
     		glVertex2f(x,y+height);
     	glEnd();
	}
	
	public void update(){
		float deltaTime = ((float)System.nanoTime() - (float)(lastUpdate))/1000000000f;
		float gravityForce = -9.8f * mass;
		float netForce = gravityForce;
		if(forceTimer > 0){
			netForce += 1000;
			forceTimer -= deltaTime;
		}
		float a = netForce/mass;
		System.out.println(y);
		float newY = ((a/2)*deltaTime*deltaTime)+(v*deltaTime)+y;
		float newV = (a*deltaTime)+v;
		y = newY;
		v = newV;
		lastUpdate = System.nanoTime();
	}
	
	
}
