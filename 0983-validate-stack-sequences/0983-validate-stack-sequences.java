class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int k=0;
        while(k<pushed.length && popped[0]!=pushed[k]){
            stack.push(pushed[k]);
            k++;
        }
        if(k>=pushed.length) return false;
        
        for(int i=0;i<popped.length;i++){
            if((!stack.isEmpty() && popped[i]==stack.peek())){
                stack.pop();
            }
            else if(k<pushed.length&&popped[i]==pushed[k]){
                k++;
            }
            else if(k<pushed.length){
                stack.push(pushed[k++]);
                i--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}