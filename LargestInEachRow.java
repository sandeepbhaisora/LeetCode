/*
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]

*/
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
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        if(root == null)
            return new ArrayList<Integer>();
        // should be bfs/level order traversal
        Queue<LevelNode> queue = new LinkedList<>();
        LevelNode node = new LevelNode(1,root);
        queue.offer(node);
        Map<Integer,Integer> resultMap = new HashMap<>();
        while( !queue.isEmpty()) {
            LevelNode curNode = queue.poll();
            resultMap.put(curNode.level, Math.max(curNode.node.val,resultMap.getOrDefault(curNode.level,Integer.MIN_VALUE)));
            if(curNode.node.left != null)
                queue.offer(new LevelNode(curNode.level+1,curNode.node.left));
            if(curNode.node.right != null)
            
            queue.offer(new LevelNode(curNode.level+1,curNode.node.right));
        }

        System.out.println(resultMap);
        int[] result = new int[resultMap.size()];
        for(int key : resultMap.keySet()) {
            result[key-1] = resultMap.get(key);
        }

        List<Integer> responseList = new ArrayList<>();
        // responseList =  Arrays.asList(result);\
        for(int i = 0 ; i < result.length; i++)
            responseList.add(result[i]);
        return responseList;

        
    }
}

class LevelNode {
    int level;

    TreeNode node;

    LevelNode(int level, TreeNode node) {
        this.level = level;

        this.node = node;
    }
}
