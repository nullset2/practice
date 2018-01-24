public class Card {
    //non zero-based to use as symbols in other places for readability
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING= 13;
    public final static int ACE = 14;

    private int rank;
    private SuitType type;

    public Card(int rank, SuitType type) {
        this.rank = rank;
        this.type = type;
    }

    public int getRank() {
        return rank+2;//offsetting to account for 0-based and ace
    }

    public String getType(){
        return this.type.toString().toLowerCase();
    }
}
