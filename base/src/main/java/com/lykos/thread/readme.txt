此包放置有关线程的操作




                                                线程有关内容
MultiThreadTest 包括java.util.concurrent下线程池应用,此接口可以保证所有子线程执行完,得到结果后,再执行主线程
    /**
	 * Callable 和 Future接口
	 * Callable是类似于Runnable的接口，实现Callable接口的类和实现Runnable的类都是可被其它线程执行的任务。
	 * Callable和Runnable有几点不同：
	 * （1）Callable规定的方法是call()，而Runnable规定的方法是run().
	 * （2）Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。
	 * （3）call()方法可抛出异常，而run()方法是不能抛出异常的。
	 * （4）运行Callable任务可拿到一个Future对象，
	 * Future 表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。
	 * 通过Future对象可了解任务执行情况，可取消任务的执行，还可获取任务执行的结果。
	 */


SynCountTest  CountDownLatch，一个同步辅助类.
    构造方法参数指定了计数的次数
    countDown方法，当前线程调用此方法，则计数减一
    awaint方法，调用此方法会一直阻塞当前线程，直到计时器的值为0





ThreadLocalTest ThreadLocal类的应用
    ThreadLocal为每个使用该变量的线程提供独立的变量副本
    在ThreadLocal类中有一个Map，用于存储每一个线程的变量副本，Map中元素的键为线程对象，而值对应线程的变量副本