/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 23:18 2019/8/16
 * @Description:
 */
public class Card {
    private int rank;
    private String suit;

    public Card(String str) {
        if (str.length() == 3) {
            this.rank = Rank.getRankValue(str.substring(0, 2));
            this.suit = String.valueOf(str.charAt(2));
        } else if (str.length() == 2) {
            this.rank = Rank.getRankValue(String.valueOf(str.charAt(0)));
            this.suit = String.valueOf(str.charAt(1));
        }
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
