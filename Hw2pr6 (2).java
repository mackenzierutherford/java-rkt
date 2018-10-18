package com.gradescope.hw2pr6;
import static org.junit.Assert.assertEquals;

// updated 2018-02-04 to include the solution to the hash table problems!
import java.util.Arrays;
import java.util.HashMap;

public class Hw2pr6 {

	/*************************************************************
	 * STOP - if you haven't read the directions, do that first!
	 **************************************************************/

	// Source: http://codingbat.com/prob/p184031 (answer available)
	/*
	 * Given an array of ints, return the number of 9's in the array.
	 */
	public static int arrayCount9(int[] nums) {
		int count = 0;                           //creates counter
		for (int i=0; i < nums.length; i++) {  //searches through whole list
			if (nums[i]==9) {                    //if an integer 9 is found in the array,
				count ++;                        //add one to the count
			}
		}		
		return count;                            //return the final count when finished looping through the array
	}

	// Source: http://codingbat.com/prob/p186031 (answer available)
	/*
	 * Given an array of ints, return true if one of the first 4 elements in the
	 * array is a 9. The array length may be less than 4.
	 */
	public static boolean arrayFront9(int[] nums) {
		for(int i=0; i < nums.length && i < 4; i++) { //goes through whole array as long as the array holds at least 4 elements
			if(nums[i]==9) {                          //if the first int is 9
				return true;                          
			}
		}
		return false;          
	}

	// Source: http://codingbat.com/prob/p136041 (answer available)
	/*
	 * 
	 * Given an array of ints, return true if .. 1, 2, 3, .. appears in the
	 * array somewhere.
	 */
	public static boolean array123(int[] nums) {
		for (int i=0; i < (nums.length-2); i++) {             //123 is 3 integers in a row, so doesn't check for last 2 ints (length-2)
			if (nums[i]==1 && nums [i+1]==2 && nums[i+2]==3)  //if three indexes in a row hold 1,2,and 3 in order
				return true;								  
		}
		return false;                                        
	}
	
	
	// Source: http://codingbat.com/prob/p110019 (answer available)
	/*
	 * Given an array of ints, return the number of times that two 6's are next
	 * to each other in the array plus the number of times where a 6 is followed
	 * by a 7.
	 * 
	 * Looked at solution because I had an error, but then realized I wasn't
	 * understanding what the function was doing
	 */
	
	public static int array667(int[] nums) {
		int count = 0;                                //creates counter
		for (int i=0; i < (nums.length-1); i++) {     //recurs within full list 
			if (nums[i]==6) {                         //if the first number=6
				if (nums [i+1]==6 || nums[i+1]==7) {  //and the second number is either 6 or 7
					count++;						  //add one to count, then loop
				}
			}
		}
		return count;                                 //when last element is reached,return the final count
	}

	// Source: http://codingbat.com/prob/p170221 (answer available)
	/*
	 * Given an array of ints, we'll say that a triple is a value appearing 3
	 * times in a row in the array. Return true if the array does not contain
	 * any triples.
	 */
	// used solution for this one, was unsure how to concisely
	// count ints in order, but learned that the easiest way
	// is to define an integer to hold the value of the first one to compare to the rest!
	
	
	public static boolean noTriples(int[] nums) {
			for(int i=0; i < (nums.length-2); i++) {              //loop through list until last two ints (last two ints can't be the beginning of a triple)
				int firstnum = nums[i];                           //hold value of the first number
				if (nums[i+1]==firstnum && nums[i+2]==nums[i+1])  //compare to values of second and third in array
					return false;
				}
		return true;
	}

	// Source: http://codingbat.com/prob/p185685 (hint available)
	/*
	 * Given an array of ints, return true if 6 appears as either the first or
	 * last element in the array. The array will be length 1 or more.
	 */
	public static boolean firstLast6(int[] nums) {
		return nums[0] == 6 || nums[nums.length-1] == 6 ; //return boolean, if first int (nums[0]) is equal to 6 or the last int (nums[nums.length-1]) is equal to 6

	}

	// Source: http://codingbat.com/prob/p118976 (hint available)
	/*
	 * 
	 * Given an array of ints, return true if the array is length 1 or more, and
	 * the first element and the last element are equal.
	 */
	public static boolean sameFirstLast(int[] nums) {
		if (nums.length > 0)                            //if the length of 
			if (nums[0] == nums[nums.length-1]) {       //and if the first number is equal to the last number
				return true;                
			}
		return false;
		}
		


	// Source: http://codingbat.com/prob/p167011
	/*
	 * Return an int array length 3 containing the first 3 digits of pi, {3, 1,
	 * 4}.
	 */
	public static int[] makePi() {
		return new int[] {3, 1, 4}; //return new int array containing 314
	}

	// Source: http://codingbat.com/prob/p191991
	/*
	 * Given 2 arrays of ints, a and b, return true if they have the same first
	 * element or they have the same last element. Both arrays will be length 1
	 * or more.
	 */

	public static boolean commonEnd(int[] a, int[] b) {
		return (a[0] == b[0] || a[a.length-1] == b[b.length-1]); //boolean for if the first element or last element of arrays a and b are equal
	}

	// Source: http://codingbat.com/prob/p175763
	/*
	 * Given an array of ints length 3, return the sum of all the elements.
	 */
	public static int sum3(int[] nums) {
		int sum = nums[0] + nums[1] + nums[2]; //defines an integer sum as the sum of the first, second, and third elements in the array
		return sum;           				   //returns the sum
	}

	// Source: http://codingbat.com/prob/p185139
	/*
	 * Given an array of ints length 3, return an array with the elements
	 * "rotated left" so {1, 2, 3} yields {2, 3, 1}.
	 */
	public static int[] rotateLeft3(int[] nums) {
		return new int[] {nums[1], nums[2], nums[0]}; //creates new array of left shifted elements
	}

	// Source: http://codingbat.com/prob/p162010
	/*
	 * Return the number of even ints in the given array. Note: the % "mod"
	 * operator computes the remainder, e.g. 5 % 2 is 1.
	 */
	public static int countEvens(int[] nums) {
		int count = 0;                              //creates counter
			for(int i = 0; i < nums.length; i++) {  //runs through whole array
				if(nums[i] % 2 == 0) {              //if the remainder of the element divided by 2 is 0, the element is even
					count++;                        //add one to count
				}
			}
		return count;
	}

	// Source: http://codingbat.com/prob/p196640
	/*
	 * Given an array length 1 or more of ints, return the difference between
	 * the largest and smallest values in the array. Note: the built-in
	 * Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or
	 * larger of two values.
	 */
	public static int bigDiff(int[] nums) {
		int max = nums[0]; 							//set max equal to first element
		int min = nums[0];  						//set min equal to first element
			for(int i = 1; i < nums.length; i++) {  //starting at the second element, compare to each element
				max = Math.max(max,  nums[i]);      //uses built in function math.max to compare two elements - the current minimum and the next element in the list
				min = Math.min(min, nums[i]);       //uses built in function math.min to compare two elements - the current minimum and the next element in the list
				}
		return max - min;                           //returns difference between max and min
	}

	// Source: http://codingbat.com/prob/p136585
	/*
	 * Return the "centered" average of an array of ints, which we'll say is the
	 * mean average of the values, except ignoring the largest and smallest
	 * values in the array. If there are multiple copies of the smallest value,
	 * ignore just one copy, and likewise for the largest value. Use int
	 * division to produce the final average. You may assume that the array is
	 * length 3 or more.
	 */
	public static int centeredAverage(int[] nums) {
		int sum = 0;								  //creates int sum to hold sum of elements
		int max = nums[0];                            //keeps track of max
		int min = nums[0];							  //keeps track of min
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];						  //finds sum of all numbers by going through list
				for (int j =1; j <nums.length; j++) { //compares all elements after the second element to max and min held originally by the first element (same as in last method)
					max = Math.max(max, nums[j]);
					min = Math.min(min, nums[j]);	
				}
			}
		return (sum-max-min) / (nums.length-2);    //returns the sum of all elements minus the max and the min and then divides by the length minus two (to take into account the subtraction of the max and min)
	}

	// Source: http://codingbat.com/prob/p197888 (solution available)
	// note - the solution will return the map, we're just modifying it.
	/*
	 * Modify the given map as follows: if the key "a" has a value, set the key
	 * "b" to have that value, and set the key "a" to have the value "".
	 * Basically "b" is a bully, taking the value and replacing it with the
	 * empty string.
	 */
	public static void mapBully(HashMap<String, String> map) {
		if (map.containsKey("a")) {
			map.put("b", map.get("a"));
			map.put("a", "");
		}
	}

	// Source: http://codingbat.com/prob/p182712 (hint available)
	/*
	 * Given a map of food keys and topping values, modify and return the map as
	 * follows: if the key "ice cream" is present, set its value to "cherry". In
	 * all cases, set the key "bread" to have the value "butter".
	 */
	public static void topping1(HashMap<String, String> map) {
		map.put("bread", "butter");
		if (map.containsKey("ice cream")){
			map.put("ice cream", "cherry");
		}
	}

	public static void main(String[] args) {

		

	}
}