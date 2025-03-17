def divideArray(nums):
    hash_map = [0] * 501  # Initialize frequency array

    for num in nums:
        hash_map[num] += 1

    return all(count % 2 == 0 for count in hash_map)
