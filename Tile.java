package project;

public class Tile {
	boolean isBomb, clicked, flagged;
	int numofBombs, x, y;
	
	//Clicks tiles around the tile passed and checks if they have a bomb around it, if not then
	// it calls itself with that tile
	public void click(Tile[][] grid, Tile t) {
		t.clicked=true;
		
		//checks to see if more tiles should be clicked
		if(t.numofBombs==0) {
			//gets the correct least and max x and y coordinates with a check to see if it is on the edge
			int leasty=t.y, maxy= t.y, leastx=t.x, maxx= t.x;
			if(t.x != 0) {
				leastx = t.x-1;
			}
			if(t.x != MinesweeperSettings.size-1) {
				maxx = t.x + 1;
			}
			if(t.y != 0) {
				leasty = t.y-1;
			}
			if(t.y != MinesweeperSettings.size-1) {
				maxy = t.y + 1;
			}
			
			//clicks the surrounding tiles if they are not already clicked
			if(grid[leastx][t.y].clicked==false) {
				t.click(grid, grid[leastx][t.y]);
			}
			if(grid[maxx][t.y].clicked==false) {
				t.click(grid, grid[maxx][t.y]);
			}
			if(grid[t.x][leasty].clicked==false) {
				t.click(grid, grid[t.x][leasty]);
			}
			if(grid[t.x][maxy].clicked==false) {
				t.click(grid, grid[t.x][maxy]);
			}
			
			//Checks corner tiles
			/////////////////////////////////////////////
			if(grid[leastx][leasty].numofBombs!=0) {
				grid[leastx][leasty].clicked=true;
			}
			else if(grid[leastx][leasty].clicked==false) {
				click(grid,grid[leastx][leasty]);
			}
			////////////////////////////////////////////
			if(grid[leastx][maxy].numofBombs!=0) {
				grid[leastx][maxy].clicked=true;
			}
			else if(grid[leastx][maxy].clicked==false) {
				click(grid,grid[leastx][maxy]);
			}
			////////////////////////////////////////////
			if(grid[maxx][leasty].numofBombs!=0) {
				grid[maxx][leasty].clicked=true;
			}
			else if(grid[maxx][leasty].clicked==false) {
				click(grid,grid[maxx][leasty]);
			}
			////////////////////////////////////////////
			if(grid[maxx][maxy].numofBombs!=0) {
				grid[maxx][maxy].clicked=true;
			}
			else if (grid[maxx][maxy].clicked==false) {
				click(grid,grid[maxx][maxy]);
			}
		}
	}
	
}
