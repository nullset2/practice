public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();

        for(Suit suit : deck.getSuits()){
            for(Card card : suit.getCards()){
                if(card.getRank() == Card.ACE)
                    System.out.println(String.format("Ace of %s", card.getType()));

                else if(card.getRank() == Card.JACK)
                    System.out.println(String.format("Jack of %s", card.getType()));

                else if(card.getRank() == Card.QUEEN)
                    System.out.println(String.format("Queen of %s", card.getType()));

                else if(card.getRank() == Card.KING)
                    System.out.println(String.format("King of %s", card.getType()));

                else
                    System.out.println(String.format("%d of %s", card.getRank(), card.getType()));
            }
        }
    }
}
