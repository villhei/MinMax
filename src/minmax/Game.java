/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minmax;

/**
 *
 * @author Ville Heikkinen
 */
public class Game {
	
	char[][] game_board;
	int turn;
	Tree turnTree;
	
	public Game(char[][] board) {
		this.game_board = board;
		this.turn = 1;
	}
	
	char getPlayer(int turn) {
		if (turn == 1) {
			return 'X';
		} else {
			return 'O';
		}
	}
	
	int changeTurn(int turn) {
		if (turn == 1) {
			return 0;
		} else {
			return 1;
		}
	}
	
	boolean isAiPlayer(char player) {
		return true;
	}
	
	void playGame() {
		while (isPlayableBoard(turnTree.getBoard())) {
			if (isAiPlayer(this.getPlayer(turn))) {
				printCurrentBoard();
				turnTree = getBestMove(turnTree, turn);
				System.out.println("");
				this.turn = changeTurn(turn);
			}
		}
	}
	
	void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	void printCurrentBoard() {
		printBoard(turnTree.getBoard());
	}
	
	void buildGameTree() {
		Tree tree = new Tree(game_board);
		printBoard(tree.getBoard());
		System.out.println("rakennan");
		this.turnTree = playPossibleMoves(tree, turn);
		tree.getTreeSize();
	}
	
	Tree playPossibleMoves(Tree node, int turn) {
		Tree mmTree = new Tree(node.getBoard());
		mmTree.setValue(assignValue(node.getBoard()));
		
		int len = game_board.length;
		char[][] temp_board = new char[len][len];
		
		
		for (int j = 0; j < game_board.length; ++j) {
			Tree child = null;
			for (int i = 0; i < game_board.length; i++) {
				if (node.getBoard()[j][i] == ' ') {
					System.arraycopy(node.getBoard(), 0, temp_board, 0, len);
					temp_board[j][i] = getPlayer(turn);
					
					child = new Tree(temp_board);
					int value = assignValue(temp_board);
					System.out.println("assigned value " + value);
					printBoard(temp_board);
					child.setValue(value);
					
					if (isPlayableBoard(temp_board) && value == 0) {
						System.out.println("is playable:");
						printBoard(temp_board);
						child.insertNode(playPossibleMoves(child, changeTurn(turn)));
					}
					System.out.println("value got: " + child.getValue());
					printBoard(temp_board);
					System.out.println("");
				}
			}
			if (child != null) {
				mmTree.insertNode(child);
				mmTree.updateValue();
			}
		}
		System.out.println("kävin täällä");
		return mmTree;
	}
	
	Tree getBestMove(Tree tree, int turn) {
		if (this.getPlayer(turn) == 'X') {
			return tree.maxNode();
		} else {
			return tree.minNode();
		}
		
	}
	
	boolean isPlayableBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == ' ') {
					return true;
				}
			}
		}
		return false;
	}
	
	int assignValue(char[][] board) {
		for (char[] row : board) {
			char tmp = row[0];
			for (int i = 0; i < row.length; ++i) {
				if (tmp != row[i] || tmp == ' ') {
					break;
				}
				if (i == row.length - 1) {
					if (tmp == 'X') {
						return 1;
					} else {
						return -1;
					}
				}
			}
		}
		for (int j = 0; j < board.length; ++j) {
			char tmp = board[j][0];
			for (int i = 0; i < board.length; ++i) {
				if (board[j][i] != tmp || tmp == ' ') {
					break;
				}
				if (i == board[j].length - 1) {
					if (tmp == 'X') {
						return 1;
					} else {
						return -1;
					}
				}
			}
		}
		char tmp = board[0][0];
		int len = board.length - 1;
		for (int j = 0; j < board.length; ++j) {
			if (board[j][j] != tmp || tmp == ' ') {
				break;
			}
			if (j == board[j].length - 1) {
				if (tmp == 'X') {
					return 1;
				} else {
					return -1;
				}
			}
		}
		tmp = board[len][0];
		for (int j = 0; j < board.length; ++j) {
			if (board[len - j][j] != tmp || tmp == ' ') {
				break;
			}
			if (j == board[j].length - 1) {
				if (tmp == 'X') {
					return 1;
				} else {
					return -1;
				}
			}
		}
		return 0;
	}
}