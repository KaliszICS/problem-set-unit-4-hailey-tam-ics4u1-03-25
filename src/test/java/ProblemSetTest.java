//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.beans.Transient;
import java.io.*;

public class ProblemSetTest {

   //Create your tests here if you want any

   /*

   //Example Test
   
   @Test
   public void exampleTest()
   {
      Cat cat = new Cat();
      assertEquals("whiskers", cat.getName());
   }
   */

   @Test
   public void testCardName1(){
      Card card = new Card("Ace", "Hearts", 1);
      assertEquals("Ace", card.getName());
   }

     @Test
   public void testCardName2(){
      Card card = new Card(null, null, 0);
      assertEquals("0", card.getName());
   }

     @Test
   public void testCardName3(){
      Card card = new Card("null", null, 0);
      assertEquals("null", card.getName());
   }

   @Test
   public void testCardSuit1(){
      Card card = new Card(null, null, 1);
      assertEquals("blank", card.getSuit());
   }

   
   
   @Test
   public void testCardToString(){
      Card card = new Card("Ace", "Hearts", 1);
      assertEquals("Ace of Hearts", card.toString());
   }

   @Test
   public void testDeckAdd1(){
      Deck deck = new Deck();
        assertEquals(52, deck.size());
        Card card = null;
        deck.addCard(card);
        assertEquals(52, deck.size());
   }

    @Test
   public void testDeck2(){
       Card[] cards = null;
      Deck deck = new Deck(cards);
        assertEquals(0, deck.size());
   }

    @Test
   public void testShuffling(){
      Card[] cards = new Card[]{
         new Card("Ace", "Hearts", 1),
         new Card("A2", null, 3),
         new Card(null, null, 52),
         new Card("A2", "AS", 3),
         new Card("He", "Frog", 52),
         null
      };

      Deck deck = new Deck(cards);
      assertEquals(5, deck.size());
      deck.shuffle();
      // assertEquals("", deck.draw());
     
   }


    @Test
   public void testDrawingSize(){
      Card[] cards = new Card[]{
         new Card("Ace", "Hearts", 1),
         new Card("A2", null, 3),
         new Card(null, null, 52),
         new Card("A2", "AS", 3),
         new Card("He", "Frog", 52)
      };

      Deck deck = new Deck(cards);
       assertEquals(5, deck.size());
   }

    @Test
   public void testDrawing(){
      Card[] cards = new Card[]{
         new Card("Ace", "Hearts", 1),
         new Card("A2", "null", 3),
         new Card("null", "null", 52),
         new Card("A2", "AS", 3),
         new Card("He", "Frog", 52)
      };

      Deck deck = new Deck(cards);
       assertEquals(cards[4], deck.draw());
       assertEquals(4, deck.size());
       assertEquals(cards[3], deck.draw());
       assertEquals(3, deck.size());
       assertEquals(cards[2], deck.draw());
       assertEquals(2, deck.size());
       assertEquals(cards[1], deck.draw());
       assertEquals(cards[0], deck.draw());
       assertEquals(null, deck.draw());
   }

    @Test
   public void testEmptyCardArr(){
      Card[] cards = new Card[]{};
      Deck deck = new Deck(cards);
        assertEquals(0, deck.size());
   }

   @Test
   public void testAddCardDeck1(){
        Card[] cards = new Card[]{
         new Card("Ace", "Hearts", 1),
         new Card("A2", "AS", 3),
         new Card("He", "Frog", 52)
        };

         Deck deck = new Deck(cards);
         deck.addCard(new Card("Duck", "Queen", 15));
         assertEquals(4, deck.size());
      }
   


      @Test
      public void testAddCard2(){
      Deck deck = new Deck();
         deck.addCard(new Card("potato", "Kind", 10));
          deck.addCard(new Card("potato", "Kind", 10));
          deck.addCard(new Card("Duck", "Queen", 15));
          Card card  = null;
         deck.addCard(card);
        assertEquals(55, deck.size());
      }
   

   @Test 
   public void testReshuffle(){
      Deck deck = new Deck();
       Card[] cards = new Card[]{
         new Card("Ace", "Hearts", 1),
         new Card("A2", "AS", 3),
         new Card("He", "Frog", 52),
         new Card("ASD", "Hooray", -2),
         new Card(null, "Hooray", -2),
         new Card(null, null, -2),
         new Card("yep", null, -23)
        };
       deck.reshuffle(cards);
       assertEquals(59, deck.size());
      //  assertEquals("2", deck.draw()); //not equal to the excepted means that the deck did get shuffled
   }

   @Test 
   public void testDiscardPile1(){
      DiscardPile pile = new DiscardPile();
      assertEquals(0, pile.size());
   }

    @Test 
   public void testDiscardPile2(){
      Card[] cards = new Card[]{
         new Card("Ace", "Hearts", 1),
         new Card("A2", null, 3),
         new Card(null, null, 52),
         new Card("A2", "AS", 3),
         new Card("He", "Frog", 52)
      };

      Card card = new Card ("A2", "AS", 3);
      Card card1 = new Card ("A1", "AS", 3);
      DiscardPile pile = new DiscardPile(cards);
      assertEquals(5, pile.size());
      assertEquals(cards[3], pile.removeCard(card));
      assertEquals(4, pile.size());
       assertEquals(null, pile.removeCard(card1));
       assertEquals(4, pile.size());
       Card[] cardsBye = pile.removeAll();
       assertEquals(cards[0], cardsBye[0]);
   }

   @Test 
   public void testDiscardPile3(){
      Card[] cards = new Card[]{
         
      };
      DiscardPile pile = new DiscardPile(cards);
      assertEquals(0, pile.size());
   }

   
   @Test 
   public void testDiscardPile4(){
      DiscardPile pile = new DiscardPile();
      pile.addCard(new Card("Tomato", "Potato", 1100));
       pile.addCard(new Card("Tomato2", "Potato", 1100));
        pile.addCard(new Card("Tomato3", "Potato", 1100));
         pile.addCard(new Card("Tomato4", "Potato", 1100));
          pile.addCard(new Card("Tomato5", "Potato", 1100));
               Card[] dumpPile = pile.removeAll();
              
      assertEquals(0, pile.size());
      assertEquals(new Card("Tomato", "Potato", 1100), dumpPile[0]);
   }


   @Test 
   public void player1(){
         Card[] cards = new Card[]{
         new Card("Ace", "Hearts", 1),
         new Card("A2", null, 3),
         new Card(null, null, 52),
         new Card("A2", "AS", 3),
         // new Card("He", "Frog", 52)
      };

      Deck deck = new Deck(null);
      DiscardPile pile = new DiscardPile();
      Card card = new Card("A2", "AS", 3);
      Card card2 = new Card("Ace", "Hearts", 1);

      Player player = new Player("Me", 2, cards);
      assertEquals(4, player.size());
      // assertEquals("Me, 2, Ace of Hearts, A2 of blank, 0 of blank, A2 of AS.",player.toString());
      // player.draw(deck);
      // assertEquals(5, player.size());
      // assertEquals(true, player.discardCard(card, pile));
      // assertEquals(3, player.size());
      // assertEquals(false, player.discardCard(card, pile));
      // assertEquals(1, pile.size());
      // assertEquals(false, player.returnCard(card, deck));
      // assertEquals(52, deck.size());
       assertEquals(0, deck.size());
      assertEquals(true, player.returnCard(card2, deck));
      assertEquals(3, player.size());
      assertEquals(1, deck.size());
      player.draw(deck);
      assertEquals(4, player.size());
      assertEquals(true, player.discardCard(card, pile));
      assertEquals(3, player.size());
      assertEquals(false, player.discardCard(card, pile));
      assertEquals(1, pile.size());
   }
}