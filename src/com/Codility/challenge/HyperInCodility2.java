package com.Codility.challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class HyperInCodility2 {
static int ans;
	public static void main(String[] args) {
		// int[] A = { 1, 2, 5, 4, 5, -1 }; // {5,5,5,5,5,5};//{ 2, -4, 6, -3, 9 };
		Tree A = new Tree();
		A.setX(1);
		
		
		//Creating A Left
		Tree H= new Tree();			H.setX(2); H.setL(null);H.setR(null);
		Tree D = new Tree();		D.setX(3); D.setL(H)   ;D.setR(null);
		Tree E = new Tree();		E.setX(6); E.setL(null);E.setR(null);
		Tree B = new Tree();		B.setX(2); B.setL(D)   ;B.setR(E); 
				A.setL(B);

		//Creating A right		
		Tree I = new Tree();		I.setX(5);I.setL(null);I.setR(null);
		Tree J = new Tree();		J.setX(6);J.setL(null);J.setR(null);
		Tree G = new Tree();		G.setX(1);G.setL(I)   ;G.setR(J);

		Tree F = new Tree();		F.setX(3);F.setL(null);F.setR(null);
		Tree C = new Tree();		C.setX(3);C.setL(F)   ;C.setR(G);
		A.setR(C);

		//System.out.println("length = " + solution2(A));
		//System.out.println("length = " + GetDistinctCnt(A));
		System.out.println("length = " + solution3(A));

	}

	public static int solution(Tree A) {
		int res = 1;
		String largestDistPath = "";
		HashSet<Integer> set = new HashSet<Integer>();
		Tree nxt = A;


		while (nxt.getX() >0 ) {
			System.out.println(nxt.getX());
			if(nxt.getX()>0 ) {
				if(nxt.getL() != null) {
					nxt = nxt.getL();
				}else if(nxt.getR() != null){
					nxt = nxt.getR();
				}
				res++;
			}else {
				return res;
			}
			
		}
		return res;
	}
	
	public static int solution2(Tree t) {
        return s(t) - 1;
		}

    private static int s(Tree t) {
        if (t == null) {
            return 0;
        }
        
        System.out.println(t.x);
        return Math.max(s(t.l), s(t.r)) + 1;
    }
    static int  solution3(Tree node) 
    { 
    	if (null == node)
            return 0; 
      
    	HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
      
        // return longest unique value path 
        return longestDistinctPath(node, mp); 
    } 
    static int longestDistinctPath(Tree node, HashMap<Integer, Integer> mp) 
    { 
        if (null == node) 
            return mp.size(); 
      
        mp.put(node.x, node.x);
        
        int max_path = Math.max(longestDistinctPath(node.l, mp), 
                           longestDistinctPath(node.r, mp)); 
       
        mp.remove(node.x);
      
        return max_path; 
    }    

static int GetDistinctCnt(Tree n)
{
     Hashtable t = new Hashtable();
     GetMax(n, t);
     return t.size();
}

static void GetMax(Tree n, Hashtable t)
{
     if(n!= null) 
     {
	if(!t.contains(n.x))
	{
	     t.put(n.x, n);
     }
	GetMax(n.r, t);
    GetMax(n.l, t);
     }
}
}
class Tree {
	public int x;
	public Tree l;
	public Tree r;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Tree getL() {
		return l;
	}

	public void setL(Tree l) {
		this.l = l;
	}

	public Tree getR() {
		return r;
	}

	public void setR(Tree r) {
		this.r = r;
	}

}
