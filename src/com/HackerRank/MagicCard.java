package com.HackerRank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class MagicCard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer,Integer> cards =new HashMap<Integer, Integer>();
		cards.put(0, 1);cards.put(1, 2);
		cards.put(2, 4);cards.put(3, 8);
		cards.put(4, 16);
		
		Map<Integer,List<Integer>> map=new HashMap();
		List<Integer> list1=new ArrayList();
		list1.add(1);list1.add(3);list1.add(5);list1.add(7);
		list1.add(9);list1.add(11);list1.add(13);list1.add(15);
		list1.add(17);list1.add(19);list1.add(21);list1.add(23);
		list1.add(25);list1.add(27);list1.add(29);list1.add(31);
		map.put(1,list1);
		
		List<Integer> list2=new ArrayList();
		list2.add(2);list2.add(3);list2.add(6);list2.add(7);
		list2.add(10);list2.add(11);list2.add(14);list2.add(15);
		list2.add(18);list2.add(19);list2.add(22);list2.add(23);
		list2.add(26);list2.add(27);list2.add(30);list2.add(31);
		map.put(2,list2);
		
		List<Integer> list4=new ArrayList();
		list4.add(4);list4.add(5);list4.add(6);list4.add(7);
		list4.add(12);list4.add(13);list4.add(14);list4.add(15);
		list4.add(20);list4.add(21);list4.add(22);list4.add(23);
		list4.add(28);list4.add(29);list4.add(30);list4.add(31);
		map.put(4,list4);
		 
		List<Integer> list8=new ArrayList();
		list8.add(8);list8.add(9);list8.add(10);list8.add(11);
		list8.add(12);list8.add(13);list8.add(14);list8.add(15);
		list8.add(24);list8.add(25);list8.add(26);list8.add(27);
		list8.add(28);list8.add(29);list8.add(30);list8.add(31);
		map.put(8,list8);
		
		List<Integer> list16=new ArrayList();
		list16.add(16);list16.add(17);list16.add(18);list16.add(19);
		list16.add(20);list16.add(21);list16.add(22);list16.add(23);
		list16.add(24);list16.add(25);list16.add(26);list16.add(27);
		list16.add(28);list16.add(29);list16.add(30);list16.add(31);
		map.put(16,list16);
		
		Scanner sc = new Scanner(System.in);
		int dob =0;
		
		String input = sc.nextLine();
		String[] split = input.split("\\s+");
		for (String string : split) {
			//dob +=pickUpCard(map, cards.get(Integer.parseInt(string)));
			dob +=cards.get(Integer.parseInt(string));
		}
		System.out.println(dob);
		
	}

	private static int pickUpCard(Map<Integer, List<Integer>> map, int n) {
		int dob=0;
		
		Iterator<Map.Entry<Integer, List<Integer>>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
		    Entry<Integer, List<Integer>> entry = entries.next();
		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    
		    for (Integer value : entry.getValue()) {
					if(value.equals(n)){
						dob +=entry.getKey();
						//System.out.println("Value = " + i);
					}
			    
			}
		}
		return dob;
	}
	
}
