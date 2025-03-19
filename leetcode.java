
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

        
    
    
    
    
    
    public static void main(String[] args) {
    // int arr[] = {1,3,8,48,10,2,8,48,128};
    // System.out.println(longestNiceSubarray(arr));

    // int arr[] = {0,1,1,1,0,0};
    // System.out.println(minOperation(arr));
    
    }
}
