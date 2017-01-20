package com.quanmin.guohongxin.handlerdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvTime;
    private int time = 11;

    private Handler nHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 110: {
                    time--;
                    mTvTime.setText(time + "");
                    if (time > -1) {

                        nHandler.sendEmptyMessageDelayed(110, 1000);
                    } else {
                        mTvTime.setVisibility(View.GONE);
                        finish();
                    }

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvTime = (TextView) findViewById(R.id.tv_time);

        nHandler.sendEmptyMessageDelayed(110, 1000);

    }
}
