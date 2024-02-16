class Solution:
    def findLeastNumOfUniqueInts(self, arr, k):
        count = Counter(arr)
        unique_counts = sorted(count.values())
        for freq in unique_counts:
            if k <= 0:
                break
            elif k >= freq:
                k -= freq
                count -= Counter({arr[unique_counts.index(freq)]: freq})
        return len(count)

