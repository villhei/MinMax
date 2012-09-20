/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minmax;

import java.util.ArrayList;

/**
 *
 * @author Ville Heikkinen
 */
public class Tree {

	private char[][] board;
	private int value;
	private ArrayList<Tree> nodes;

	public Tree(char[][] board) {
		int len = board.length;
		this.board = new char[len][len];
		System.arraycopy(board, 0, this.board, 0, len);
		this.nodes = new ArrayList();
	}

	public Tree() {
	}
	
	public Tree(Tree tree)
	{
		this(tree.getBoard());
	}

	public int getValue() {
		updateValue();
		return value;
	}

	public void insertNode(Tree node) {
		nodes.add(node);
	}
	
	public int getNodeLength()
	{
		return nodes.size();
	}
	
	public int getTreeSize()
	{
		int size = 1;
		System.out.println("Children: " + nodes.size());
		if(nodes!=null)
		{
			for(Tree node : nodes)
			{
				size += node.getTreeSize();
			}
		}
		return size;
	}
	
	public char[][] getBoard()
	{
		return this.board;
	}

	public Tree maxNode() {
		Tree maxValue = nodes.get(0);
		for (Tree node : nodes) {
			if (node.getValue() >= maxValue.getValue()) {
				maxValue = node;
			}
		}
		return maxValue;
	}

	public Tree minNode() {
		Tree minValue = nodes.get(0);
		for (Tree node : nodes) {
			if (node.getValue() <= minValue.getValue()) {
				minValue = node;
			}
		}
		return minValue;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}

	public void updateValue() {
		
		for (Tree node : nodes) {
			this.value += node.getValue();
		}
	}
}
