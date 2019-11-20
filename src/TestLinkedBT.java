
public class TestLinkedBT {
	public static void main(String[] args) {
		
	@SuppressWarnings("unused")
	BT<Integer> b = buildTestTree();
	
	
	}
	public static BT<Integer> buildTestTree() {

		BT<Integer> b = new LinkedBT<Integer>();
	
		b.insert(1, Relative.Root);
		b.insert(2, Relative.LeftChild);
		b.insert(4, Relative.RightChild);
	
		b.find(Relative.Root);
	
		b.insert(3, Relative.RightChild);
		b.insert(6, Relative.RightChild);
	
		b.find(Relative.Parent);
	
		b.insert(5, Relative.LeftChild);
		b.insert(8, Relative.RightChild);
		
		b.find(Relative.Parent);

		b.insert(7, Relative.LeftChild);

	
		return b;

	}
	
}
