package com.arcaedox.limitless;

import javax.media.opengl.*;

import com.jogamp.newt.event.KeyAdapter;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.Animator;

public class Window {
	
	private String title = "Limitless";
	private Boolean AlwaysThere = true, FullSC = false; 
	private int width = 400 , height = 400;
	private GLWindow window;
	
	public Window() {
	
		GLProfile glp = GLProfile.getDefault();
	    GLCapabilities caps = new GLCapabilities(glp);
	    window = GLWindow.create(caps);
	        
	    window.setSize(width, height);
	    window.setVisible(true);
	    window.setTitle(title);
	    window.setAlwaysOnTop(AlwaysThere);
	    window.setFullscreen(FullSC);
	        
	    window.addWindowListener(new WindowAdapter() {
	    	public void windowDestroyNotify(WindowEvent arg0) {
	    		System.exit(0);
	        };
	    });
	    
	    window.addGLEventListener(new render());
	    
	    /*----------------- KEY LISTENER HERE! -----------------------*/
	    window.addKeyListener(new KeyAdapter(){
	    	
	    	public void keyPressed(KeyEvent e) {
		        int kc = e.getKeyCode();

		        switch (kc) {
		        
	            case KeyEvent.VK_UP:  
	            	System.out.println("UP!");
	            	setTitle("We go up!");
	                break;
	                
	            case KeyEvent.VK_DOWN: 
	        	   System.out.println("Down!");
	        	   setTitle("We go down!");
	               break;
	               
	            case KeyEvent.VK_LEFT:  
	            	System.out.println("Left!");
	            	setTitle("We go left!");
	                break;
	                     
	            case KeyEvent.VK_RIGHT:
	            	System.out.println("RIGHT!");
	            	setTitle("We go right!");
	                break;
	                     
	            case KeyEvent.VK_ESCAPE:
	            	System.out.println("Menu comes up!");
	            	setTitle("We go right!");
	                break;
	                
	            case KeyEvent.VK_F:
	            	if (window.isFullscreen() == false){
	            		setFS(true);
	            	}else{
	            		setFS(false);
	            	}
		        }
	    	}
	    });
	    /*----------------- KEY LISTENER HERE! -----------------------*/
	        
	    Animator animator = new Animator(window);
	    animator.start();
	
	}
	
	public void setTitle(String title){
		this.title = title;
		this.window.setTitle(title);
	}
	
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void setOntop(Boolean is) {
		this.AlwaysThere = is;
	}
	
	public void setFS(Boolean yorn){
		this.FullSC = yorn;
		this.window.setFullscreen(FullSC);
	}
	
}
