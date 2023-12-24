package com.tantan.suanfa.offer.chacter2.danli_test2;

//静态内部类
public class Singleton4 {

  private Singleton4() {
  }

  private static class SingletonHandler {

    private final static Singleton4 instance = new Singleton4();
  }

  public static Singleton4 getInstance() {
    return SingletonHandler.instance;
  }

}
