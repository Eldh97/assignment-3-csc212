
public class LinkedBT<T> implements BT<T> {
	BTNode<T> root  , current ;
	
	
	
	public LinkedBT(){
		root = current = null;
	}
	
	public boolean empty(){
		return root == null;
		}
	
	public boolean full() {
		return false ;
	}
	
	
	public T retrieve() {
		return current.data;
		}
	
	
	public void update(T e) {
		current.data = e;
		}

	
	public boolean insert(T e , Relative rel) {
		switch(rel) {
		case Root:
		if(!empty()) return false;
		current = root = new BTNode<T>(e);
		return true;
		case Parent: //This is an impossible case.
		return false;
		case LeftChild:
		if(current.left != null) return false;
		current.left = new BTNode<T>(e);
		current = current.left;
		return true;
		case RightChild:
		if(current.right != null) return false;
		current.right = new BTNode<T> (e);
		current = current.right;
		return true;
		default:
		return false;
		}
		
		}

	
	public void deleteSub(){
		if(current == root){
		current = root = null;
		}
		else {
		BTNode<T> p = current;
		find(Relative.Parent);
		if(current.left == p)
		current.left = null;
		else
		current.right = null;
		current = root;
		}
		}
	
	public boolean find(Relative rel){
		switch (rel) {
		case Root: 
		current = root;
		return true;
		case Parent:
		if(current == root) return false;
		current = findparent(current, root);
		return true;
		case LeftChild:
		if(current.left == null) return false;
		current = current.left;
		return true;
		case RightChild:
		if(current.right == null) return false;
		current = current.right;
		return true;
		default:
		return false;
		}
		}
		
	
	
	
	@SuppressWarnings("unchecked")
	private BTNode<T> findparent(BTNode<T> p, BTNode<T> t) {
		if(t == null)
		return null; 
		if(t.right == null && t.left == null)
		return null;
		else if(t.right == p || t.left == p)
		return t; // parent is t
		else {
		@SuppressWarnings("rawtypes")
		BTNode q = findparent(p, t.left);
		if (q != null)
		return q;
		else
		return findparent(p, t.right);
		}
		}
	
	
	
	
	
	
	public int depth() {
		
		int d = 0;
		BTNode<T> tmp = current ;
		while( find(Relative.Parent) ){
			d++;
		}
		current = tmp;
		return d;
		
	}

	
	
	
	
	
	
	
		}
	
	
		

