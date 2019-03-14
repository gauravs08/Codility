package com.HackerRank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class sumOfInteger {

	/** DESC: To read array size from input file and write sum of all scanner i/p into output file.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
        //BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Gaurav\\Desktop\\naina\\int.txt"));
        //int _arr_size = Integer.parseInt(in.nextLine());

		int _arr_size = 2;
        long res;
        
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine());
            _arr[_arr_i] = _arr_item;
        }
        
        res = sumOfIntegers(_arr);
        System.out.println(res);
        //bw.write(String.valueOf(res));
        //bw.newLine();
        
       // bw.close();
    }

	
		

	
private static long sumOfIntegers(int[] _arr) {
	long sum = 0;
	for(int i=0;i<_arr.length;i++){
	sum +=_arr[i];
			
	}
	return sum;
}
}


