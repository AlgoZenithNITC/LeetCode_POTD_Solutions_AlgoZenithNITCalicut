#include <vector>
using namespace std;

class Solution {
public:
    int n = 3;
    int N = 9;
    int rows[9][10] = {0};
    int cols[9][10] = {0};
    int boxes[9][10] = {0};
    vector<vector<char>>* board;
    bool solved = false;

    bool couldPlace(int d, int row, int col) {
        int idx = (row / n) * n + (col / n);
        return rows[row][d] + cols[col][d] + boxes[idx][d] == 0;
    }

    void placeNumber(int d, int row, int col) {
        int idx = (row / n) * n + (col / n);
        rows[row][d]++;
        cols[col][d]++;
        boxes[idx][d]++;
        (*board)[row][col] = d + '0';
    }

    void removeNumber(int d, int row, int col) {
        int idx = (row / n) * n + (col / n);
        rows[row][d]--;
        cols[col][d]--;
        boxes[idx][d]--;
        (*board)[row][col] = '.';
    }

    void placeNextNumbers(int row, int col) {
        if (row == N - 1 && col == N - 1) {
            solved = true;
        } else if (col == N - 1) {
            backtrack(row + 1, 0);
        } else {
            backtrack(row, col + 1);
        }
    }

    void backtrack(int row, int col) {
        if ((*board)[row][col] == '.') {
            for (int d = 1; d <= 9; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    if (!solved) removeNumber(d, row, col);
                }
            }
        } else {
            placeNextNumbers(row, col);
        }
    }

    void solveSudoku(vector<vector<char>>& b) {
        board = &b;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (b[i][j] != '.') {
                    int d = b[i][j] - '0';
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }
};
