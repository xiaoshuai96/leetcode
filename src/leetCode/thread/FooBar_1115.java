package leetCode.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 *
 * 两个不同的线程将会共用一个 FooBar 实例。
 * 其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。
 * 其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 *
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 */
public class FooBar_1115 {
    class Foobar{
        private int n;
        //阻塞队列
        private BlockingQueue<Integer> queue2 = new ArrayBlockingQueue(1);
        private BlockingQueue<Integer> queue1 = new ArrayBlockingQueue(1);
        void FooBar(int n)  {
            this.n = n;
        }
        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                queue1.put(1);
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                queue2.put(1);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                queue2.take();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                queue1.take();
            }
        }
    }
}
