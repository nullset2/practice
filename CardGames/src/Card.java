public class Card {
    public final static int ACE = 12;
    public final static int JACK = 9;
    public final static int QUEEN = 10 ;
    public final static int KING= 11;

    private int rank;
    private SuitType type;
    public Card(int rank, SuitType type) {
        this.rank = rank;
        this.type = type;
    }

    public int getRank() {
        return rank;
    }

    public SuitType getType() {
        return type;
    }
}
