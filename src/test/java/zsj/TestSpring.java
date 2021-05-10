package zsj;

import com.zsj.core.login.service.LoginService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestSpring {

    @Test
    public void run() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LoginService as = (LoginService) ac.getBean("loginService");
        as.queryUser(1);
    }

    //    public static void main(String[] args) {
//
////        Optional<Integer> optional1 = Optional.ofNullable(1);
////        Optional<Integer> optional2 = Optional.ofNullable(1);
////        System.out.println(optional1 == optional2);// true
//
//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//
//        // 如果不是null,调用Consumer
//        optional1.ifPresent(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer t) {
//                System.out.println("value is " + t);
//            }
//        });
//
//        // null,不调用Consumer
//        optional2.ifPresent(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer t) {
//                System.out.println("value is " + t);
//            }
//        });
//
//    }
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        Count count = new Count();
        // 100个线程对共享变量进行加1
        for (int i = 0; i < 1000; i++) {
//        service.execute(() -> count.increase());
            service.execute(new Runnable() {
                @Override
                public void run() {
                    count.increase();
                }
            });
        }

        // 等待上述的线程执行完
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);


        System.out.println("公众号：Java3y---------");
        System.out.println(count.getCount());
    }

}

class Count {

    // 共享变量
    private Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public synchronized void increase() {
        count++;
    }
}
