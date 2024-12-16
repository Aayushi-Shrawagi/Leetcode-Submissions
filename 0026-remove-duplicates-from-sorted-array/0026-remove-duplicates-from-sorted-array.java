class Solution {
    public int removeDuplicates(int[] nums) {
        // base cases
        int n=nums.length;
            if(n==0) return 0;
            if(n==1) return 1;
            int i=0;
            int j=1;
            while(j<n){
                while(j<n && nums[i]==nums[j]){
                    j++;
                }
                if(j>=n) break;
                nums[++i]=nums[j++];
            }
            return i+1;

    }
}