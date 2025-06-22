def divide_string(s: str, k: int, fill: str) -> list[str]:
    result = []
    n = len(s)

    for i in range(0, n, k):
        part = s[i:i+k]
        if len(part) < k:
            part += fill * (k - len(part))  # Pad with fill
        result.append(part)

    return result
