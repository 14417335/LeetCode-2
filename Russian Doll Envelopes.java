�������ǿ���һ���򵥵������
    �����ŷ�ĳ��Ϳ����ظ���
    �������ǿ��ԣ��ȶԳ���������Ȼ��� �� �ö��ַ��� ����������У�LIS�����ɡ�
    ʱ�临�Ӷ�Ϊ��O(nlogn) �� DP �ⷨ�Ļ���Ҫ O(N^2)�ˡ�

/*
You have a number of envelopes with widths and heights given as a pair of integers (w, h).
One envelope can fit into another 
if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], 
the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
*/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes  == null || envelopes.length == 0) {
            return 0;
        }
    }
}