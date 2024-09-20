class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charset=set()
        left=0
        maxlength=0
        for right in range(len(s)):
            if s[right] not in charset:
                charset.add(s[right])
                maxlength=max(maxlength, right-left+1)
            else:
                while(s[right] in charset):
                    charset.remove(s[left])
                    left+=1
                charset.add(s[right])
        return maxlength
