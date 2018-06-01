//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.cg.models;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import edu.cg.algebra.Vec;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Locomotive implements IRenderable {
    private boolean isLightSpheres = true;
    private static final double EPS = 0.002D;
    private static final Vec black = new Vec();
    private static final Vec white = new Vec(1.0F);

    public Locomotive() {
    }

    public void render(GL2 gl) {
        gl.glTranslated(0.2D, 0.0D, 0.0D);
        gl.glLineWidth(4.0F);
        gl.glMaterialf(1028, 5633, 10.0F);
        float[] light0Pos = new float[]{0.6F, 0.4F, -0.6F, 1.0F};
        float[] light0Color = new float[]{1.0F, 1.0F, 0.5F, 1.0F};
        gl.glLightfv(16384, 4608, white.toGLColor());
        gl.glLightfv(16384, 4609, light0Color, 0);
        gl.glLightfv(16384, 4610, light0Color, 0);
        gl.glLightfv(16384, 4611, light0Pos, 0);
        gl.glEnable(16384);
        float[] light1Pos = new float[]{-1.0F, 0.3F, 0.6F, 1.0F};
        float[] light1Color = new float[]{1.0F, 1.0F, 1.0F, 1.0F};
        gl.glLightfv(16385, 4609, light1Color, 0);
        gl.glLightfv(16385, 4610, light1Color, 0);
        gl.glLightfv(16385, 4611, light1Pos, 0);
        gl.glEnable(16385);
        GLU glu = new GLU();
        GLUquadric quad = glu.gluNewQuadric();
        
        // what is this? im not sure we need the light, by the ex we need to use glColor
        if (this.isLightSpheres) {
            boolean lightFlag = gl.glIsEnabled(2896);
            gl.glDisable(2896);
            gl.glPushMatrix();
            gl.glTranslated((double)light0Pos[0], (double)light0Pos[1], (double)light0Pos[2]);
            gl.glColor4fv(light0Color, 0);
            glu.gluSphere(quad, 0.02D, 6, 3);
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glTranslated((double)light1Pos[0], (double)light1Pos[1], (double)light1Pos[2]);
            gl.glColor4fv(light1Color, 0);
            glu.gluSphere(quad, 0.02D, 6, 3);
            gl.glPopMatrix();
            if (lightFlag) {
                gl.glEnable(2896);
            }
        }

        this.drawChassis(gl);
        this.drawWheels(gl, glu, quad);
        //this.drawLights(gl, glu, quad);
        //this.drawRoof(gl, glu, quad);
        this.drawChimney(gl, glu, quad);
        glu.gluDeleteQuadric(quad);
    }

    private void drawChimney(GL2 gl, GLU glu, GLUquadric quad) {
        this.setMaterialChassis(gl);
        gl.glPushMatrix();
        gl.glTranslated(-0.55D, 0.0D, 0.0D);
        gl.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
        glu.gluCylinder(quad, 0.075D, 0.075D, 0.2D, 20, 1);
        gl.glTranslated(0.0D, 0.0D, 0.2D);
        gl.glPushMatrix();
        gl.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
        glu.gluDisk(quad, 0.0D, 0.1D, 20, 1);
        gl.glPopMatrix();
        glu.gluCylinder(quad, 0.1D, 0.1D, 0.1D, 20, 1);
        gl.glTranslated(0.0D, 0.0D, 0.1D);
        glu.gluDisk(quad, 0.0D, 0.1D, 20, 1);
        gl.glPopMatrix();
    }

    private void drawQuadZ(GL2 gl, double x1, double x2, double y1, double y2, double z) {
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3d(x1, y1, -z);
        gl.glVertex3d(x1, y1, z);
        gl.glVertex3d(x2, y2, z);
        gl.glVertex3d(x2, y2, -z);
        gl.glEnd();
    }

    private void setMaterialRoof(GL2 gl) {
        gl.glColor3fv(black.toGLColor());
        gl.glMaterialfv(1028, 4608, white.mult(0.1D).toGLColor());
        gl.glMaterialfv(1028, 4609, black.toGLColor());
        gl.glMaterialfv(1028, 4610, white.mult(0.7D).toGLColor());
        gl.glMaterialfv(1028, 5632, black.toGLColor());
    }

    private void setMaterialChassis(GL2 gl) {
        Vec diffuseCol = new Vec(1.0F, 0.039215688F, 0.0F);
        gl.glColor3fv(white.toGLColor());
        gl.glMaterialfv(1028, 4608, diffuseCol.mult(0.2D).toGLColor());
        gl.glMaterialfv(1028, 4609, diffuseCol.toGLColor());
        gl.glMaterialfv(1028, 4610, white.mult(0.7D).toGLColor());
        gl.glMaterialfv(1028, 5632, black.toGLColor());
    }

    private void setMaterialWindowOrDoor(GL2 gl) {
        Vec col = new Vec(0.1F, 0.1F, 0.2F);
        gl.glColor3fv(col.toGLColor());
        gl.glMaterialfv(1028, 4608, col.mult(0.2D).toGLColor());
        gl.glMaterialfv(1028, 4609, col.toGLColor());
        gl.glMaterialfv(1028, 4610, col.mult(0.7D).toGLColor());
        gl.glMaterialfv(1028, 5632, black.toGLColor());
    }

    private void setMaterialWheelOuter(GL2 gl) {
        Vec col = new Vec(0.3137255F, 0.19607843F, 0.078431375F);
        gl.glColor3fv(col.toGLColor());
        gl.glMaterialfv(gl.GL_FRONT, gl.GL_EMISSION, black.toGLColor());
        gl.glMaterialfv(gl.GL_FRONT, gl.GL_AMBIENT, col.mult(0.2D).toGLColor());
        gl.glMaterialfv(gl.GL_FRONT, gl.GL_DIFFUSE, col.toGLColor());
        gl.glMaterialfv(gl.GL_FRONT, gl.GL_SPECULAR, black.toGLColor());   
    }

    private void setMaterialWheelInner(GL2 gl) {
        Vec col = new Vec(0.5F, 0.1F, 0.05F);
        gl.glColor3fv(col.toGLColor());
        gl.glMaterialfv(1028, 4608, col.mult(0.2D).toGLColor());
        gl.glMaterialfv(1028, 4609, col.toGLColor());
        gl.glMaterialfv(1028, 4610, black.toGLColor());
        gl.glMaterialfv(1028, 5632, black.toGLColor());
    }

    private void setMaterialLightCase(GL2 gl) {
        Vec col = new Vec(0.2F, 0.2F, 0.2F);
        gl.glColor3fv(col.toGLColor());
        gl.glMaterialfv(1028, 4608, col.mult(0.2D).toGLColor());
        gl.glMaterialfv(1028, 4609, col.toGLColor());
        gl.glMaterialfv(1028, 4610, black.toGLColor());
        gl.glMaterialfv(1028, 5632, black.toGLColor());
    }

    private void setMaterialFrontLight(GL2 gl) {
        float[] col = new float[]{0.9F, 0.9F, 0.8F};
        gl.glColor3fv(col, 0);
        gl.glMaterialfv(1028, 4609, col, 0);
        gl.glMaterialfv(1028, 4610, black.toGLColor());
        gl.glMaterialfv(1028, 5632, col, 0);
    }

    private void drawChassis(GL2 gl) {
        this.setMaterialChassis(gl);
        gl.glNormal3f(0.0F, -1.0F, 0.0F);
        this.drawQuadZ(gl, 0.5D, -0.8D, -0.2D, -0.2D, 0.2D);
        gl.glNormal3f(0.0F, 1.0F, 0.0F);
        this.drawQuadZ(gl, -0.8D, -0.3D, 0.0D, 0.0D, 0.2D);
        this.drawQuadZ(gl, -0.3D, 0.5D, 0.2D, 0.2D, 0.2D);
        gl.glNormal3f(-1.0F, 0.0F, 0.0F);
        this.drawQuadZ(gl, -0.3D, -0.3D, 0.0D, 0.2D, 0.2D);
        this.drawQuadZ(gl, -0.8D, -0.8D, -0.2D, 0.0D, 0.2D);
        gl.glNormal3f(1.0F, 0.0F, 0.0F);
        this.drawQuadZ(gl, 0.5D, 0.5D, 0.2D, -0.2D, 0.2D);
        this.drawLeftSide(gl);
        this.drawRightSide(gl);
        this.drawFrontWindow(gl);
        this.drawBackWindow(gl);
    }

    private void drawRoof(GL2 gl, GLU glu, GLUquadric quad) {
        double l = 0.796D;
        this.setMaterialRoof(gl);
        gl.glPushMatrix();
        gl.glTranslated(-0.298D, 0.2D, 0.0D);
        gl.glScaled(1.0D, 0.25D, 1.0D);
        gl.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
        glu.gluCylinder(quad, 0.2D, 0.2D, 0.796D, 20, 1);
        gl.glTranslated(0.0D, 0.0D, 0.796D);
        glu.gluDisk(quad, 0.0D, 0.2D, 20, 1);
        gl.glTranslated(0.0D, 0.0D, -0.796D);
        gl.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
        glu.gluDisk(quad, 0.0D, 0.2D, 20, 1);
        gl.glPopMatrix();
    }

    private void drawWindowOrDoor(GL2 gl) {
        this.setMaterialWindowOrDoor(gl);
        gl.glNormal3d(0.0D, 0.0D, 1.0D);
        gl.glBegin(7);
        gl.glVertex3d(0.0D, 0.0D, 0.0D);
        gl.glVertex3d(0.1D, 0.0D, 0.0D);
        gl.glVertex3d(0.1D, 0.1D, 0.0D);
        gl.glVertex3d(0.0D, 0.1D, 0.0D);
        gl.glEnd();
    }

    private void drawLeftSide(GL2 gl) {
        this.drawLeftSideWithoutFrontWindow(gl);
        gl.glPushMatrix();
        gl.glTranslated(-0.2D, -0.05D, 0.202D);
        gl.glScaled(1.5D, 2.0D, 1.0D);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
    }

    private void drawLeftSideWithoutFrontWindow(GL2 gl) {
        this.setMaterialChassis(gl);
        gl.glNormal3d(0.0D, 0.0D, 1.0D);
        gl.glBegin(7);
        gl.glVertex3d(-0.8D, -0.2D, 0.2D);
        gl.glVertex3d(-0.3D, -0.2D, 0.2D);
        gl.glVertex3d(-0.3D, 0.0D, 0.2D);
        gl.glVertex3d(-0.8D, 0.0D, 0.2D);
        gl.glVertex3d(-0.3D, -0.2D, 0.2D);
        gl.glVertex3d(0.5D, -0.2D, 0.2D);
        gl.glVertex3d(0.5D, 0.2D, 0.2D);
        gl.glVertex3d(-0.3D, 0.2D, 0.2D);
        gl.glEnd();
        gl.glPushMatrix();
        gl.glScaled(1.5D, 2.0D, 1.0D);
        gl.glTranslated(-0.13333333333333333D, -0.025D, 0.202D);
        gl.glTranslated(0.16666666666666666D, 0.0D, 0.0D);
        this.drawWindowOrDoor(gl);
        gl.glTranslated(0.16666666666666666D, 0.0D, 0.0D);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
    }

    private void drawFrontWindow(GL2 gl) {
        gl.glPushMatrix();
        gl.glScaled(1.0D, 1.5D, 3.0D);
        gl.glTranslated(-0.302D, 0.0D, -0.05D);
        gl.glRotated(-90.0D, 0.0D, 1.0D, 0.0D);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
    }

    private void drawBackWindow(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslated(0.0D, -0.05D, 0.0D);
        gl.glScaled(1.0D, 2.0D, 3.0D);
        gl.glTranslated(0.502D, 0.0D, 0.05D);
        gl.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
    }

    private void drawRightSide(GL2 gl) {
        gl.glFrontFace(2304);
        gl.glScaled(1.0D, 1.0D, -1.0D);
        this.drawLeftSideWithoutFrontWindow(gl);
        gl.glPushMatrix();
        gl.glTranslated(-0.2D, -0.2D, 0.202D);
        gl.glScaled(1.5D, 3.5D, 1.0D);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
        gl.glScaled(1.0D, 1.0D, -1.0D);
        gl.glFrontFace(2305);
    }

    private void drawWheels(GL2 gl, GLU glu, GLUquadric quad) {
        gl.glPushMatrix();
        gl.glTranslated(-0.6D, -0.2D, 0.0D);
        this.drawWheelPair(gl, glu, quad);
        gl.glTranslated(0.8D, 0.0D, 0.0D);
        this.drawWheelPair(gl, glu, quad);
        gl.glPopMatrix();
    }

    private void drawWheelPair(GL2 gl, GLU glu, GLUquadric quad) {
        gl.glPushMatrix();
        gl.glTranslated(0.0D, 0.0D, -0.2D);
        this.drawWheel(gl, glu, quad);
        gl.glTranslated(0.0D, 0.0D, 0.4D);
        this.drawWheel(gl, glu, quad);
        gl.glTranslated(0.0D, 0.0D, -0.2D);
        gl.glPopMatrix();
    }

    private void drawWheel(GL2 gl, GLU glu, GLUquadric quad) {
        this.setMaterialWheelOuter(gl);
        gl.glTranslated(0.0D, 0.0D, -0.05D);
        glu.gluCylinder(quad, 0.125D, 0.125D, 0.1D, 20, 1);
        gl.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
        glu.gluDisk(quad, 0.08D, 0.125D, 20, 1);
        this.setMaterialWheelInner(gl);
        glu.gluDisk(quad, 0.0D, 0.08D, 20, 1);
        gl.glRotated(-180.0D, 1.0D, 0.0D, 0.0D);
        gl.glTranslated(0.0D, 0.0D, 0.1D);
        this.setMaterialWheelOuter(gl);
        glu.gluDisk(quad, 0.08D, 0.125D, 20, 1);
        this.setMaterialWheelInner(gl);
        glu.gluDisk(quad, 0.0D, 0.08D, 20, 1);
        gl.glTranslated(0.0D, 0.0D, -0.05D);
    }

    private void drawLights(GL2 gl, GLU glu, GLUquadric quad) {
        this.drawFrontLights(gl, glu, quad);
    }

    private void drawFrontLights(GL2 gl, GLU glu, GLUquadric quad) {
        gl.glPushMatrix();
        gl.glTranslated(-0.825D, -0.1D, 0.0D);
        gl.glTranslated(0.0D, 0.0D, -0.1D);
        this.drawFrontLight(gl, glu, quad);
        gl.glTranslated(0.0D, 0.0D, 0.2D);
        this.drawFrontLight(gl, glu, quad);
        gl.glPopMatrix();
    }

    private void drawFrontLight(GL2 gl, GLU glu, GLUquadric quad) {
        double r = 0.05D;
        gl.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
        this.setMaterialLightCase(gl);
        glu.gluCylinder(quad, 0.05D, 0.05D, 0.05D, 20, 1);
        this.setMaterialFrontLight(gl);
        gl.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
        glu.gluDisk(quad, 0.0D, 0.05D, 20, 1);
        gl.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
        gl.glRotated(-90.0D, 0.0D, 1.0D, 0.0D);
    }

    public String toString() {
        try {
            return new String(Base64.getDecoder().decode("QnVz"), "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            return "";
        }
    }

    public void control(int type, Object params) {
        switch(type) {
        case 0:
            this.isLightSpheres = !this.isLightSpheres;
            break;
        default:
            System.out.println("Control type not supported: " + this.toString() + ", " + type);
        }

    }

    public boolean isAnimated() {
        return false;
    }

    public void init(GL2 gl) {
    }

    public void setCamera(GL2 gl) {
    }
}
