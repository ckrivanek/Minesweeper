package project;

import java.awt.Color; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TropicalGrid extends Minesweeper{
	public TropicalGrid() {
		try {
			flag = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\palmtree.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bomb = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\coconutfin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		click=new Color(100,100,255);
		unclicked=new Color(216,210,150);
		numbers[0]= Color.WHITE;
		numbers[1]=Color.cyan;
		numbers[2]=new Color(60, 100, 100);
		numbers[3]=Color.BLACK;
		numbers[4]=new Color(100,100,10);
		numbers[5]=new Color(200,10,10);
		numbers[6]=new Color(130,50,20);
		numbers[7]=new Color(75,75,75);
	}
	/*
	@Override
	public void paintComponent(Graphics g) {
		//Starting Grid implement themes
				clickCount=0;
				for (int i = 0; i < MinesweeperSettings.size; i++ ) {
					for(int k = 0; k < MinesweeperSettings.size; k++) {	
						if(grid[i][k].clicked) {
							g.setColor(new Color(100,100,255));
							clickCount++;
						}
						else{
							g.setColor(new Color(216,210,150));
						}
						g.fillRect(i*25, k*25, 25, 25);
						g.setColor(Color.BLACK);
						g.drawRect(i*25, k*25, 25, 25);
						if(grid[i][k].flagged) {
							if(grid[i][k].flagged) {
								try {
									flag = ImageIO.read(new File("C:\\Users\\ckriv\\OneDrive\\Documents\\oopfinalproject\\images\\palmtree.png"));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								g.drawImage(flag ,i*25 ,k*25,25,25 ,null );
							}
						}
						if(grid[i][k].numofBombs!=0 && grid[i][k].clicked) {	
							if(grid[i][k].numofBombs==1) {
								g.setColor(Color.RED);
							}
							else if(grid[i][k].numofBombs==2) {
								g.setColor(new Color(0,190,220));
							}
							else if(grid[i][k].numofBombs==3) {
								g.setColor(new Color(0,200,10));
							}
							else if(grid[i][k].numofBombs==4) {
								g.setColor(Color.YELLOW);
							}
							else if(grid[i][k].numofBombs==5) {
								g.setColor(Color.ORANGE);
							}
							else if(grid[i][k].numofBombs==6) {
								g.setColor(Color.RED);
							}
							else if(grid[i][k].numofBombs==7) {
								g.setColor(Color.DARK_GRAY);
							}
							else if(grid[i][k].numofBombs==8) {
								g.setColor(new Color(0,0,0));
							}
							g.drawString(String.valueOf(grid[i][k].numofBombs), i*25+8, k*25+16);
						}
					}
				}
				g.drawString("There are "+ count+ " bombs"+ "        Score = " + clickCount, 0, (MinesweeperSettings.size*25)+13 );
			}
		*/
	}
