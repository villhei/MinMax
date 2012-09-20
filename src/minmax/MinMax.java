/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minmax;

public class MinMax {

	static char[][] grid = {
		{'O', 'X', ' '},
		{'O', ' ', 'X'},
		{'X', ' ', 'O'}
	};
	static char[][] grid2 = {
		{' ', ' ', ' '},
		{' ', ' ', ' '},
		{' ', ' ', ' '}
	};



	public static void main(String[] args) {
		
		Game game = new Game(grid);
		game.buildGameTree();
		game.playGame();
		System.out.println("shit.");
		
	//	Game game2 = new Game(grid2);
	//	game2.buildGameTree();
	//	game2.playGame();

	}
}
