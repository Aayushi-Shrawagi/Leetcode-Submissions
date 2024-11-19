class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] a, int[]b){
                return a[0]-b[0];
            }
        });
        System.out.println(Arrays.deepToString(intervals));
        int k=0;
        for(int i=1;i<intervals.length;i++){
            //the intervals are overlapping
            if(intervals[k][1]>=intervals[i][0]){
                intervals[k][1]=Math.max(intervals[k][1], intervals[i][1]);
            }
            else{
                intervals[++k]=intervals[i];
            }
        }
        // k++;
        // int res[][]=new int[k][2];
        // int j=0;
        // for(int i=0;i<k;i++){
        //     res[j++]=newIntervals[i];
        // }
        return Arrays.copyOf(intervals, k+1);
    }
}