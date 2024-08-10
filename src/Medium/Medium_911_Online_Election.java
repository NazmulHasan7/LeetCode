// 911. Online Election
package Medium;

public class Medium_911_Online_Election {
    static class TopVotedCandidate {
        int[] times;
        int[] leadersAgainstTime;
        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            int n = persons.length;
            leadersAgainstTime = new int[n];
            int[] voteCount = new int[n];

            int maxCount = 0, currentWinner = -1;
            for (int i=0; i<n; i++) {
                voteCount[persons[i]]++;
                if (voteCount[persons[i]] >= maxCount) {
                    maxCount = voteCount[persons[i]];
                    currentWinner = persons[i];
                }
                leadersAgainstTime[i] = currentWinner;
            }
        }
        public int q(int t) {
            int low = 0, high = times.length-1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (times[mid] == t)
                    return leadersAgainstTime[mid];
                else if (times[mid] < t)
                    low = mid + 1;
                else high = mid - 1;
            }
            return leadersAgainstTime[high];
        }
    }
    public static void main(String[] args) {
        TopVotedCandidate tvc = new TopVotedCandidate(new int[]{0,1,1,0,0,1,0}, new int[]{0,5,10,15,20,25,30});
        System.out.println(tvc.q(3));
        System.out.println(tvc.q(12));
        System.out.println(tvc.q(25));
        System.out.println(tvc.q(15));
        System.out.println(tvc.q(24));
        System.out.println(tvc.q(8));
    }
}
