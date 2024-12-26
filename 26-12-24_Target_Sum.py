def backtrack(nums, num_size, target, x, current_sum, ans):
    if x == num_size:
        if current_sum == target:
            return ans + 1
        else:
            return ans
    else:
        ans = backtrack(nums, num_size, target, x + 1, current_sum + nums[x], ans)
        ans = backtrack(nums, num_size, target, x + 1, current_sum - nums[x], ans)
    return ans


def find_target_sum_ways(nums, target):
    num_size = len(nums)
    return backtrack(nums, num_size, target, 0, 0, 0)
