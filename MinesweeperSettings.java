package project;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class MinesweeperSettings {
	public static int size;
	public static boolean choose = false;
	public static Minesweeper m = null;
	public static void chooseSettings() {
		//Makes a window and user interface components
		JFrame window = new JFrame("Settings");
		Panel pnl = new Panel();
		Choice theme = new Choice();
		Choice difficulty = new Choice();
		Button start = new Button("Start");
		Label themeLabel= new Label("Theme:                    ");
		Label dificultyLabel = new Label("Size:");
		
		//Adds function to clicking the start button
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//changes class of minesweeper game to one selected
				if(theme.getSelectedItem()=="Standard") {
					m = new StandardGrid();
				}
				else if(theme.getSelectedItem()== "Tropical") {
					m = new TropicalGrid();
				}
				else if(theme.getSelectedItem()=="Grass") {
					m = new GrassGrid();
				}
				else if(theme.getSelectedItem()=="Ocean") {
					m = new OceanGrid();
				}
				else {
					m= new BlackandWhiteGrid();
				}
				
				//changes size of grid
				if(difficulty.getSelectedItem()== "Small") {
					size = 15;
				}
				else if(difficulty.getSelectedItem()=="Medium") {
					size = 20;
				}
				else {
					size = 25;
				}
				choose = true;
			}
		});
		
		//Adds user interface components to panels and window
		difficulty.add("Small");
		difficulty.add("Medium");
		difficulty.add("Large");
		theme.add("Standard");
		theme.add("Tropical");
		theme.add("Grass");
		theme.add("Ocean");
		theme.add("Black and White");
		pnl.add(themeLabel);
		pnl.add(dificultyLabel);
		pnl.add(theme);
		pnl.add(difficulty);
		pnl.add (start);
		window.add(pnl);
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		SwingUtilities.updateComponentTreeUI(window);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        window.setBounds(0, 0, 250, 150 );
        window.setLocation((int) (dimension.getWidth() / 2 - 250 / 2),
                (int) (dimension.getHeight() / 2 - 150 / 2));
		window.setVisible(true);
		window.setResizable(false);
		while(choose == false) {
			Minesweeper.t.start();
			Minesweeper.t.stop();
		}
		window.setVisible(false);
		window.dispose();
	}
	private MinesweeperSettings() {};
}
