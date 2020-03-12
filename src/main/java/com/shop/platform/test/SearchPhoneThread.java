package com.shop.platform.test;

import com.shop.platform.model.PhoneBook;

import java.util.Iterator;
import java.util.List;

public class SearchPhoneThread implements Runnable {
    private List<PhoneBook> phoneBookList;
    private String name;
    public SearchPhoneThread(String name, List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
        this.name = name;
    }

    @Override
    public void run() {
        Iterator iterator = phoneBookList.iterator();
        while(iterator.hasNext()) {
            PhoneBook phoneBook = (PhoneBook) iterator.next();
            if(phoneBook.getName().equals(name)) {
//                count++;
                System.out.println("姓名：" + phoneBook.getName() + " 电话：" + phoneBook.getPhone() +
                        " 地址：" + phoneBook.getAddress());
                return;
            }
        }
    }
}
