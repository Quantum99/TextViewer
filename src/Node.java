//Node.java
public class Node {
	private String line;
	private	Node NextNode;
	private Node LeftSubTree;
	private Node RightSubTree;
	public Node() {
		line = "";
		NextNode = null;
		LeftSubTree = null;
		RightSubTree = null;
	}
	public Node(String l) {
		line = l;
		NextNode = null;
		LeftSubTree = null;
		RightSubTree = null;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public Node getNextNode() {
		return NextNode;
	}
	public void setNextNode(Node nextNode) {
		NextNode = nextNode;
	}
	public Node getLeftSubTree() {
		return LeftSubTree;
	}
	public void setLeftSubTree(Node leftSubTree) {
		LeftSubTree = leftSubTree;
	}
	public Node getRightSubTree() {
		return RightSubTree;
	}
	public void setRightSubTree(Node rightSubTree) {
		RightSubTree = rightSubTree;
	}
}
