public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();

        for(Suit suit : deck.getSuits()){
            for(Card card : suit.getCards()){
                System.out.println(String.format("%s of %s", card.getRank(), card.getType()));
            }
        }
    }
}
