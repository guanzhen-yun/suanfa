package com.tantan.suanfa.offer.chacter2.danli_test2;

//懒汉式-线程安全
public class Singleton3 {

  private Singleton3() {
  }

  private static volatile Singleton3 instance;

  public static Singleton3 getInstance() {
    if (instance == null) {
      synchronized (Singleton3.class) {
        instance = new Singleton3();
      }
    }
    return instance;
  }

}
