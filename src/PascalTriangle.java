public class PascalTriangle {
public static void main(String[]args) {
	
	
	BT<Integer> b = buildPascalTri(4);
	b.find(Relative.Root);
	
	System.out.println(b.retrieve());



	System.out.println(b.find(Relative.LeftChild) );
	System.out.println(b.retrieve() );

	System.out.println(b.find(Relative.LeftChild));
	System.out.println(b.retrieve() );

	System.out.println(b.find(Relative.LeftChild));
	System.out.println(b.retrieve() );

	System.out.println(b.find(Relative.LeftChild));

	System.out.println(b.retrieve() );
	
	System.out.println(b.find(Relative.LeftChild));
	
	System.out.println(b.retrieve() );
	
	
	
}
	
	
	
	
	// Build the part of the Pascal triangle of depth d.
	public static BT<Integer> buildPascalTri(int d) {
		
		BT<Integer> pt = new LinkedBT<Integer>();			
		pt.insert(1, Relative.Root);
		for (int n = 1; n <= d; n++) {
			for (int r = 0; r <= n; r++) {
				addNR(pt, n, r);
			}
		}
		
		return pt;
	}
	
	
	// Putc the current at the element C(n,r). The element is assumed to exist in the tree.
	public static void findNR(BT<Integer> pt, int n, int r) {
		
		if(pt == null || pt.empty() )
			return ;
		
		pt.find(Relative.Root);
		recFind(pt, n , r) ;
	}
	
	private static void recFind(BT<Integer> pt , int n , int r) {
		  
		if(pt.depth() == n && r == 0 ) {
			return;
		}
		
		else if(r==0) {
		
			if(pt.find(Relative.LeftChild) )	
				recFind(pt,n,r);
			}
		
			else {
				if(pt.find(Relative.RightChild)) {
					r--;
					recFind(pt,n,r);
				 }
			}
		
		
	}
	
	// Add the value C(n,r) to the tree assuming that both C(n-1, r-1) and C(n-1, r) exist.
	public static void addNR(BT<Integer> pt, int n, int r) {

		
		if(n == r ) {
			findNR(pt, n-1, r-1);
			pt.insert(1, Relative.RightChild);
			
		}
		
		else if(r == 0) {
		
			findNR(pt,n-1,r);
			pt.insert(1, Relative.LeftChild);
		
		}
		
		else if (r != n && r > 0) {
		
		
			findNR(pt, n-1 , r-1);
			Integer n1 = pt.retrieve();
			findNR(pt, n-1 ,r);
			Integer n2 = pt.retrieve();
			Integer res = n1 + n2 ;
			pt.insert(res, Relative.LeftChild);
			
		}
	




}
	
}
