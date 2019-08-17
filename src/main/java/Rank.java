/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 22:19 2019/8/17
 * @Description:
 */
public enum Rank {
    ACE("A", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5),
    SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9), TEN("10", 10),
    JACK("J", 11), QUEEN("Q", 12), KING("K", 13);

    private final String name;
    private final Integer value;

    Rank(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public static Integer getRankValue(String name) {
        for (Rank rank : Rank.values()) {
            if (rank.getName().equals(name)) {
                return rank.getValue();
            }
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
