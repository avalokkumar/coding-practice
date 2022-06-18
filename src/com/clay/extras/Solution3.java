package extras;

import java.util.Scanner;

/**
 * 100 100 50 40 40 20 10
 * 
 * 5 25 50 120
 *
 */
public class Solution3 {

	static int hurdleRace(int k, int[] height) {
        int maxHeight = 0;
        for (int i=0; i< height.length; i++){
            if(height[i] > maxHeight){
                maxHeight = height[i];
            }
        }

        if(maxHeight <= k){
            return 0;
        }else{
            return maxHeight - k;
        }
    }
	
	/*static int[] climbingLeaderboard(int[] scores, int[] alice) {

		//int[] leaderBoardRank = getLeaderBoardRank(scores);
		int[] distinctScore = Arrays.asList(scores).stream().distinct().collect(Collectors.toList()).toArray(int[]);
		int[] aliceRank = new int[alice.length];

		int lastIndex = distinctScore.length;

		for (int i = 0; i < alice.length; i++) {
			while (lastIndex >= 0) {

				if (alice[i] > distinctScore[lastIndex]) {
					lastIndex--;
				} else {
					System.out.println(lastIndex + 2);
				}

				if (lastIndex < 0) {
					System.out.println(1);
				}
			}
		}

		return aliceRank;
	}*/

	private static int[] getLeaderBoardRank(int[] scores) {
		int[] boardRank = new int[scores.length];
		int c = 1;
		for (int i = 0; i < scores.length - 1; i++) {

			if (scores[i] > scores[i + 1]) {
				boardRank[i] = c++;
			} else if (scores[i] == scores[i + 1]) {
				boardRank[i] = c;
			}
		}
		boardRank[scores.length - 1] = c;

		return boardRank;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int scoresCount = scanner.nextInt();

		int[] scores = new int[scoresCount];

		for (int i = 0; i < scoresCount; i++) {
			scores[i] = scanner.nextInt();
		}

		int aliceCount = scanner.nextInt();

		int[] alice = new int[aliceCount];

		for (int i = 0; i < aliceCount; i++) {
			alice[i] = scanner.nextInt();
		}

		int[] result = null;
		//climbingLeaderboard(scores, alice);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		scanner.close();
	}
}

/**
 * 
 * for (int i = 0; i < alice.length; i++) { for (int j = 0; j < scores.length -
 * 1; j++) {
 * 
 * if (alice[i] == scores[j]) { aliceRank[i] = leaderBoardRank[j]; break; } else
 * if (alice[i] > scores[j]) { aliceRank[i] = (leaderBoardRank[j] > 1) ?
 * leaderBoardRank[j]-1 : leaderBoardRank[j]; break; } else if (alice[i] <
 * scores[j] && alice[i] > scores[j + 1]) { aliceRank[i] = leaderBoardRank[j] +
 * 1; break; } else if (alice[i] < scores[j] && j == scores.length - 2) {
 * aliceRank[i] = leaderBoardRank[j + 1] + 1; break; } } }
 */
