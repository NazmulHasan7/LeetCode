// 3265. Count Almost Equal Pairs I
package Medium;

public class Medium_3265_Count_Almost_Equal_Pairs_I {
    public static int countPairs(int[] nums) {
        int n = nums.length;
        int answer = 0;

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] == nums[j]) {
                    answer++;
                } else {
                    int count = 0;
                    int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
                    int x = nums[i], y = nums[j];

                    while ((x>0 || y>0) && count <= 2) {
                        int d1 = x % 10;
                        int d2 = y % 10;

                        if (d1 != d2) {
                            count++;
                            if (count == 1) {
                                x1 = d1;
                                y1 = d2;
                            } else {
                                x2 = d1;
                                y2 = d2;
                            }
                        }
                        x /= 10;
                        y /= 10;
                    }
                    if (count == 2 && (x1 == y2) && (x2 == y1))
                        answer++;
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{3,12,30,17,21}));
        System.out.println(countPairs(new int[]{1,1,1,1,1}));
        System.out.println(countPairs(new int[]{123,231}));
    }
}
