package tv.panda.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserCase1.compute();
        UserCase1.computeWithRxJava();
        UserCase1.computeWithRxJavaAndLambda();

        UserCase2.compute1WithRxJavaAndLambda();
    }
}
