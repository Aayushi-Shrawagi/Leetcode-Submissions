class DecComp implements Comparator<ArrayList<Integer>>{
    public int compare(ArrayList<Integer> ar1,ArrayList<Integer> ar2){
        return ar2.get(2)-ar1.get(2);
    }
}
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        //Create a array such that all start are indicated with negative values and all ends with positive values and sort accordingly
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
                if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
        });
        // height.forEach(n->System.out.println(Arrays.toString(n)));
        //Priority queue to maintain the max height.
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        
        for(int[] h:height) {
            //store only if the left coordinate encontured
            if(h[1] < 0) {
                pq.offer(-h[1]);
            }
            //Remove if we have reach the end of the given coordinate of the point
            else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            //If height is different from the last point then add it to result
            if(prev != cur) {
                List<Integer> temp=Arrays.asList(new Integer[]{h[0], cur});
                result.add(temp);
                prev = cur;
            }
        }
        //0 added to the start is for the end point
        return result;

    }
}