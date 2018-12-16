package project;

import java.awt.Color; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OceanGrid extends Minesweeper{
	public OceanGrid() {
		try {
			flag = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\sharkfin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bomb = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\minefin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		click=new Color(120,120,200);
		unclicked=new Color(50,50,200);
		numbers[0]= Color.WHITE;
		numbers[1]=Color.cyan;
		numbers[2]=new Color(60, 100, 100);
		numbers[3]=Color.BLACK;
		numbers[4]=new Color(100,100,10);
		numbers[5]=new Color(200,10,10);
		numbers[6]=new Color(130,50,20);
		numbers[7]=new Color(75,75,75);
	}
}
