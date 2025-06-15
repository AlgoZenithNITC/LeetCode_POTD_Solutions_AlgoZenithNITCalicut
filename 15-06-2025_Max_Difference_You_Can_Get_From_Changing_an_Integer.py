def maxDiff(num):
    mult = 1
    while num % mult == 0:
        mult *= 10
    mult //= 10

    rev = 0
    copy = num
    while copy:
        rev = rev * 10 + copy % 10
        copy //= 10

    # max_num
    max_val = 0
    copy = rev
    prev_rep = -1
    while copy % 10 == 9:
        max_val = max_val * 10 + 9
        copy //= 10
    rep = copy % 10
    prev_rep = rep
    while copy:
        x = copy % 10
        if x == rep:
            x = 9
        max_val = max_val * 10 + x
        copy //= 10

    # min_num
    min_val = 0
    copy = rev
    while copy and copy % 10 <= 1:
        min_val = min_val * 10 + copy % 10
        copy //= 10
    rep = copy % 10
    replaced = 0
    if min_val == 0:
        replaced = 1
    while copy:
        x = copy % 10
        if x == rep:
            x = replaced
        min_val = min_val * 10 + x
        copy //= 10

    ans = max_val - min_val

    if prev_rep == 0:
        while mult > 1:
            ans = ans * 10 + 9
            mult //= 10
        return ans

    return ans * mult

# Example
print(maxDiff(100))
