package com.arcaedox.limitless;

import javax.media.opengl.*;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import java.lang.System;
 
public class HelloWorld 
{
    public static void main(String[] args) 
    {
    	 System.setProperty("jnlp.newt.window.icons", "img\\icon.png img\\icon.png");
    	 GLProfile glp = GLProfile.getDefault();
         GLCapabilities caps = new GLCapabilities(glp);
         
         GLWindow window = GLWindow.create(caps);
         window.setSize(300, 300);
         window.setVisible(true);
         window.setTitle("Limitless");

         window.addWindowListener(new WindowAdapter() {
             public void windowDestroyNotify(WindowEvent arg0) {
                 System.exit();
             };
         });
    }
}