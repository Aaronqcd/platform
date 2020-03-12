package com.shop.platform.test;

import com.shop.platform.model.PhoneBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneBookSearch {
    private int count = 0;

    public static void main(String args[]) {
        List<PhoneBook> phoneBookList = new ArrayList<>();
        PhoneBookSearch phoneBookSearch = new PhoneBookSearch();
        phoneBookSearch.initPhoneBook(phoneBookList);
        long start = System.currentTimeMillis();
        for(int i=0; i<20000; i++) {
            phoneBookSearch.searchPhoneBook("同学"+i, phoneBookList);
        }
        long end = System.currentTimeMillis();
        System.out.println("count: " + phoneBookSearch.count);
        System.out.println((end-start) + "毫秒");
    }

    private void searchPhoneBook(String name, List<PhoneBook> phoneBookList) {
        Iterator iterator = phoneBookList.iterator();
        while(iterator.hasNext()) {
            PhoneBook phoneBook = (PhoneBook) iterator.next();
            if(phoneBook.getName().equals(name)) {
                count++;
                /*System.out.println("姓名：" + phoneBook.getName() + " 电话：" + phoneBook.getPhone() +
                        " 地址：" + phoneBook.getAddress());*/
                return;
            }
        }
    }

    private void initPhoneBook(List<PhoneBook> phoneBookList) {
        for(int i=0; i<20000; i++) {
            PhoneBook phoneBook = new PhoneBook();
            phoneBook.setName("同学" + i);
            phoneBook.setPhone("电话" + i);
            phoneBook.setAddress("地址" + i);
            phoneBookList.add(phoneBook);
        }
    }
}
