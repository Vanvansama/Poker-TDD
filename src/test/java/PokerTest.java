import org.junit.Assert;
import org.junit.Test;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 22:44 2019/8/16
 * @Description:
 */
public class PokerTest {

    private CardSet cardSet;

    @Test
    public void should_return_big_card_when_compare_two_card() {
        CardSet a = new CardSet("2C 3C 5C 6C 7C");
        CardSet b = new CardSet("3C 6C 7C 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, -1);
    }

    @Test
    public void should_return_big_card_when_compare_two_card_diff() {
        CardSet b = new CardSet("2C 3C 7C 6C 4C");
        CardSet a = new CardSet("3C 9C 7C 8C 5C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_two_card_with_suit() {
        CardSet a = new CardSet("2C 3D 5C 6C 7C");
        CardSet b = new CardSet("3C 6C 7C 8H 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, -1);
    }

    @Test
    public void should_return_big_card_when_compare_two_card_with_pair() {
        CardSet a = new CardSet("3C 3C 5C 6C 7C");
        CardSet b = new CardSet("3C 6C 7C 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_two_card_with_diff_pair() {
        CardSet a = new CardSet("3C 3H 5C 6C 7C");
        CardSet b = new CardSet("3C 6C 7C 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_two_card_with_two_pair() {
        CardSet a = new CardSet("3C 3H 5D 5S 7C");
        CardSet b = new CardSet("3C 6C 7C 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_one_card_with_two_pair_another_with_one_pair() {
        CardSet a = new CardSet("3C 3H 5D 5S 7C");
        CardSet b = new CardSet("6C 6C 7C 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_one_card_with_three_another_with_two_pair() {
        CardSet a = new CardSet("3C 3H 5D 5S 7C");
        CardSet b = new CardSet("6C 6C 6S 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, -1);
    }

    @Test
    public void should_return_big_card_when_compare_one_card_with_three_another_with_one_pair() {
        CardSet a = new CardSet("3C 3H 4D 5S 7C");
        CardSet b = new CardSet("6C 6C 6S 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, -1);
    }
}
