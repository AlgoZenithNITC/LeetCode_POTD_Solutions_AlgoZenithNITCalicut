class Solution {
private:
    pair<int, int> BoustrophedonPosition(int k, int n)
    {
        int row = (n-1-((k-1)/n));
        int col = (k-1)%n;
        if(((k-1)/n)%2==1)
        {
            col = n-1-col;
        }
        return {row, col};
    }
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        int n = board.size();
        vector<bool> visited(n*n, false);
        deque <pair<int, int>> dq;
        dq.push_back({1, 0});
        visited[0] = true;
        while(!dq.empty())
        {
            int cur = dq.front().first;
            int rolls = dq.front().second;
            dq.pop_front();
            if(cur == n*n)
            {
                return rolls;
            }
            for(int i=6; i>0; --i)
            {
                if(cur+i>n*n)
                {
                    continue;
                }
                pair <int, int> loc = BoustrophedonPosition(cur+i, n);
                int x = loc.first;
                int y = loc.second;
                if(board[x][y]==-1)
                {
                    if(cur+i==n*n)
                    {
                        return rolls+1;
                    }
                    if(visited[cur+i-1])
                    {
                        continue;
                    }
                    visited[cur+i-1] = true;
                    dq.push_back({cur+i, rolls+1});
                }
                else
                {
                    if(board[x][y]==n*n)
                    {
                        return rolls+1;
                    }
                    if(visited[board[x][y]-1])
                    {
                        continue;
                    }
                    visited[board[x][y]-1] = true;
                    dq.push_back({board[x][y], rolls+1});
                }
            }
        }
        return -1;
    }
};
