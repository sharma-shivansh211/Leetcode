class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        res=[]
        freq={}
        bucket=[[] for i in range(len(nums)+1)]
        for num in nums:
            freq[num]=1+freq.get(num,0)
        for key, value in freq.items():
            bucket[value].append(key)
        for arr in reversed(bucket):
            if k==0:
                return res
            if not arr:
                continue
            for num in arr:
                res.append(num)
                k-=1
                if k==0:
                    return res



        