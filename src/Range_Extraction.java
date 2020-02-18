/** 
 * @author Christov van Heerden
 * @version 1.0
 * @since 2020-02-18
 * @title Range Extraction
 * CodeWars exercises - 4Kyu

A format for expressing an ordered list of integers is to use a comma separated 
list of either:

    - individual integers
    - or a range of integers denoted by the starting integer separated from the 
      end integer in the range by a dash, '-'. The range includes all integers in 
      the interval including both endpoints. It is not considered a range unless 
      it spans at least 3 numbers. For example ("12, 13, 15-17")

Complete the solution so that it takes a list of integers in increasing order and 
returns a correctly formatted string in the range format.

*/

import java.lang.StringBuilder;


public class Range_Extraction {
	public static void main(String args[]) {
		System.out.println(rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20})
				+ " = -6,-3-1,3-5,7-11,14,15,17-20");
		System.out.println(rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20})
				+ " = -3--1,2,10,15,16,18-20");
		
	}
	
	public static String rangeExtraction(int[] arr) {
		// Declare and initialize StringBuilder and variables
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]);
		int rangeCount = 0;
		
		// Loop through the int[] and build the required string to be output
		for(int i = 1; i < arr.length; i++) {
			if(arr[i]-1 == arr[i-1] && rangeCount <= 1) { 
				rangeCount += 1;
			}
			else if(arr[i]-1 == arr[i-1] && rangeCount > 1) { 
				rangeCount += 1;
			}
			else if(arr[i]-1 != arr[i-1] && rangeCount > 1) {
				sb.append("-" + arr[i-1] + "," + arr[i]);
				rangeCount = 0;
			}
			
			else if(arr[i]-1 != arr[i-1] && rangeCount <= 1) {
				sb.append("," + arr[i]);
			}
		}
		
		return sb.toString();
	}
}
