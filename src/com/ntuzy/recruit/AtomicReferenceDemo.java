package com.ntuzy.recruit;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author IamZY
 * @create 2020/1/22 16:40
 */
class User {
    private String userName;
    private int age;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}

public class AtomicReferenceDemo {


    public static void main(String[] args) {

        User u1 = new User("z3", 22);
        User u2 = new User("li4", 25);

        AtomicReference<User> objectAtomicReference = new AtomicReference<>();

        objectAtomicReference.set(u1);


        System.out.println(objectAtomicReference.compareAndSet(u1, u2) + "\t" + objectAtomicReference.get().toString());
        System.out.println(objectAtomicReference.compareAndSet(u1, u2) + "\t" + objectAtomicReference.get().toString());


    }

}
