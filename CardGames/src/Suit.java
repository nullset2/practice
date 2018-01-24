import java.util.ArrayList;

public class Suit {
    private ArrayList<Card> cards;
    private SuitType type;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Suit(SuitType type){
        this.type = type;
        this.cards = new ArrayList<>();

        for(Rank rank : Rank.values())
            cards.add(new Card(rank, type));
    }

}
