//Sikemi Odusanya

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Bank {

    private HashMap<String, BankAccount> idAccountMap;
    private ArrayList<String> idList;

    public Bank() {
        this.idAccountMap = new HashMap<>();
        this.idList = new ArrayList<>();
    }


    public void addAccount(String id, BankAccount bankAccount) {
        idAccountMap.put(id,bankAccount);
        idList.add(id);
    }

    public boolean removeAccount(String id) {

        boolean removed = false;

        Iterator<String> iterator = idList.iterator();
        while (iterator.hasNext()) {
            String currentID = iterator.next();
            if (currentID.equals(id)) {
                iterator.remove();
                removed = true;
            }
        }
            if (idAccountMap.containsKey(id)){
                idAccountMap.remove(id);
                removed = true;
            }
            return  removed;
    }

    public void printAllAccounts() {
        for (String currentId : idList) {
            if (idAccountMap.containsKey(currentId)) {
                idAccountMap.get(currentId).printDetails();
            }
        }
    }


    public void printAllSavingsAccounts() {

        for (String currentId : idList) {
            if (idAccountMap.containsKey(currentId)) {
                if (idAccountMap.get(currentId) instanceof SavingsAccount) {
                    idAccountMap.get(currentId).printDetails();
                }
            }
        }
    }
    public void printAllCurrentAccounts() {
        for (String currentId : idList) {
            if (idAccountMap.containsKey(currentId)) {
                if (idAccountMap.get(currentId) instanceof CurrentAccount) {
                    idAccountMap.get(currentId).printDetails();
                }
            }
        }
    }
}

