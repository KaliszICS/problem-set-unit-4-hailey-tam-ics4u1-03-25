/**
 * Represents the discard pile.
 * This class includes size() method, addCard() method, removeCard() method, removeAll() method, and toString() method.
 * @author Hailey Tam
 */
class DiscardPile {
    private Card[] discardPileOfCards;

    /**
     * Creates a discard pile that initalize an array of cards.
     * If the discard pile is empty or null, the discard pile will be empty.
     * @param cards an array of cards object that contains cards that are in the discard pile.
     */
    public DiscardPile(Card[] cards){
        this.discardPileOfCards = new Card[0];
        if (cards != null && cards.length != 0){
            int vaildLength = 0;
            for (int i = 0; i < cards.length; i++){
                if (cards[i] != null){
                    vaildLength++;
                }
            }
            
            this.discardPileOfCards = new Card[vaildLength];
            int validIndex = 0;
            for (int i = 0; i < cards.length; i++){
                if (cards[i] != null){
                    this.discardPileOfCards[validIndex++] = cards[i];
                }
            }
        }
    }

    /**
     * Creates a default discard pile that contains no cards
     */
    public DiscardPile(){
         this.discardPileOfCards = new Card[0];
    }

    /**
     * Gets the cards that are in the discard pile.
     * @return an array of cards representing playing cards in the discard pile.
     */
    public Card[] getDiscardPile(){
        return this.discardPileOfCards;
    }

    /**
     * Determines the number of playing cards in the discard pile.
     * @return an integer that represents the number of playing cards in the discard pile.
     */
    public int size(){
        return this.discardPileOfCards.length;
    }

    /**
     * Adds a playing card to the discard pile.
     * @param card a Card Object representing a playing card.
     */
    public void addCard(Card card){
        if (card != null){
            Card[] newCards = new Card[size() + 1];
            
            for (int i = 0; i < size(); i++){
                newCards[i] = this.discardPileOfCards[i];
            }
                newCards[newCards.length - 1] = card;
                this.discardPileOfCards = newCards;
            }
        }

    /**
     * Removes a specific card from the discard pile.
     * @param card a Card object that represents a specific card to remove.
     * @return a Card object that returns the specific card if it exists in the discard pile, otherwise returns null.
     */
    public Card removeCard(Card card){
        int index = -1;
        if (card != null){
            for (int i = 0; i < size(); i++){
               if (card.equals(discardPileOfCards[i])){
                    index = i;
                    i = this.discardPileOfCards.length;
                }
            }
        }

        if (index == -1){
            return null;
        }

        int validIndex = 0;
        Card[] newCards = new Card[size() - 1];
        for (int i = 0; i < this.discardPileOfCards.length; i++){
            if (i != index){
            newCards[validIndex++] = this.discardPileOfCards[i];
            }
        }
        this.discardPileOfCards = newCards;
        return card;
    }

    /**
     * Removes all playing cards in the discard pile.
     * @return an array of cards representing cards that were removed from the discard pile.
     */
    public Card[] removeAll(){
        if (size() == 0){
            return this.discardPileOfCards = new Card[0];
        }

        Card[] cardsRemoved = new Card[size()];
        for (int i = 0; i < size(); i++){
            cardsRemoved[i] = this.discardPileOfCards[i];
        }
        this.discardPileOfCards = new Card[0];
        return cardsRemoved;
    }

    @Override
    public String toString(){
        String cards = "";
        if (size() != 0){
            for (int i = 0; i < size() - 1; i++){
                cards += this.discardPileOfCards[i].toString() + ", ";
            }
            cards += this.discardPileOfCards[size() - 1].toString() + ".";
        }
        return cards;
    }
}