class Solution:
    def subsets(self, ar: List[int]) -> List[List[int]]:
        lenAr=len(ar)
        p=2**lenAr
        res=[]
        bits=[]
        
        for i in range(0,p):
            bits.append(f"{i:0{lenAr}b}")
        print(bits)

        for i in range(p):
            c=[]
            for j in range(lenAr):
                if bits[i][j]=="1":
                    c.append(ar[j])
            res.append(c)
        return res