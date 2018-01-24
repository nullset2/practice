import java.util.ArrayList;

public class Deck {
    private ArrayList<Suit> suits;

    public ArrayList<Suit> getSuits() {
        return suits;
    }

    public Deck(){
        this.suits = new ArrayList<>();

        for(SuitType type : SuitType.values()){
           this.suits.add(new Suit(type));
        }
    }

    public Card getCard(Rank rank, SuitType suit){
        return this.suits.get(suit.ordinal()).getCard(rank);
    }
}
