def min_changes(s: str) -> int:
    changes = 0
    n = len(s)
    
    for i in range(0, n - 1, 2):  # Loop through even indices, comparing s[i] and s[i + 1]
        if s[i] != s[i + 1]:
            changes += 1
    
    return changes