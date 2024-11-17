/*
 * @Author Napoleon Mendez
 * Course: CMSC-204-21437
 * Instructor: Huseyin Aygun
 * Assignment 5 Morse Code
 */
public class TreeNode<T>{
	
	TreeNode<T> left;
	TreeNode<T> right;
	T dataNode;
	
	/*
	 * Constructor to initiatilze the treeNode with data
	 * 
	 * @param dataNode the data to be stored
	 */
	public TreeNode(T dataNode) {
		left = null;
		right = null;
		this.dataNode = dataNode;
	}
	
	/*
	 * Coopy Constructor to create a deep copy
	 * 
	 * @param node the TreeNode to be copied
	 */
	public TreeNode(TreeNode<T> node) {
		
		this.dataNode = node.dataNode;
		
		if(node.right != null && node.left != null) {
			this.right = new TreeNode<>(node.right);
			this.left = new TreeNode<>(node.left);
		}
		
	}
	/*
	 * Return the data stored
	 * 
	 * @return the data of type T
	 */
	public T getData() {
		return dataNode;
		
	}
	
	
}
