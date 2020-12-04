import java.util.HashMap;

public class Bank {
    private String bankName;
    private HashMap<String, Branch> bankBranches;

    public Bank(String bankName) {
        this.bankName = bankName;
        bankBranches = new HashMap<>();

    }

    public void addBankBranch(Branch b) {
        bankBranches.put(b.getBranchName(), b);
    }

    public void printAllBankBranches() {
        for (String i : bankBranches.keySet()) {
            System.out.println(bankBranches.get(i).getBranchName());
        }
    }

    public void printBranchData(String branchName){
        // get branch clients
        System.out.println("Branch: "+branchName.toUpperCase());
        System.out.println("---------------------------------------");
        bankBranches.get(branchName).printAllBranchCustomers();
        System.out.println("---------------------------------------");
    }

    private boolean isBranch(String branchName){
        if(bankBranches.containsKey(branchName))
            return true;
        else
            return false;
    }

    public String getBankName() {
        return bankName;
    }

}
