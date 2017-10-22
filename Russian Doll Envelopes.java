�������ǿ���һ���򵥵������
    �����ŷ�ĳ��Ϳ����ظ���
    �������ǿ��ԣ��ȶԳ���������Ȼ��� �� �ö��ַ��� ����������У�LIS�����ɡ�
    ʱ�临�Ӷ�Ϊ��O(nlogn) �� DP �ⷨ�Ļ���Ҫ O(N^2)�ˡ�

�����������������Ǹ����������������ڳ����߿���ȵ����������������£�
һ���ŷ����޷���װ����һ�� ��/�� ��ȵ�һ���ŷ��еġ�����������ʹ����һ�����ɣ�
    ��Ȼ�ȶ��ŷ�ĳ����� ��С���� �����򣬵�������ȵ�ʱ�򣬶Կ�Ƚ��� �Ӵ�С ������
    ��߶���Ƚ��� �Ӵ�С ��������Ϊ��ʹ�ã����������ʱ����������ŷ���������ǰ��ġ�
    �����ͱ����˻Ὣ������ȣ����ǿ�ȸ�С���ŷ�װ��һ����ȸ�����ŷ��е������
    ���磺 [[5,4],[5,5],[6,7],[2,3]], ����������ʱ�������Ȼ���� ��С���� ������Ļ������Ϊ��[[2,3],[5,4],[5,5],[6,7]]
    �ͻ���֣�[5,4] => [5,5],���� ��4��5 ���ŷ�װ�� ��5��5 ���ŷ��е�����������Ǵ���ġ�
    ��������������ʱ������Ȱ��� �Ӵ�С ��˳�����еĻ������Ϊ��[[2,3],[5,5],[5,4],[6,7]].
    �������ܱ�֤�����п�ȴ���ǰ���ŷ��ȵ��ŷ�ĳ��ȱض��Ǵ���֮ǰ�ŷⳤ�ȵġ����Ƚ��ƣ�������˼���Ŵ���Ѿ�����ˣ�
    ���ֻ��Ҫ�� �ŷ�Ŀ�� ��LIS���ɡ����ʹ���˶��ֲ�����С��β����ķ�������Ϊ������Դﵽ O(nlogn) ��ʱ�临�Ӷȡ�
    
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
        if (envelopes == null || envelopes.length == 0
           || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }
        // ���ŷ����Լ���õ�����
        Arrays.sort(envelopes, new Comparator<int[]>(){
           public int compare(int[] arr1, int[] arr2) {
               if (arr1[0] != arr2[0]) {
                   return arr1[0] - arr2[0];
               } else {
                   return arr2[1] - arr1[1];
               }
           } 
        });
        
        // ��ʼ����С��β����
        int[] minLast = new int[envelopes.length];
        Arrays.fill(minLast, Integer.MAX_VALUE);
        // ������С��β���飬���ȵ� LIS
        for (int i = 0; i < envelopes.length; i++) {
            int index = binarySearch(minLast, envelopes[i][1]);
            minLast[index] = envelopes[i][1];
        }
        
        for (int i = minLast.length - 1; i >= 0; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i + 1;
            }
        }
        return 0;
    }
    
    // ����������Ѱ�� minLast �����е�һ�����ڵ��� n ����
    public static int binarySearch(int[] minLast, int n) {
        int start = 0;
        int end = minLast.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (minLast[mid] < n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}
