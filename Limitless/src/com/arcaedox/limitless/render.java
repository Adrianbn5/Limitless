package com.arcaedox.limitless;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class render implements GLEventListener{
	
	private double theta = 0;
    private double s = 0;
    private double c = 0;
    private GL2 gl;

	@Override
	public void display(GLAutoDrawable drawable) {
		update();
		setDrawable(drawable);
	    renderer(gl);
	}
	
	private void setDrawable(GLAutoDrawable drawable) {
		this.gl = drawable.getGL().getGL2();
		
	}

	private void renderer(GL2 gl) {
			
	        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

	        // draw a triangle filling the window
	        gl.glBegin(GL.GL_TRIANGLES);
	        gl.glColor3f(1, 0, 0);
	        gl.glVertex2d(-c, -c);
	        gl.glColor3f(0, 1, 0);
	        gl.glVertex2d(0, c);
	        gl.glColor3f(0, 0, 1);
	        gl.glVertex2d(s, -s);
	        gl.glEnd();
	}

	private void update() {
		theta += 0.0005;
      s = Math.sin(theta);
      c = Math.cos(theta);
		
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {}

	@Override
	public void init(GLAutoDrawable arg0) {
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int width,
			int height) {
		System.out.println("Width: \t"+ width + "\nHeight: " + height);
		
	}

}
