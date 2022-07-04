package com.company;

public class Card {

    private float deposit;

    private String numberCard;

    private String paySystem;

    private int countTransactions = 0;

    private String[] transactions = new String[50];

    private char Currency;//'?'

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getPaySystem() {
        return paySystem;
    }

    public void setPaySystem(String paySystem) {
        this.paySystem = paySystem;
    }

    public int getCountTransactions() {
        return countTransactions;
    }

    public void setCountTransactions(int countTransactions) {
        this.countTransactions = countTransactions;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions[countTransactions++] = transactions;
    }

    public char getCurrency()  {
        return Currency;}
    public void setCurrency(char Currency) {
        this.Currency = Currency;}

    public void pay(float sumPay) {
        //ñïèñàòü ñóììó ïîêóïêè ñ êàðòû
        boolean payStatus;
        byte tryed=0;
        do {
            payStatus = withdrawal(sumPay);
            String transaction = null;
            if (payStatus) { // payStatus == true
                transaction = paySystem + " " + numberCard + ":оплата покупки " + sumPay + " остаток на карте" + deposit;
                setTransactions(transaction);
            } else {
                tryed++;
                System.out.println(transaction);
            }
        } while (!payStatus && tryed < 3);
        //Ýòî ÿ óæå ñäåëàë
        /*
        TODO: ïåðåâåñòè ñóììó íà ñ÷¸ò ìàãàçèíà
         */
    }

    public void transfer(float sumTransfer) {
        //íóæíî ðàññ÷èòàòü êîììèñèþ çà ïåðåâîä
        float comission;
        if (sumTransfer < 50000) {
            comission = 0.0f;
        } else {comission = sumTransfer * 0.01f;}

        //çàòåì ñïèñàòü äåíüãè ñ êàðòû
        boolean transferStatus;
        float amount = sumTransfer+comission;
        byte errortransfer = 0;
        do {
            transferStatus = withdrawal(amount);
            if (deposit > amount) {
                String transaction = paySystem + " " + numberCard + ": " + " сумма перевода " + sumTransfer + Currency + " комиссиия " + comission + Currency + " баланс на счете " + deposit + Currency;
                setTransactions(transaction);
            } else {
                errortransfer++;
                System.out.println("Херня");
            }
        }while (!transferStatus && errortransfer < 3);
        // ïåðåâåñòè äåíüãè íà äðóãóþ êàðòó
        //è ïåðåâåñòè äåíüãè áàíêó привет
    }

    private boolean withdrawal(float sum) {
        deposit = deposit - sum;
        if (deposit >=0) return true;
        else return false;
    }



}
