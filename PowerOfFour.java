/*

Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x. 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 
*/

class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 0)
            return false;
        for(int i = 0; i < 32; i +=2 ){
            int num = 1 << i;
            if((n & num) == n){
                if(n < 0){
                    if(i%6 == 0)
                     return true;
                    return false;
                }
                 return true;
            }
               
        }
        return false;
    }
}
