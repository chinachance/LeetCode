# 三角形计数

题目描述:

给定一个整数数组，在该数组中，寻找三个数，分别代表三角形三条边的长度，问，可以寻找到多少组这样的三个数来组成三角形？

样例:

例如，给定数组 S = `{3,4,6,7}`，返回 `3`

其中我们可以找到的三个三角形为：

~~~~
{3,4,6}
{3,6,7}
{4,6,7}
~~~~



给定数组 S = `{4,4,4,4}`, 返回 `4`

其中我们可以找到的三个三角形为：

~~~~
{4(1),4(2),4(3)}
{4(1),4(2),4(4)}
{4(1),4(3),4(4)}
{4(2),4(3),4(4)}
~~~~

## 解决方法

~~~~java
public class Solution {
    /*
     * @param S: A list of integers
     * @return: An integer
     */
     public int triangleCount(int[] S) {
	        // write your code here
		 int count = 0;
	        for(int i = 0; i < S.length - 2 ; i++){
	        	for(int j = i + 1; j < S.length-1 ; j++){
	        		for(int k = j + 1; k < S.length ; k++){
	        			int max = getMax(S[i],S[j],S[k]);
	        			int min = getMin(S[i],S[j],S[k]);
	        			//中间的数
	        			int middle =S[i]+S[j]+S[k]-max-min;
	        			if((min + middle) > max || (min == max)){
	        				count++;
	        			}
	        		}
	        	}
	        }
	        return count;
	    }
	 
	 public int getMax(int i, int j ,int k){
		 int max = i;
		 if(max < j){
			 max = j;
		 }
		 if(max < k){
			 max = k;
		 }
		 return max;
	 }
     
	 public int getMin(int i, int j , int k){
		 int min = i;
		 if(min > j){
			 min = j;
		 }
		 if(min > k){
			 min = k;
		 } 
		 return min;
	 }
}
~~~~

运行之后,发现执行效率低,请看评测结果:

 ![1](C:\Users\C\Desktop\NoteGithub\LeetCode\2017.11.3三角形计数\1.png)

