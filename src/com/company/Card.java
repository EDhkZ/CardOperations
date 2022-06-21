package com.company;

public class Card {

    private float deposit;

    private String numberCard;

    private String paySystem;

    private int countTransactions = 0;

    private String[] transactions = new String[50];

    private String currency;

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



    public void pay(float sumPay) {
        //списать сумму покупки с карты
        boolean payStatus;
        byte tryed=0;
        do {
            payStatus = withdrawal(sumPay);
            String transaction = null;
            if (payStatus) { // payStatus == true
                transaction = paySystem + " " + numberCard + ":Хаха " + " Покупка " + sumPay + " Остаток на сёте " + deposit;
                setTransactions(transaction);
            } else {
                tryed++;
                System.out.println(transaction);
            }
        } while (!payStatus && tryed < 3);
        //Это я уже сделал
        /*
        TODO: перевести сумму на счёт магазина
         */
    }

    public void transfer(float sumTransfer) {
        //нужно рассчитать коммисию за перевод
        float comission;
        if (sumTransfer < 50000) {
            comission = 0.0f;
        } else {comission = sumTransfer * 0.01f;}

        //затем списать деньги с карты
        boolean transferStatus;
        float amount = sumTransfer+comission;
        byte errortransfer = 0;
        do {
            transferStatus = withdrawal(amount);
            if (deposit > amount) {
                String transaction = paySystem + " " + numberCard + ": " + " Переведено " + sumTransfer + " Комиссия составила " + comission + " Остаток на счёте " + deposit;
                setTransactions(transaction);
            } else {
                errortransfer++;
                System.out.println("Недостаточно средств для перевода, пополните карту");
            }
        }while (!transferStatus && errortransfer < 3);
        // перевести деньги на другую карту
        //и перевести деньги банку
    }

    private boolean withdrawal(float sum) {
        deposit = deposit - sum;
        if (deposit >=0) return true;
        else return false;
    }



}
