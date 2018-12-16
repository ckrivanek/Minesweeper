package project;

import java.awt.Color; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlackandWhiteGrid extends Minesweeper{
	public BlackandWhiteGrid() {
		try {
			flag = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\wflagfin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bomb = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\bwbombfin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		click=new Color(245,245,245);
		unclicked=new Color(100,100,100);
		numbers[0]=Color.BLACK;
		numbers[1]=Color.BLACK;
		numbers[2]=Color.BLACK;
		numbers[3]=Color.BLACK;
		numbers[4]=Color.BLACK;
		numbers[5]=Color.BLACK;
		numbers[6]=Color.BLACK;
		numbers[7]=Color.BLACK;
	}
}
