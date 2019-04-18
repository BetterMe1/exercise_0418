package exercise.exercise_0418;

/*
关于时间效率
 */
/*
连续子数组的最大和
题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，
返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
/*
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0){
            return 0;
        }
        int max = array[0];
        int cur = array[0];
        for(int i=1; i<array.length; i++){
            cur += array[i];
            if(cur > max){
                max = cur;
            }
            if(cur < 0){
                cur = 0;
            }
        }
        return max;
    }
}
*/

/*
最小的K个数
题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
/*
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {//1 1 1 2 2 3 4
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(input);
        int len = input.length;
        int m = 0;
        for(int i=0; i<len; i++){
            if(m < k){
                if(m == 0){
                    list.add(input[i]);
                    m++;
                }else{
                    if(input[i] != list.get(m-1)){
                        list.add(input[i]);
                        m++;
                    }
                }
            }else{
                break;
            }
        }
        return list.size() == k ? list : new ArrayList<>();
    }
}*/

/*
数组中出现次数超过一半的数字
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int i = 0;//基数索引
        int len = array.length;
        int count = 0;
        //[4,2,1,4,2,4]
        for(int j=0; j<len; j++){
            if(array[j] == array[i]){
                count++;
            }else{
                count--;
                if(count == 0){
                    if(j+1 ==len){
                        return 0;
                    }else{
                        i=j+1;//改变基数
                    }
                }
            }
        }
        //检验
        count = len/2 +1;
        for(int j=0; j<len; j++){
            if(array[j] == array[i]){
                count--;
            }
            if(count == 0){
                break;
            }
        }
        return count==0 ? array[i] : 0;
    }
}