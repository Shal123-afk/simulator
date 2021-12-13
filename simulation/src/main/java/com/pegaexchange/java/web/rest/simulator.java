package com.pegaexchange.java.web.rest;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/simulator")
public class simulator extends JFrame {

	private JPanel planePanel;
	private static final int ZOOM = 4;

	
	public simulator( final boolean[][] plane){
		planePanel = new JPanel(){
			
			@Override
			@PUT
			@Path("/paint")
			@Consumes(MediaType.APPLICATION_XML)
			@Produces(MediaType.APPLICATION_JSON)
			public void paint(Graphics g){
				for(int y = 0; y < plane.length;y++){
					for(int x = 0; x < plane[0].length;x++){
						g.setColor(plane[y][x] ? Color.BLACK : Color.WHITE);
						g.fillRect(x * ZOOM, y * ZOOM, ZOOM, ZOOM);
					}
				}
				//mark the starting point
				g.setColor(Color.GREEN);
				g.fillRect(plane[0].length / 2 * ZOOM,
				           plane.length / 2 * ZOOM, ZOOM/2, ZOOM/2);
			}
		};
		planePanel.setSize(plane[0].length - 1, plane.length - 1);
		add(planePanel);
		setSize(ZOOM * plane[0].length, ZOOM * plane.length + 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

 
 @GET
 @Path("/runmachine")
 @Consumes(MediaType.APPLICATION_XML)
 @Produces(MediaType.APPLICATION_JSON)
 
	public static void main(String[] args){
		new simulator( runmachine(100, 100));
	}

	private static boolean[][] runmachine( int height, int width){
		boolean[][] plane = new boolean[height][width];
		int machineX = width/2, machineY = height/2;//start in the middle
		int xChange = 0, yChange = -1; //start moving up
		while(machineX < width && machineY < height && machineX >= 0 && machineY >= 0){
			if(plane[machineY][machineX]){
				//turn left
				if(xChange == 0){ //if moving up or down
					xChange = yChange;
					yChange = 0;
				}else{ //if moving left or right
					yChange = -xChange;
					xChange = 0;
				}
			}else{
				//turn right
				if(xChange == 0){ //if moving up or down
					xChange = -yChange;
					yChange = 0;
				}else{ //if moving left or right
					yChange = xChange;
					xChange = 0;
				}
			}
			plane[machineY][machineX] = !plane[machineY][machineX];
			machineX += xChange;
			machineY += yChange;
		}
		return plane;
	}
}