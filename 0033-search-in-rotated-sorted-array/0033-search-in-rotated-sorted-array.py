class Solution:
    def search(self, arr: List[int], ele: int) -> int:
        n=len(arr)

        if(n==0): return -1

        if(n==1): return 0 if arr[0]==ele else -1

        ub2=n-1
        lb1=0

        lb,ub=lb1,ub2
        flag=False

        for i in range(1,len(arr)):
            if arr[i]<arr[i-1]:
                ub1=i-1
                lb2=i
                flag=True
                break
                

        
        if flag :
            #the element lies in the first rotated half
            if ele<arr[lb1] and ele>=arr[lb2]:
                lb=lb2
                ub=ub2
            # else in the second half
            else:
                lb=lb1
                ub=ub1

        # perform binary search 
            
        while(lb<=ub):
            mid=(lb+ub)//2
            if arr[mid]==ele:
                return mid
            elif arr[mid]<ele:
                lb=mid+1
            else:
                ub=mid-1
        return -1