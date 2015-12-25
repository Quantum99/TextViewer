
public class Tree {
	private Node Root;

	public Tree() {
		Root = null;
	}

	public Node getRoot() {
		return Root;
	}

	public void setRoot(Node root) {
		Root = root;
	}
	
	public void PreOrderTraversal(Node R){
		if(R != null){
			System.out.print(R.getLine() + " ");
			PreOrderTraversal(R.getLeftSubTree());
			PreOrderTraversal(R.getRightSubTree());
		}
	}
	
	public void InOrderTraversal(Node R){
		if(R != null){
			InOrderTraversal(R.getLeftSubTree());
			System.out.print(R.getLeftSubTree().getLine() + " ");
			InOrderTraversal(R.getRightSubTree());
		}
	}
	
	public void InsertNode(String word){
		Node Temp = new Node(word);
		Node T;
		if(Temp != null){
			if(Root == null){
				Root = Temp;
			}
			else{
				T = Root;
				while(true){
					if(word.compareToIgnoreCase(T.getLine()) <= 0){
						if(T.getLeftSubTree() == null){
							T.setLeftSubTree(Temp);
							break;
						}
						else{
							T = T.getLeftSubTree();
						}
					}
					else{
						if(T.getRightSubTree() == null){
							T.setRightSubTree(Temp);
							break;
						}
						else{
							T = T.getRightSubTree();
						}
					}
				}
			}
		}
		
	}
	
	public int CountNodes(Node R){
		if(R != null){
			return 1 + CountNodes(R.getLeftSubTree()) + CountNodes(R.getRightSubTree());
		}
		return 0;
	}
	
	public boolean CheckIfEmpty(){
		if(Root == null){
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	public boolean CheckIfFull(){
		Node Temp = new Node();
		if(Temp == null){
			return true;
		}
		Temp = null;
		return false;
	}
	
	public void Search(String D, Node R, int ct){
		if(R != null){
			if(CompareStrings(R,D) == true){
				System.out.println(D + " was found at word number " + ct);
			}
			else{
				ct += 1;
				Search(D, R.getLeftSubTree(), ct);
				Search(D, R.getRightSubTree(), ct);
			}
		}
	}
	
	public boolean CompareStrings(Node R, String D){
		if (R.getLine() == D){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void PrintSorted(Node R){
		if (R != null){
			PrintSorted(R.getLeftSubTree());
			System.out.println(R.getLine());
			PrintSorted(R.getRightSubTree());
		}
		
	}
	
}