class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {

        int n = favorite.size();
        vector<int> inDegree(n, 0);
        vector<int> longestChain(n, 0);
        vector<bool> visited(n, false);
        
        // Step 1: Calculate in-degrees for all nodes
        for (int i : favorite) {
            inDegree[i]++;
        }

        // Step 2: Topological Sort (Kahn's Algorithm)
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }

        // Step 3: Process each node in topological order to update the longest chain
        while (!q.empty()) {
            int front = q.front();
            q.pop();
            visited[front] = true;
            int next = favorite[front];
            longestChain[next] = longestChain[front] + 1;

            if (--inDegree[next] == 0) {
                q.push(next);
            }
        }

        // Step 4: Detect cycles and compute cycle sizes
        int maxCycle = 0, total = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int c = i, len = 0;
                while (!visited[c]) {
                    visited[c] = true;
                    c = favorite[c];
                    len++;
                }

                if (len == 2) {
                    total += (2 + longestChain[i] + longestChain[favorite[i]]);
                } else {
                    maxCycle = max(maxCycle, len);
                }
            }
        }

        // Step 5: Return the maximum of the largest cycle size and two-node cycle sum
        return max(total, maxCycle);
    }
};

