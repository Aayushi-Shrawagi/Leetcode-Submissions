class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums) < 3:return []

        nums.sort()
        res = []

        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            lb, ub = i + 1, len(nums) - 1
            
            while lb < ub:
                total = nums[i] + nums[lb] + nums[ub]
                
                if total == 0:
                    res.append([nums[i], nums[lb], nums[ub]])
                    
                    while lb < ub and nums[lb] == nums[lb + 1]:
                        lb += 1
                    while lb < ub and nums[ub] == nums[ub - 1]:
                        ub -= 1
                    
                    lb += 1
                    ub -= 1
                
                elif total < 0:
                    lb += 1
                else:
                    ub -= 1
        
        return res
            