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
}
