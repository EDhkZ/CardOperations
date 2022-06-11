package com.company;

public class Main {

    public static void main(String[] args) {
        Card visaCard = new Card();
        visaCard.setDeposit(7100.00f);
        visaCard.setNumberCard("1111 1111 1111 1111");
        visaCard.setPaySystem("VISA");
        visaCard.pay(100.50f);
        visaCard.pay(250.00f);
        visaCard.transfer(100.00f);


        System.out.println("\nCard transactions" + visaCard.getPaySystem() + " " + visaCard.getNumberCard() + ": ");
        String[] transactions = visaCard.getTransactions();
        int countTransactions = visaCard.getCountTransactions();
        for (int id = 0; id < countTransactions; id++) {
            System.out.println("Operation #" + id + " card" + transactions[id]);
        }

        Card mastercard = new Card();
        mastercard.setDeposit(5600.00f);
        mastercard.setNumberCard("2222 2222 2222 2222");
        mastercard.setPaySystem("MASTERCARD");
        mastercard.pay(500.25f);

        Card unionPay = new Card();
        unionPay.setDeposit(6000.00f);
        unionPay.setNumberCard("3333 3333 3333 3333");
        unionPay.setPaySystem("UNIONPAY");
        unionPay.pay(100.00f);

        //создадим массив карт
        Card[] cards = new Card[3];
        cards[0] = visaCard;
        cards[1] = mastercard;
        cards[2] = unionPay;

        cards[0].pay(100.00f);
        cards[1].pay(200.00f);
        cards[2].pay(300.00f);


        System.out.println("Transactions on all cards: ");
        for (int idCard = 0; idCard < cards.length; idCard++) {
            Card card = cards[idCard];
            String[] cardTransactions = card.getTransactions();
            int cardCountTransactions = card.getCountTransactions();

            for (int id = 0; id < cardCountTransactions; id++) {
                System.out.println("Operation #" + id + " card " + cardTransactions[id]);
            }
        }


    }
}

