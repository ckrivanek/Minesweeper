package project;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

//Abstract class so no simple Minesweeper object instance can be made and its methods become dependent on its subclass' properties
public abstract class Minesweeper extends JComponent implements ActionListener, MouseListener, MouseMotionListener{
	//Minesweeper properties
	Color [] numbers = new Color[8];
	Color click, unclicked;
	protected int mouseX, mouseY, squarex, squarey, turns=0;
	protected static int bombCount =0, score=0;
	protected Tile[][] grid = new Tile[30][30];
	private static boolean end = false,won=false;
	protected static Timer t = new Timer(5, null);
	protected BufferedImage flag = null,bomb = null;
	
	//Sets up the window and game and starts a loop that ends when the game is over and then displays result
	public static final void make(Minesweeper game) {
		//Sets up the window
		JFrame window = new JFrame("Minesweeper by Cameron Krivanek");
		window.add(game);
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(0, 0, (25*MinesweeperSettings.size)+20, (25*MinesweeperSettings.size)+58 );
        window.setLocationRelativeTo(null);		
		window.setVisible(true);
		window.setResizable(false);
		window.addMouseMotionListener(game);
		window.addMouseListener(game);
		game.generate();
		//loop with timer that ends when the games end, then method moves on to execute other code
		do {
			t.start();
			t.stop();
		}
		while (!Minesweeper.end);
		window.setBounds(0, 0, (25*MinesweeperSettings.size)+20, (26*MinesweeperSettings.size)+58 );
		window.setLocationRelativeTo(null);
		window.setIgnoreRepaint(true);
	}

	//Generates the grid of Tiles and randomly assigns bombs
	public void generate() {
		//small ~38, medium ~67, large ~104 bombs
		for (int i = 0; i < MinesweeperSettings.size; i++ ) {
			for(int k = 0; k < MinesweeperSettings.size; k++) {
				//creates tiles
				grid[i][k] = new Tile();
				grid[i][k].x = i;
				grid[i][k].y = k;
				
				//Randomly decides whether tile is bomb or not
				int prob = (int) (Math.random()* 6);
				if (prob == 1) {
					grid[i][k].isBomb = true;
					bombCount++;
				}
			}
		}
		for (int i = 0; i < MinesweeperSettings.size; i++ ) {
			for(int k = 0; k < MinesweeperSettings.size; k++) {
				//find numOfBombs and checks to see if it on the edge
				int bombCount = 0;
				int leasty=k, maxy= k, leastx=i, maxx= i;
				if(i != 0) {
					leastx = i-1;
				}
				if(i != MinesweeperSettings.size-1) {
					maxx = i + 1;
				}
				if(k != 0) {
					leasty = k-1;
				}
				if(k != MinesweeperSettings.size-1) {
					maxy = k + 1;
				}
				for(int j = leastx; j <= maxx; j++) {
					for (int l = leasty; l<= maxy; l++) {
						if(grid[j][l].isBomb) {
							bombCount++;
						}
					}
				}
				grid[i][k].numofBombs= bombCount;
			}
		}
	} 
	
	//Makes the graphics
	protected void paintComponent(Graphics g) {
		//Sets score to zero 
		score=0;
		for (int i = 0; i < MinesweeperSettings.size; i++ ) {
			for(int k = 0; k < MinesweeperSettings.size; k++) {	
				if(grid[i][k].clicked) {
					g.setColor(click);
					score++;
				}
				else{
					g.setColor(unclicked);
				}
				g.fillRect(i*25, k*25, 25, 25);
				g.setColor(Color.BLACK);
				g.drawRect(i*25, k*25, 25, 25);
				if(grid[i][k].clicked ==true && grid[i][k].isBomb==true) {
					Timer longer = new Timer(1000,null);
					longer.setInitialDelay(1000);
					longer.start();
					g.drawImage(bomb, i*25+2 ,k*25+1,22,22 ,null );
				}
				if(grid[i][k].flagged && !grid[i][k].clicked) {
					g.drawImage(flag ,i*25 ,k*25+4,22,22 ,null );
				}
				if(grid[i][k].numofBombs!=0 && grid[i][k].clicked&& !grid[i][k].isBomb) {	
					if(grid[i][k].numofBombs==1) {
						g.setColor(numbers[0]);
					}
					else if(grid[i][k].numofBombs==2) {
						g.setColor(numbers[1]);
					}
					else if(grid[i][k].numofBombs==3) {
						g.setColor(numbers[2]);
					}
					else if(grid[i][k].numofBombs==4) {
						g.setColor(numbers[3]);
					}
					else if(grid[i][k].numofBombs==5) {
						g.setColor(numbers[4]);
					}
					else if(grid[i][k].numofBombs==6) {
						g.setColor(numbers[5]);
					}
					else if(grid[i][k].numofBombs==7) {
						g.setColor(numbers[6]);
					}
					else if(grid[i][k].numofBombs==8) {
						g.setColor(numbers[7]);
					}
					g.drawString(String.valueOf(grid[i][k].numofBombs), i*25+8, k*25+16);
				}
			}
		}
		//Prints bomb total and score at the bottom
		g.drawString("There are "+ bombCount+ " bombs", 0, (MinesweeperSettings.size*25)+13 );
		g.drawString("Score = " + score, (25*MinesweeperSettings.size)-70, (MinesweeperSettings.size*25)+13 );
		
		//Prints result of game when ended
		if(Minesweeper.end && !Minesweeper.won) {
			g.setColor(Color.RED);
			g.drawString("You Failed",((25*MinesweeperSettings.size)+20)/2-30, (25*MinesweeperSettings.size)+30);
		}
		if((bombCount+score)== (MinesweeperSettings.size*MinesweeperSettings.size)) {
			g.setColor(Color.GREEN);
			g.drawString("You Won!!!",((25*MinesweeperSettings.size)+20)/2-30, (25*MinesweeperSettings.size)+30);
			Minesweeper.won=true;
			Minesweeper.end=true;
		}
	}

	/* Checks to see if the click was a right or left click and then if it is a right click then 
	 * if it is right then it will make a flag and if it was left then it will check to see if there
	 * is a bomb. If there is a bomb then it sets the boolean end to true
	 * which ends the program. If there isn't a bomb then it sets the boolean clicked to true which
	 * will make the tile change color as the window is repainted
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(mouseX<=(26*MinesweeperSettings.size) && mouseY<=(25*(MinesweeperSettings.size+2)) && !Minesweeper.end) {
			if (arg0.getButton() == MouseEvent.BUTTON3){
				if(grid[squarex][squarey].flagged) {
					grid[squarex][squarey].flagged=false;
				}
				else {
					grid[squarex][squarey].flagged=true;
				}
			}
			else {
				if (grid[squarex][squarey].isBomb== true) {
					grid[squarex][squarey].clicked=true;
					repaint();
					Minesweeper.end = true;
				}
				else {
					if(grid[squarex][squarey].clicked== false) {
						grid[squarex][squarey].clicked=true;
						if(grid[squarex][squarey].numofBombs==0) {
							grid[squarex][squarey].click(grid,grid[squarex][squarey]);
						}
					}
				}
			}
			repaint();
		}
	}
	
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//Gets coordinates of mouse
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		squarex= (mouseX-8)/25;
		squarey= (mouseY-33)/25;
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
