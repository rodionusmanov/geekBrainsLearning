package homework11_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, ArrayList<String>> nameList;
    ArrayList<String> phoneNumber;

    public PhoneBook() {
        this.nameList = new HashMap<>();
        this.phoneNumber = new ArrayList<>();
    }

    public void add(String name, String phone) {
        if (!nameList.containsKey(name)){
            ArrayList<String> phNum = new ArrayList<>();
            phNum.add(phone);
            nameList.put(name, phNum);
        } else if(!nameList.get(name).contains(phone)){
            nameList.get(name).add(phone);
        }
    }

    public void get(String name){
        if (nameList.containsKey(name)){
            System.out.print(name + " - ");
            System.out.println(nameList.get(name));
        } else {
            System.out.println("Такого человека нет в справочнике");
        }

    }
}
