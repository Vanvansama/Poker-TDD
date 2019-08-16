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
}
