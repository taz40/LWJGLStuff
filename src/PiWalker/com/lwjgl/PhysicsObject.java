package PiWalker.com.lwjgl;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class PhysicsObject {
	
	float x, y, width, height;
	int fps, ups;
	float forceTimer = .1f;
	float mass = 0.0585f;
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
		float deltaTime = (System.nanoTime() - (float)(lastUpdate))/1000000000f;
		lastUpdate = System.nanoTime();
		float gravityForce = -9.8f * mass;
		float netForce = gravityForce;
		if(forceTimer > 0){
			netForce += 218;
			forceTimer -= deltaTime;
		}
		System.out.println(v);
		float newY = ((netForce/(2*mass))*deltaTime*deltaTime)+(+v*deltaTime)+y;
		float newV = ((netForce/mass)*deltaTime)+v;
		y = newY;
		v = newV;
		
	}
	
	
}
