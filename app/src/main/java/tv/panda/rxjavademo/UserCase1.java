package tv.panda.rxjavademo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by zourongbo on 2017/1/20.
 */

public class UserCase1 {
    public static final String TAG = "RxJavaDemo";

    // 给出任意一组数字字符串数
    // 得到大于1的数字
    // 去掉重复数字
    // 取前三位数字
    // 进行输出

    public static void compute() {
        String[] num = {"0", "1", "2", "2", "3", "4", "5"};
        List<Integer> data = new ArrayList<>(3);
        for (int i = 0; i < num.length; i++) {
            int a = Integer.parseInt(num[i]);
            if (a > 1) {
                for (int j = 0; j < data.size(); j++) {
                    if (a != data.get(j)) {
                        data.add(a);
                        if (data.size() < 4) {
                            Log.d(TAG, "num = " + a);
                        }
                    }
                }
                if (data.size() == 0) {
                    data.add(a);
                    Log.d(TAG, "num = " + a);
                }
            }
        }
    }

    public static void computeWithRxJava() {
        String[] num = {"0", "1", "2", "2", "3", "4", "5"};
        Observable.from(num)
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return Integer.parseInt(s);
                    }
                }).filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 1;
                    }
                }).distinct()
                .take(3)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "num = " + integer);
                    }
                });
    }

    public static void computeWithRxJavaAndLambda() {
        String[] num = {"0", "1", "2", "2", "3", "4", "5"};
        Observable.from(num)
                .map(s -> Integer.parseInt(s))
                .filter(s -> s > 1)
                .distinct()
                .take(3)
                .subscribe(s -> Log.d(TAG, "num = " + s));
    }
}
