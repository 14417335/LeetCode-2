Sequence DP
�ǵ���Ҫ ������ �� ���ҵ��� ɨ����
����֤ rate ֵ�ϴ��߻�õ��ǹ����������ߵĺ���Ҫ��

/*
There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
         
        int[] count = new int[ratings.length];
        // ÿ�����ӳ�ʼ����һ���ǹ�
        Arrays.fill(count,1);
        int sum = 0;
        // ��������ɨ�裬��֤һ�������Ϸ���������ǹ�����
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                count[i] = count[i-1] + 1;
            }
        }
        
        // ��������ɨ�裬��֤��һ�������Ϸ���������ǹ�����
        for(int i = ratings.length-1; i>0; i--) {
            sum += count[i];
            if(ratings[i] < ratings[i-1] && count[i] >= count[i-1]) {
                count[i-1] = count[i] + 1;
            }
        }
        sum += count[0];
         
        return sum;
    }
}
