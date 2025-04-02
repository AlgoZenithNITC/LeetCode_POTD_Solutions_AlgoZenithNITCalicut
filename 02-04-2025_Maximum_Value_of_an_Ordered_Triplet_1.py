def maximum_triplet_value(nums):
    max_val = float('-inf')
    nums_size = len(nums)

    for i in range(nums_size - 2):
        for j in range(i + 1, nums_size - 1):
            for k in range(j + 1, nums_size):
                tmp = (nums[i] - nums[j]) * nums[k]
                if tmp > max_val:
                    max_val = tmp

    return max_val if max_val >= 0 else 0
