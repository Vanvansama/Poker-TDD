import java.util.Arrays;
import java.util.Comparator;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 23:22 2019/8/16
 * @Description:
 */
public class CardSet implements Comparable {

    private Card[] cards = new Card[5];

    public CardSet(String cards) {
        String[] cardStringArray = cards.split(" ");
        Card[] cardArray = new Card[5];
        for (int i = 0; i < cardStringArray.length; i++) {
            Card card = new Card(cardStringArray[i]);
            cardArray[i] = card;
        }
        Arrays.sort(cardArray, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if (o1.getRank() != o2.getRank()) {
                    return o1.getRank() > o2.getRank() ? 1 : -1;
                } else {
                    return 0;
                }
            }
        });
        this.cards = cardArray;
    }

    private int getHigh() {
        int max = 0;
        for (Card c : cards) {
            if (c.getRank() > max)
                max = c.getRank();
            if (c.getRank() == 1)
                max = 14;
        }
        return max;
    }

    @Override
    public int compareTo(Object o) {
        if (this.getHigh() != ((CardSet) o).getHigh()) {
            if (this.getHigh() > ((CardSet) o).getHigh())
                return 1;
            else
                return -1;
        } else
            return 0;
    }
}
