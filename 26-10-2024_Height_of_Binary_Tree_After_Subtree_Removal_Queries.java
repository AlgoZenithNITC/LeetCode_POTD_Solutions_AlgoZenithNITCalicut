/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] out = new int[queries.length];
        int[] a = new int[100005];
        int[] ans = new int[100005];
        
        height(root, a);
        
        int t = 1, h = 0, depth = 0, nmax = 0, nsmax = 0, cmax = 0, csmax = 0, l = 0, j = 0;
        TreeNode[] q = new TreeNode[50000];
        q[0] = root;
        
        while (h != t) {
            l = (t > h) ? t - h : 50000 - h + t;
            j = l;
            
            while (l-- > 0) {
                TreeNode ht = q[h];
                h = (h + 1 == 50000) ? 0 : h + 1;
                
                if (a[ht.val] == cmax) {
                    ans[ht.val] = (j > 1) ? depth + csmax : depth - 1;
                } else {
                    ans[ht.val] = depth + cmax;
                }
                
                if (ht.left != null) {
                    q[t] = ht.left;
                    if (a[ht.left.val] > nmax) {
                        nsmax = nmax;
                        nmax = a[ht.left.val];
                    } else if (a[ht.left.val] > nsmax) {
                        nsmax = a[ht.left.val];
                    }
                    t = (t + 1 == 50000) ? 0 : t + 1;
                }
                
                if (ht.right != null) {
                    q[t] = ht.right;
                    if (a[ht.right.val] > nmax) {
                        nsmax = nmax;
                        nmax = a[ht.right.val];
                    } else if (a[ht.right.val] > nsmax) {
                        nsmax = a[ht.right.val];
                    }
                    t = (t + 1 == 50000) ? 0 : t + 1;
                }
            }
            
            cmax = nmax;
            csmax = nsmax;
            nmax = nsmax = 0;
            depth++;
        }
        
        for (int i = 0; i < queries.length; i++) {
            out[i] = ans[queries[i]];
        }
        
        return out;
    }

    private int height(TreeNode root, int[] a) {
        if (root != null) {
            int h = 1;
            if (root.left != null || root.right != null) {
                h += Math.max(height(root.left, a), height(root.right, a));
            }
            a[root.val] = h - 1;
            return h;
        }
        return 0;
    }
}
