class Solution(object):
    def maxKDistinct(self, nums, k):
        arr = list(set(nums))
        arr.sort(reverse = True)
        return arr[:k]