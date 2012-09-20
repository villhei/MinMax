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
	static char[][] grid3 = {
		{'X', 'X', 'X'},
		{' ', ' ', ' '},
		{' ', ' ', ' '}
	};
	static char[][] grid4 = {
		{' ', ' ', ' '},
		{' ', ' ', ' '},
		{'O', 'O', 'O'}
	};
	static char[][] grid5 = {
		{' ', ' ', 'X'},
		{' ', ' ', 'X'},
		{' ', ' ', 'X'}
	};
	static char[][] grid6 = {
		{' ', ' ', 'O'},
		{' ', 'O', ' '},
		{'O', ' ', ' '}
	};
	static char[][] grid7 = {
		{' ', ' ', 'O'},
		{' ', ' ', 'O'},
		{' ', ' ', 'O'}
	};



	public static void main(String[] args) {
		
		Game game = new Game(grid);
		System.out.println("Board value: "+ game.assignValue(game.game_board));
		game.buildGameTree();
		game.playGame();
		System.out.println("shit.");
		
		Game game2 = new Game(grid2);
		Game game3 = new Game(grid3);
		Game game4 = new Game(grid4);
		Game game5 = new Game(grid5);
		Game game6 = new Game(grid6);
		Game game7 = new Game(grid7);
		System.out.println("Board2 value: "+ game2.assignValue(game2.game_board));
		System.out.println("Board3 value: "+ game3.assignValue(game3.game_board));
		System.out.println("Board4 value: "+ game4.assignValue(game4.game_board));
		System.out.println("Board5 value: "+ game5.assignValue(game5.game_board));
		System.out.println("Board6 value: "+ game6.assignValue(game6.game_board));
		System.out.println("Board7 value: "+ game6.assignValue(game7.game_board));
		


	}
}
