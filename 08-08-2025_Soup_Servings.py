def soupServings(self, n: int) -> float:
    if n > 4800:
        return 1.0

    from functools import lru_cache

    @lru_cache(None)
    def f(a, b):
        if a <= 0 and b > 0:
            return 1.0
        if a == 0 and b == 0:
            return 0.5
        if a > 0 and b <= 0:
            return 0.0
        if a <= 0 and b <= 0:
            return 0.5

        return 0.25 * (
            f(a - 100, b) +
            f(a - 75, b - 25) +
            f(a - 50, b - 50) +
            f(a - 25, b - 75)
        )

    return f(n, n)
