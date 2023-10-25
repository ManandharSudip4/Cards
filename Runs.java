package cards;

import java.util.Arrays;

public class Runs {
    public static void main(String[] args) {
        String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
        };

        // Sample hands
        String[] hand1 = {"A", "2", "3"};
        String[] hand2 = {"J", "K", "Q"};
        String[] hand3 = {"5", "7", "6"};

        // Check if each hand is a run
        boolean isRun1 = isConsecutiveRun(hand1, ranks);
        boolean isRun2 = isConsecutiveRun(hand2, ranks);
        boolean isRun3 = isConsecutiveRun(hand3, ranks);

        System.out.println("Hand 1 is a run: " + isRun1);
        System.out.println("Hand 2 is a run: " + isRun2);
        System.out.println("Hand 3 is a run: " + isRun3);
    }

    public static boolean isConsecutiveRun(String[] hand, String[] ranks) {
        // Sort the hand based on the custom order of ranks
        Arrays.sort(hand, (rank1, rank2) -> {
            int index1 = Arrays.asList(ranks).indexOf(rank1);
            int index2 = Arrays.asList(ranks).indexOf(rank2);
            return Integer.compare(index1, index2);
        });

        // Check if the sorted hand is a run
        for (int i = 0; i < hand.length - 1; i++) {
            int rank1Index = Arrays.asList(ranks).indexOf(hand[i]);
            int rank2Index = Arrays.asList(ranks).indexOf(hand[i + 1]);

            // Check if the ranks are consecutive based on the custom order
            if (Math.abs(rank2Index - rank1Index) != 1 && !((rank1Index == 0 && rank2Index == ranks.length - 1) || (rank1Index == ranks.length - 1 && rank2Index == 0))) {
                return false;
            }
        }

        return true;
    }
}
