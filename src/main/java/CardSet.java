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

    public static final int ONE_PAIR = 20;
    public static final int MAX_CARD_NUMBER = 5;
    public static final int MAX_ONE_CARD_POINT = 14;

    private Card[] cards = new Card[5];

    public CardSet(String cards) {
        Card[] cardArray = splitCards(cards);
        sort(cardArray);
        this.cards = cardArray;
    }

    private Card[] splitCards(String cards) {
        String[] cardStringArray = cards.split(" ");
        Card[] cardArray = new Card[MAX_CARD_NUMBER];
        for (int i = 0; i < cardStringArray.length; i++) {
            Card card = new Card(cardStringArray[i]);
            cardArray[i] = card;
        }
        return cardArray;
    }

    private void sort(Card[] cards) {
        Arrays.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if (o1.getRank() != o2.getRank()) {
                    return o1.getRank() > o2.getRank() ? 1 : -1;
                } else {
                    return 0;
                }
            }
        });
    }

    private int getHigh() {
        int max = 0;
        for (Card c : cards) {
            if (c.getRank() > max) {
                max = c.getRank();
            }
            if (c.getRank() == 1) {
                max = MAX_ONE_CARD_POINT;
            }
        }
        return max;
    }

    private int getPair() {
        int res = 0;
        for (int i = 0; i < MAX_CARD_NUMBER; i++) {
            for (int j = i + 1; j < MAX_CARD_NUMBER; j++) {
                if (cards[i].getRank() == cards[j].getRank()) {
                    res++;
                }
            }
        }
        return res;
    }

    private int getPoints() {
        if (getPair() == 1) {
            return ONE_PAIR;
        } else {
            return getHigh();
        }
    }

    @Override
    public int compareTo(Object o) {
        if (this.getPoints() != ((CardSet) o).getPoints()) {
            if (this.getPoints() > ((CardSet) o).getPoints()) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }
}
