import java.util.ArrayList;
/*
 * @Author Napoleon Mendez
 * Course: CMSC-204-21437
 * Instructor: Huseyin Aygun
 * Assignment 5 Morse Code
 */
public class MorseCodeTree<T> implements LinkedConverterTreeInterface<String> {

	
	private TreeNode <String> root;
	
	/*
	 * Construct a new MorseCodeTree and build the tree
	 */
	public MorseCodeTree() {
		root = new TreeNode<>("");
		buildTree();
	}
	/*
	 * @return the root node of the tree
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	/*
	 * Sets a new root node for the tree
	 * 
	 * @param newNode the root node 
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}
	/*
	 * Inserts a letter into the tree
	 * 
	 * @param code the Morse code
	 * @return result the letter with morse code
	 */
	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);
	}
	
	/*
	 * Adds a node to the tree
	 * 
	 * @param root the current node
	 * @code the morse code
	 * @letter the letter associated with morse code
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		switch(code.charAt(0)) {
		case '.':
	
			if(code.length() == 1) {
				root.left = new TreeNode<>(letter);
			}
			else {
				addNode(root.left, code.substring(1), letter);
			}
			break;
		
		case '-':
		
			if(code.length() == 1) {
				root.right = new TreeNode<>(letter);
			}
			else {
				addNode(root.right, code.substring(1), letter);
			}
			break;	
		}
	}
	/*
	 * Fetches the letter given with the morse code
	 * 
	 * @param code the morse code
	 * @return the letter associated with morse code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	/*
	 * Searches for a node with the given morse code
	 * 
	 * @param root the current node
	 * @param code the morse code
	 * @return the letter associated with the morse code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		if(root == null) {
			throw new IllegalArgumentException();
		}
		
		if(code.isEmpty()) {
			if(root.getData() == null) {
				return "";
			}else {
				return root.getData();
			}
		}
		switch(code.charAt(0)) {
		case '.':
			return fetchNode(root.left, code.substring(1));
		case '-':
			return fetchNode(root.right, code.substring(1));	
		default:
			throw new IllegalArgumentException();
		}
		
	}
	/*
	 * Not supported
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation not supported in the MorseCodeTree");

	}
	/*
	 * Not supported
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation not supported in the MorseCodeTree");
	}
	/*
	 * Builds the morse code tree
	 */
	@Override
	public void buildTree() {
		root = new TreeNode<>("");
		//level one
		insert(".", "e");
		insert("-", "t");
		
		//level two
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		// level three
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		// level four
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");

	}
	
	/*
	 * Converts the morsecodetree into an arraylist
	 * 
	 * @return an arraylist of strings
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		return list;
	}

	/*
	 * Performs an in-order traversal of the tree
	 * 
	 * @param root the current node
	 * @param list to add the node data
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null) {
			return;
		}
		LNRoutputTraversal(root.left, list);
		if(root.getData() != null) {
			list.add(root.getData());
		}
		LNRoutputTraversal(root.right, list);
	}

}
