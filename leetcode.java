import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode {
    public static int longestNiceSubarray(int arr[]){
        int n = arr.length;
        int l=0, r=0;
        int max = 0;
        int mask = 0;
        while(r<n){
            while((mask & arr[r]) != 0){
                mask^= arr[l];
                l++;
            }
            max = Math.max(max, r-l+1);
            mask |= arr[r];
            r++;
        } 
        return max;
    }

    public static void convert (int arr[], int i){
        if(arr[i]==0) arr[i] = 1;
        else arr[i] = 0;
    }    
    public static int minOperation(int arr[]){
        int count = 0, n = arr.length;
        for (int i = 0; i < n-2; i++) {
            // if(arr[i]==0){
            //     convert(arr, i);
            //     convert(arr, i+1);
            //     convert(arr, i+2);
            //     count++;
            // }
            if(arr[i]==0){
                arr[i]^= 1;
                arr[i+1]^= 1;
                arr[i+2]^= 1;
                count++;
            }
        }
        if(arr[n-2]==1 && arr[n-1]==1) return count;
        return -1;
    }

    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = 0, res = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > prevEnd) {
                res += meeting[0] - prevEnd - 1;
            }
            prevEnd = Math.max(prevEnd, meeting[1]);
        }
        if(prevEnd < days) res += days-prevEnd; 
        
        return res;
    }    
    
    public static long maximumTripletValue(int[] nums) {
        long max = 0;
        for (int i = 0; i < nums.length-1; i++) { 
            for (int j = i; j < nums.length; j++) {
                int dif = nums[i] - nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    max = Math.max(dif*nums[k], max);
                }
            }
        }     
        return max;
    }
    
    public static long optimisedMaximumTripletValue(int nums[]){
        long res = 0;
        int maxDif = 0;
        int maxInt = 0;
        for(int num : nums){
            res = Math.max(res, (long)maxDif*num);
            maxDif = Math.max(maxDif, maxInt-num);
            maxInt = Math.max(maxInt, num);
        }
        return res;
    }
    
    public static List<List<Integer>> subset(int nums[]){
        List<List<Integer>> lst = new ArrayList<>();
        backTrackk(lst, new ArrayList<>(), nums, 0);
        return lst;
    }
    public static void backTrackk(List<List<Integer>> lst, List<Integer> temp, int nums[], int start){
        lst.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrackk(lst, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> lst = subset(nums);
        int sum = 0;
        for (List<Integer> sa : lst) {
            int x = 0;
            for (int num : sa) {
                x^= num;
            }
            sum+= x;    
        }
        return sum;
    }
    
    public static void main(String[] args) {
    // int arr[] = {1,3,8,48,10,2,8,48,128};
    // System.out.println(longestNiceSubarray(arr));

    // int arr[] = {0,1,1,1,0,0};
    // System.out.println(minOperation(arr));
    
    // int meeting[][] = {{5,7},{1,3},{9,10}};
    // int days = 10;
    // System.out.println(countDays(days, meeting));
    
    // int nums[] = {9,8,7,6,5,4,3,2,1};
    // System.out.println(maximumTripletValue(nums));
    
    // int nums[] = {1000000,1,1000000};
    // System.out.println(optimisedMaximumTripletValue(nums));

    // int nums[] = {5,1,6};
    // System.out.println(subsetXORSum(nums));

    }
}
