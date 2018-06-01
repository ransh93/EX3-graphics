package edu.cg.models;

import com.jogamp.opengl.*;

/**
 * A simple axes dummy 
 *
 */
public class Empty implements IRenderable {	
	
	private boolean isLightSpheres;
	
	public void render(GL2 gl) {
		        this.drawRGBCube(gl);
	}
	
	 private void drawRGBCube(GL2 gl) {
	        double r = 0.5D;
	        boolean lightingFlag = gl.glIsEnabled(2896);
	        gl.glDisable(2896);
	        gl.glBegin(7);
	        gl.glColor3d(0.0D, 0.0D, 1.0D);
	        gl.glVertex3d(-r, -r, r);
	        gl.glColor3d(1.0D, 0.0D, 1.0D);
	        gl.glVertex3d(r, -r, r);
	        gl.glColor3d(1.0D, 1.0D, 1.0D);
	        gl.glVertex3d(r, r, r);
	        gl.glColor3d(0.0D, 1.0D, 1.0D);
	        gl.glVertex3d(-r, r, r);
	        gl.glColor3d(0.0D, 0.0D, 0.0D);
	        gl.glVertex3d(-r, -r, -r);
	        gl.glColor3d(0.0D, 0.0D, 1.0D);
	        gl.glVertex3d(-r, -r, r);
	        gl.glColor3d(0.0D, 1.0D, 1.0D);
	        gl.glVertex3d(-r, r, r);
	        gl.glColor3d(0.0D, 1.0D, 0.0D);
	        gl.glVertex3d(-r, r, -r);
	        gl.glColor3d(1.0D, 0.0D, 1.0D);
	        gl.glVertex3d(r, -r, r);
	        gl.glColor3d(1.0D, 0.0D, 0.0D);
	        gl.glVertex3d(r, -r, -r);
	        gl.glColor3d(1.0D, 1.0D, 0.0D);
	        gl.glVertex3d(r, r, -r);
	        gl.glColor3d(1.0D, 1.0D, 1.0D);
	        gl.glVertex3d(r, r, r);
	        gl.glColor3d(1.0D, 1.0D, 0.0D);
	        gl.glVertex3d(r, r, -r);
	        gl.glColor3d(1.0D, 0.0D, 0.0D);
	        gl.glVertex3d(r, -r, -r);
	        gl.glColor3d(0.0D, 0.0D, 0.0D);
	        gl.glVertex3d(-r, -r, -r);
	        gl.glColor3d(0.0D, 1.0D, 0.0D);
	        gl.glVertex3d(-r, r, -r);
	        gl.glColor3d(0.0D, 1.0D, 1.0D);
	        gl.glVertex3d(-r, r, r);
	        gl.glColor3d(1.0D, 1.0D, 1.0D);
	        gl.glVertex3d(r, r, r);
	        gl.glColor3d(1.0D, 1.0D, 0.0D);
	        gl.glVertex3d(r, r, -r);
	        gl.glColor3d(0.0D, 1.0D, 0.0D);
	        gl.glVertex3d(-r, r, -r);
	        gl.glColor3d(0.0D, 0.0D, 0.0D);
	        gl.glVertex3d(-r, -r, -r);
	        gl.glColor3d(1.0D, 0.0D, 0.0D);
	        gl.glVertex3d(r, -r, -r);
	        gl.glColor3d(1.0D, 0.0D, 1.0D);
	        gl.glVertex3d(r, -r, r);
	        gl.glColor3d(0.0D, 0.0D, 1.0D);
	        gl.glVertex3d(-r, -r, r);
	        gl.glEnd();
	        if (lightingFlag) {
	            gl.glEnable(2896);
	        }

	    }
	

	@Override
	public String toString() {
		return "Empty";
	}


	//If your scene requires more control (like keyboard events), you can define it here.
	@Override
	public void control(int type, Object params) {
		switch (type) {
		case IRenderable.TOGGLE_LIGHT_SPHERES:
		{
			isLightSpheres = ! isLightSpheres;
			break;
		}
		default:
			System.out.println("Control type not supported: " + toString() + ", " + type);
		}
	}
	
	@Override
	public boolean isAnimated() {
		return false;
	}

	@Override
	public void init(GL2 gl) {
		
	}

	@Override
	public void setCamera(GL2 gl) {
		
	}
}
