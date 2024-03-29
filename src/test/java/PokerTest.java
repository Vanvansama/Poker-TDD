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
    public void should_throw_error_when_compare_given_error_card() {
        String result = "";
        try {
            CardSet a = new CardSet("MC 3C 5C 6C 7C");
        } catch (RuntimeException e) {
            result = e.getMessage();
        }
        Assert.assertEquals(result, "error card");
    }

    @Test
    public void should_return_big_card_when_compare_two_card() {
        CardSet a = new CardSet("2C 3C 5S 6C 7C");
        CardSet b = new CardSet("3C 6S 7C 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, -1);
    }

    @Test
    public void should_return_big_card_when_compare_give_one_card_error() {
        String result = "";
        try {
            CardSet b = new CardSet("3C 6C 7C 8C 101C");
        } catch (RuntimeException e) {
            result = e.getMessage();
        }

        Assert.assertEquals(result, "error card");
    }

    @Test
    public void should_return_big_card_when_compare_two_card_diff() {
        CardSet b = new CardSet("2C 3S 7D 6C 4C");
        CardSet a = new CardSet("3C 9S 7D 8C 5C");

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
        CardSet a = new CardSet("3C 3C 5S 6D 7C");
        CardSet b = new CardSet("3C 6C 7S 8D 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_two_card_with_diff_pair() {
        CardSet a = new CardSet("3C 3H 5C 6C 7C");
        CardSet b = new CardSet("3C 6S 7C 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_two_card_with_two_pair() {
        CardSet a = new CardSet("3C 3H 5D 5S 7C");
        CardSet b = new CardSet("3C 6C 7D 8S 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_one_card_with_two_pair_another_with_one_pair() {
        CardSet a = new CardSet("3C 3H 5D 5S 7C");
        CardSet b = new CardSet("6C 6S 7D 8C 9C");

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

    @Test
    public void should_return_big_card_when_compare_one_card_with_straight_another_with_three_of_a_kind() {
        CardSet a = new CardSet("3C 4H 5D 6S 7C");
        CardSet b = new CardSet("6C 6C 6S 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_one_card_with_straight_another_with_flush() {
        CardSet a = new CardSet("3C 4H 5D 6S 7C");
        CardSet b = new CardSet("6C 6C 6C 8C 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, -1);
    }

    @Test
    public void should_return_big_card_when_compare_one_card_with_full_house_another_with_flush() {
        CardSet a = new CardSet("3D 4S 5D 6C 7D");
        CardSet b = new CardSet("6C 6S 6C 9D 9C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, -1);
    }

    @Test
    public void should_return_big_card_when_compare_one_card_with_full_house_another_with_four_of_a_kind() {
        CardSet a = new CardSet("3D 3D 5D 3D 3D");
        CardSet b = new CardSet("9C 9S 9C 5D 5C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_big_card_when_compare_one_card_with_straight_flush_another_with_four_of_a_kind() {
        CardSet a = new CardSet("3D 3S 5D 3S 3D");
        CardSet b = new CardSet("3C 4C 5C 7C 6C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, -1);
    }

    @Test
    public void should_return_big_card_when_compare_one_card_with_straight_flush_another_with_royal() {
        CardSet a = new CardSet("10D JD QD KD AD");
        CardSet b = new CardSet("3C 4C 5C 7C 6C");

        int result = a.compareTo(b);

        Assert.assertEquals(result, 1);
    }
}
