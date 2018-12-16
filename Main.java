package project;

public class Main {
	public static void main(String[] args) {
			MinesweeperSettings.chooseSettings();
			Minesweeper.make(MinesweeperSettings.m);
	}
}
