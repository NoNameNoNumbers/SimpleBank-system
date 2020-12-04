

public class BankingSystemDrive {

    public static void main(String[] args) {

/*
         "Welcome to the SimpleBank 1.0 interface. SimpleBank is a banking system " +
                "where you can add new banks, branches and customers, manage customer transactions." +
                "and update customer data. \n "
*/

        Customer c1 = new Customer("Andrew", "074619094", "address 1", 150);
        Customer c2 = new Customer("John", "038545434", "address 2", 320);
        Customer c3 = new Customer("Alex", "0845345232", "address 3", 1400);
        Customer c4 = new Customer("Sebastian", "0845345232", "address 4", 3143);
        Customer c5 = new Customer("Vlad", "0845345232", "address 5", 2122);


        Branch b1 = new Branch("Branch 1");
        b1.addBranchCustomer(c3);
        b1.addBranchCustomer(c4);

        Bank bank1 = new Bank("FirstBank");
        bank1.addBankBranch(b1);





    }
}

/*
    SimpleBank Instructions
    Create customer object, branch object, bank object
    customer -> branch -> bank

    Bank
        ->bankName
        ->bankBranches
    M.addBankBranch
    M.printBranchData
    M.printAllBankBranches

    Branch
        ->BranchName
        ->keyChain
    M.addBranchCustomer
    M.printAllBranchCustomers
    M.printBranchCustomers
    M.deleteCustomer
    M.saveToBranchDoc
    M.readBranchData
    M.customerUpdateData

    Customer
        ->Account
        =>Name
        =>Balance
    M.addTransaction
    M.checkBalance
    M.depositAmount
    M.withdrawAmount


     */
