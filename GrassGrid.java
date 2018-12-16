package project;

import java.awt.Color; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GrassGrid extends Minesweeper{
	public GrassGrid() {
		try {
			flag = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bomb = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\minefin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		click=new Color(139,69,19);
		unclicked=new Color(0,240,0);
		numbers[0]= Color.WHITE;
		numbers[1]=Color.cyan;
		numbers[2]=Color.GREEN;
		numbers[3]=Color.BLACK;
		numbers[4]=new Color(100,100,10);
		numbers[5]=new Color(200,10,10);
		numbers[6]=new Color(130,50,20);
		numbers[7]=new Color(75,75,75);
	}
}
