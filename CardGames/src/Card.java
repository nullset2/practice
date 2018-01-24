public class Card {
    private Rank rank;
    private SuitType type;

    public Card(Rank rank, SuitType type) {
        this.rank = rank;
        this.type = type;
    }

    public String getRank() {
        return this.rank.toString().toLowerCase();
    }

    public String getType() {
        return this.type.toString().toLowerCase();
    }

    public boolean greaterThan(Card card) {
        return this.rank.ordinal() > card.rank.ordinal();
    }
}
