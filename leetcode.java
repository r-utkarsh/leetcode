
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
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
    int arr[] = {1,3,8,48,10,2,8,48,128};
    System.out.println(longestNiceSubarray(arr));
        
    }
}
