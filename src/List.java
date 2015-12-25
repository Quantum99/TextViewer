
public class List {
	private Node Head;

	public List() {
		
		Head = null;
	}
	
	public Node getHead() {
		return Head;
	}

	public void setHead(Node head) {
		Head = head;
	}

	public void InsertAtFront(String line){
		Node Temp = new Node();
		if(Temp != null){
			Temp.setLine(line);
			Temp.setNextNode(null);
			if (Head == null){
				Head = Temp;
			}
			else{
				Temp.setNextNode(Head);
				Head = Temp;
			}
		}
		Temp = null;
	}
	
	public void InsertAtBack(String line){
		Node Temp = new Node();
		Node tmp;
		if(Temp != null){
			Temp.setLine(line);
			Temp.setNextNode(null);
			if (Head == null){
				Head = Temp;
			}
			else{
				tmp = Head;
				while(tmp.getNextNode() != null){
					tmp = tmp.getNextNode();
				}
				tmp.setNextNode(Temp);
			}
		}
		Temp = null;
		tmp = null;
	}
	
	public boolean SearchForNode(String val){
		Node Temp;
		Temp = Head;
		while (Temp != null){
			if (Temp.getLine() == val){
				return true;
			}
			Temp = Temp.getNextNode();
		}
		Temp = null;
		return false;
	}
	
	public int CountNodes(){
		Node Temp;
		int cnt = 0;
		
		Temp = Head;
		
		while (Temp != null){
			cnt += 1;
			Temp = Temp.getNextNode();
		} 
		Temp = null;
		return cnt;
	}
	
	@SuppressWarnings("unused")
	public boolean CheckIfListFull(){
		Node Temp = new Node();
		
		if (Temp != null){
			Temp = null;
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean CheckIfListEmpty(){
		if (Head == null){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void PrintTheList(){
		Node Temp = Head;
		while (Temp != null){
			System.out.println(Temp.getLine());
			Temp = Temp.getNextNode();
		}
		Temp = null;
	}
	
	@SuppressWarnings("unused")
	public int CountWords(){
		Node Temp = Head;
		int cnt = 0;
		while (Temp != null){
			String lin = Temp.getLine();
			String[] words = lin.split(" ");
			for(String word : words){
				cnt += 1;
			}
			Temp = Temp.getNextNode();
		}
		Temp = null;
		return cnt;
	}
	
	public String[] getAllStrings(Node position){
		String lin = "";
		Node Temp = position;
		while (Temp != null){
			lin = lin.concat(" "+Temp.getLine());
		}
		Temp = null;
		String[] every = lin.split(" ");
		return every;
	}
}
