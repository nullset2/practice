import java.util.ArrayList;

public class Suit {
    private final static int MAX_RANK = Card.ACE;
    private ArrayList<Card> cards;
    private SuitType type;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Suit(SuitType type){
        this.type = type;
        this.cards = new ArrayList<>();

        for(int i = 0; i < MAX_RANK-1; i++)
            cards.add(new Card(i, type));
    }

}
