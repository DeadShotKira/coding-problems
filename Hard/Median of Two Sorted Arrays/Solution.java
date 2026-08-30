class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """

        list3 = nums1 + nums2
        list3.sort()
        mid = len(list3) // 2



        if len(list3) % 2 == 0:
            return (list3[mid] + list3[mid - 1]) / 2.0
        else: 
            return list3[mid]