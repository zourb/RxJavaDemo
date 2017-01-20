package tv.panda.rxjavademo;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zourongbo on 2017/1/20.
 */

public class UserCase2 {
    public static final String TAG = "RxJavaDemo";
    // 给出任意一组数字字符串数
    // 得到大于1的数字
    // 去掉重复数字
    // 取前三位数字
    // 进行输出
    // 需要在子线程取到三个数，然后在主线程输出

    public static void compute1WithRxJavaAndLambda() {
        String[] num = {"0", "1", "2", "2", "3", "4", "5"};
        Observable.from(num)
                .map(s -> {
                    Log.d(TAG, "map");
                    return Integer.parseInt(s);})
                .filter(s -> {
                    Log.d(TAG, "filter");
                    return s > 1;})
                .distinct()
                .take(3)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> Log.d(TAG, "num = " + s));
    }
}
