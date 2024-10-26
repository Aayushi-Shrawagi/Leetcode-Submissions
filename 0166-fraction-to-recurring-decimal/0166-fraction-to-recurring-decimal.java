class Solution {
    public String fractionToDecimal(long num, long den) {
         String res="";
        if((num>0 && den<0) || (den>0 && num<0)){
            res="-";
        }
        num=Math.abs(num);
        den=Math.abs(den);
        long qut=num/den;
        HashMap<Long,Integer> remainder =new HashMap<Long,Integer>();
        ArrayList<String> decimals=new ArrayList<>();
        long r=num%den;
        res=res.concat(String.valueOf(qut));
        boolean isRepeating=false;
        int idx=0;
        int StIdx=0;
        while(r!=0){
            if(remainder.get(r)!=null){
                isRepeating=true;
                StIdx=remainder.get(r);
                break;
            }
            remainder.put(r,idx++);
            num=r*10;
            decimals.add(String.valueOf(num/den));
            r=num%den;
            
        }
        if(!decimals.isEmpty()){
            res=res.concat(".");

            if(isRepeating){
                for(int i=0;i<StIdx;i++){
                    res=res.concat(decimals.get(i));
                }
                res=res.concat("(");
                for(int i=StIdx;i<decimals.size();i++){
                    res=res.concat(decimals.get(i));
                }
                res=res.concat(")");
            }
            else{
                res=res.concat(String.join("", decimals));
            }
        }
        return res;
    }
}