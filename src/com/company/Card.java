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
        //������� ����� ������� � �����
        boolean payStatus;
        byte tryed=0;
        do {
            payStatus = withdrawal(sumPay);
            String transaction = null;
            if (payStatus) { // payStatus == true
                transaction = paySystem + " " + numberCard + ":���� " + " ������� " + sumPay + " ������� �� ��� " + deposit;
                setTransactions(transaction);
            } else {
                tryed++;
                System.out.println(transaction);
            }
        } while (!payStatus && tryed < 3);
        //��� � ��� ������
        /*
        TODO: ��������� ����� �� ���� ��������
         */
    }

    public void transfer(float sumTransfer) {
        //����� ���������� �������� �� �������
        float comission;
        if (sumTransfer < 50000) {
            comission = 0.0f;
        } else {comission = sumTransfer * 0.01f;}

        //����� ������� ������ � �����
        boolean transferStatus;
        float amount = sumTransfer+comission;
        byte errortransfer = 0;
        do {
            transferStatus = withdrawal(amount);
            if (deposit > amount) {
                String transaction = paySystem + " " + numberCard + ": " + " ���������� " + sumTransfer + " �������� ��������� " + comission + " ������� �� ����� " + deposit;
                setTransactions(transaction);
            } else {
                errortransfer++;
                System.out.println("������������ ������� ��� ��������, ��������� �����");
            }
        }while (!transferStatus && errortransfer < 3);
        // ��������� ������ �� ������ �����
        //� ��������� ������ �����
    }

    private boolean withdrawal(float sum) {
        deposit = deposit - sum;
        if (deposit >=0) return true;
        else return false;
    }



}
