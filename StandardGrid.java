package project;

import java.awt.Color; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StandardGrid extends Minesweeper {
	public StandardGrid() {
		try {
			flag = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\flagfin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bomb = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\bombfin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		click=new Color(240,240,240);
		unclicked=new Color(200,200,200);
		numbers[0]= Color.BLUE;
		numbers[1]=new Color(10,100,200);
		numbers[2]=new Color(10, 200, 100);
		numbers[3]=new Color(100,200,10);
		numbers[4]=new Color(200,100,10);
		numbers[5]=new Color(200,10,10);
		numbers[6]=new Color(130,50,20);
		numbers[7]=new Color(75,75,75);
	}
}
