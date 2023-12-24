package com.tantan.suanfa.others.threaddayin;

import org.junit.Test;

/**
 * 两个线程循环打印121212...
 */
public class ThreadPrint {

  final Object object = new Object();
  volatile boolean flag = true;

  @Test
  public void main() {
    printNum2();
  }

  private void printNum2() {
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();
    t1.start();
    t2.start();
  }

  class MyThread extends Thread {

    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        if (flag) {
          System.out.println("1");
        } else {
          System.out.println("2");
        }
        flag = !flag;
      }
    }
  }

  private void printNum1() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          synchronized (object) {
            System.out.println("1");
            object.notify();
            try {
              object.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          synchronized (object) {
            System.out.println("2");
            object.notify();
            try {
              object.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }
        }
      }
    }).start();
  }
}
