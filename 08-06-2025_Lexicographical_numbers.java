public List<Integer> lexicalOrder(int n) {
    List<Integer> ans = new ArrayList<>();
    solve(ans, n, 1);
    return ans;
}

private void solve(List<Integer> ans, int n, int num) {
    if (num > n) return;

    for (int i = 0; i < 10; i++) {
        if (num + i > n) break;
        if (num == 1 && i == 9) break;
        ans.add(num + i);
        solve(ans, n, (num + i) * 10);
    }
}
