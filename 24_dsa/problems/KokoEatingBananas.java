package problems;

public class KokoEatingBananas {
    public int calculateHours(int[] piles, int k) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }

        return hours;
    }

    public int minEatingSpeedBruteForce(int[] piles, int h) {
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        for (int i = 1; i <= max; i++) {
            int hours = calculateHours(piles, i);

            if (hours <= h) {
                return i;
            }
        }

        return -1;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int hours = calculateHours(piles, mid);

            if (hours > h) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] piles1 = new int[] { 3, 6, 7, 11 };
        int h1 = 8;

        int[] piles2 = new int[] { 30, 11, 23, 4, 20 };
        int h2 = 5;

        int[] piles3 = new int[] { 30, 11, 23, 4, 20 };
        int h3 = 6;

        KokoEatingBananas obj = new KokoEatingBananas();

        System.out.println(obj.minEatingSpeed(piles1, h1));
        System.out.println(obj.minEatingSpeed(piles2, h2));
        System.out.println(obj.minEatingSpeed(piles3, h3));

    }
}
