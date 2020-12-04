import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {

    private class customerInfo {
        private String name;
        private String number;
        private String address;
        private double balance;

        public customerInfo(String name, String number, String address, double balance){
            this.name=name;
            this.number=number;
            this.address=address;
            this.balance=balance;
        }

        public void addTrans(double amount){
            this.balance+=amount;
        }

        public void updateData(){
            Scanner scan = new Scanner(System.in);
            boolean quit =false;
            String option;
            while(!quit){
                option=scan.nextLine();
                switch (option){
                    case "quit":quit=true;
                    break;
                    case "name":this.name = scan.nextLine();
                    break;
                    case"number":this.number = scan.nextLine();
                    break;
                    case"address":this.address=scan.nextLine();
                    break;
                    default:quit=true;
                }
            }
        }

        public void display(){
            System.out.println("Name: "+this.name+"\n"+"Balance: "+this.balance);
        }

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

        public String getAddress() {
            return address;
        }

        public double getBalance() {
            return balance;

        }
    }
    private int customerAccount=1;
    private HashMap<Integer, customerInfo>cont = new HashMap<>();
    private customerInfo cInfo;
    private ArrayList<Double>transactions;

    public Customer(String name, String number, String address, double initialBalance){
        cInfo=new customerInfo(name, number, address, initialBalance);
        this.customerAccount=accountGen();
        cont.put(this.customerAccount,cInfo);
        transactions=new ArrayList<>();
        transactions.add(initialBalance);
    }

    public void depositAmount(double amount){
        cont.get(getCustomerAccount()).addTrans(amount);
        transactions.add(amount);
    }

    public void withdrawAmount(double amount){
        if(cInfo.getBalance()+amount<0)
            System.out.println("We are sorry but your balance if insufficient for the chosen transaction");
        else {
            cont.get(getCustomerAccount()).addTrans(-amount);
            transactions.add(amount);
        }
    }

    public void checkBalance(){
        try {
            System.out.println("=================================");
            System.out.print("Account: "+this.customerAccount+"\n");
            cont.get(this.customerAccount).display();
            System.out.println("Transactions: ");
            for(double d : transactions)
                System.out.println("   -> "+d);
            System.out.println("=================================");
        }
        catch (InputMismatchException e){
            System.out.println("iar eroare");
        }
        //mai vezi catch/throw error
    }

    public void getCustomerData(int customerAccount){

        System.out.println("=================================");
        System.out.println("Name: " + cInfo.getName() + "\n" +
                "Account: " + this.customerAccount + "\n" +
                "Phone Number: " + cInfo.getNumber() + "\n" +
                "Address: " + cInfo.getAddress() + "\n" +
                "Balance: " + cInfo.getBalance());
        System.out.println("=================================");

    }

    public void removeCustomer(int customerAccount){
        cont.remove(customerAccount);
        transactions.clear();
    }

    private int accountGen(){
        int x;
        for (int i=0;i<9;i++){
            x=(int)(Math.random()*9+1);
            this.customerAccount=this.customerAccount*10+x;
        }
        return (Math.abs(this.customerAccount));
    }

    public void updateCustomerData(){
        cInfo.updateData();
    }

    public int getCustomerAccount() {
        return customerAccount;
    }
    
    public void saveToDoc(FileWriter fw, int customerAccount) {
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("customerData.txt")));
            while(scan.hasNextLine()) {
                String input = scan.nextLine();
                String[] data = input.split(",");
            }
                fw.write("Customer account: "+this.customerAccount+","+"Name: "+cInfo.getName()+","+" Adress: "+
                        cInfo.getAddress()+","+"Customer phone contact: "+cInfo.getNumber()+
                        ","+"Balance: "+cInfo.getBalance()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
