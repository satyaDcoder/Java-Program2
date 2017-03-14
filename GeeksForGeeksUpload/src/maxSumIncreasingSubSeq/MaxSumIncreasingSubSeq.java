package maxSumIncreasingSubSeq;

/* This Algorithm is upgraded version of 
 * 	Maximum Sum Increasing Subsequence.
 *  "http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/"
 * 	Fast Algorithm then uploaded one.
 * 	No need 2 linear loop. 
 * 	which consume unnecessary processing  time.
 * */

public class MaxSumIncreasingSubSeq {
	
	

	public static int maxSumIncreasing(int arr[],int n) {
		// create lookup array.
		int lookupArray[] = new int[n]; 
		
		// put arr[] first value in lookupArray[0]
		lookupArray[0] = arr[0];
		
		int maxSum = 0;
		
		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j]<arr[i]) {
					int prev = lookupArray[j]>0?lookupArray[j]:arr[j];
					// find previous value , 
					// if in lookuparray has value greater than 0, 
					// then it pick value from lookupArray 
					// otherwise from arr[].
					int temp = prev+arr[i];
					if (temp>max) {
						max = temp;
					}
				}
			}
			lookupArray[i] = max;
			
			if (lookupArray[i]>maxSum) { // Maximum sum can be found directly.
				maxSum = lookupArray[i];
			}
		}
		
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int arr[] = {4,1, 2, 3,4,5,6,50,1,2,3,4,6,99};
		System.out.println(maxSumIncreasing(arr, arr.length));
	}

}
