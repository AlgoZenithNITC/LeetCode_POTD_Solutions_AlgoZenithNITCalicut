class Solution:

    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:

        # ans is a list so that it passes by reference

        def getPath(cur, targetValue, path, ans):

            if cur is None:

                return

            if cur.val == targetValue:

                ans.append(''.join(path));

            path.append('L');

            getPath(cur.left, targetValue, path, ans)

            path[-1] = 'R'

            getPath(cur.right, targetValue, path, ans)

            path.pop(-1)


        tmpPath = []

        startPath = []

        destPath = []

        getPath(root, startValue, tmpPath, startPath)

        getPath(root, destValue, tmpPath, destPath)

        startPath = startPath[0]

        destPath = destPath[0]


        # Find the first point at which the paths diverge

        i = 0

        while i < min(len(startPath), len(destPath)) and startPath[i] == destPath[i]:

            i += 1

        return 'U'*(len(startPath)-i) + destPath[i:]
