class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> res;
        HashMap<String,ArrayList<String>> map =new HashMap<>();
        for(String word:strs){
            char[] sorted_word=word.toCharArray();
            Arrays.sort(sorted_word);
            String sword=new String(sorted_word);
            ArrayList<String> temp=map.getOrDefault(sword,new ArrayList<>());
            temp.add(word);
            map.put(sword,temp);
        }
        // System.out.println(map);
        res = new ArrayList<>(map.values());
        return res; 
    }
}