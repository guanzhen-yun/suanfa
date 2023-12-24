package com.tantan.suanfa.offer.chacter2.danli_test2;

// 饿汉式
public class Singleton1 {

  private Singleton1() {}

  private static final Singleton1 singleton1 = new Singleton1();

  public static Singleton1 getInstance() {
    return singleton1;
  }
}
