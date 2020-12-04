import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Branch {
    private final String branchName;
    private final HashMap<Integer, Customer> keyChain;

    public Branch(String branchName){
        this.branchName=branchName;
        keyChain =new HashMap<>();
    }

    public void addBranchCustomer(Customer c){
        if(!isCustomer(c.getCustomerAccount()))
            keyChain.put(c.getCustomerAccount(),c);
        else
            System.out.println("Customer already in the list");
    }

    public void getBranchCustomer(int account){
        if(isCustomer(account))
            keyChain.get(account).getCustomerData(account);
        else
            System.out.println("Searched customer was not found");
        //should get customer from the csv (if console starts new, the buffer is empty so what client will it get???)
    }

    public void printAllBranchCustomers() {
        for (Integer i : keyChain.keySet()) {
            keyChain.get(i).checkBalance();
        }
    }

    public void deleteCustomerAccount(int customerAccount){
        if(isCustomer(customerAccount)) {
            keyChain.get(customerAccount).removeCustomer(customerAccount);
            keyChain.remove(customerAccount);
        }
        else
            System.out.println("Cannot perform operation \n Customer not found");
    }

    public void saveToBranchDoc() {
        ArrayList<String[]>list = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader(getBranchName()+"customerData.txt")));
            while(scan.hasNextLine()) {
                String input = scan.nextLine();
                String[] data = input.split(",");
                list.add(data);
            }
            FileWriter fw = new FileWriter(getBranchName()+"customerData.txt");
            for(String[] i : list){
                fw.write("Customer account: "+i[0]+","+"Name: "+i[1]+","+" Adress: "+
                        i[2]+","+"Customer phone contact: "+i[3]+
                        ","+"Balance: "+"\n");
            }
            for (Integer i : keyChain.keySet())
                keyChain.get(i).saveToDoc(fw, keyChain.get(i).getCustomerAccount());

            fw.close();
            scan.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        //upgrade: if customer account already there, don't add it again
    }

    public void readBranchData(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(getBranchName()+"customerData.txt")));
            while(scanner.hasNextLine()){
                String input = scanner.nextLine();
                String []data = input.split(",");
                System.out.println(data[0]+", "+data[1]+", "+data[2]+", "+data[3]+", "+data[4]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(scanner !=null) {
                scanner.close();
            }
        }
    }

    public void customerUpdate(int customerAccount){
        if(isCustomer(customerAccount))
            keyChain.get(customerAccount).updateCustomerData();
        else
            System.out.println("Customer not found");
    }

    public void findBranchCustomer (int account){
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader(getBranchName() + "customerData.txt")));
            String input = scan.nextLine();
            String []data = input.split(",");
            if(account==Integer.parseInt(data[0])){
                //create to use then delete customer??
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private boolean isCustomer(int account){
        if (keyChain.containsKey(account))
            return true;
        else
            return false;
    }

    public String getBranchName() {
        return branchName;
    }

}
