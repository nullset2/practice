import java.util.ArrayList;

public class Deck {
    private final static int NUMBER_OF_SUITS = 4;
    private ArrayList<Suit> suits;

    public ArrayList<Suit> getSuits() {
        return suits;
    }

    public Deck(){
        this.suits = new ArrayList<Suit>();

        for(SuitType type : SuitType.values()){
           this.suits.add(new Suit(type));
        }


    }
}
