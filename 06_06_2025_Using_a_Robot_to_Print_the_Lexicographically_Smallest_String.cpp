int n = s.size();
    vector<char> minSuffix(n);
    minSuffix[n - 1] = s[n - 1];

    for (int i = n - 2; i >= 0; --i)
        minSuffix[i] = min(s[i], minSuffix[i + 1]);

    stack<char> t;
    string result;

    for (int i = 0; i < n; ++i) {
        t.push(s[i]);
        while (!t.empty() && (i == n - 1 || t.top() <= minSuffix[i + 1])) {
            result += t.top();
            t.pop();
        }
    }

    while (!t.empty()) {
        result += t.top();
        t.pop();
    }

    return result;

