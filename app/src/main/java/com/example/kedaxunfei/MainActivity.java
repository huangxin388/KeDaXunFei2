package com.example.kedaxunfei;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String items[] = {"立刻体验语音听写","立刻体验语法识别","立刻体验语义理解",
            "立刻体验语音合成","立刻体验语音唤醒","立刻体验声纹密码"};

    private ArrayList<String> mList;
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermissions();
        initDatas();
        initEvent();
    }

    private void initEvent() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i) {
                    case 0:
                        intent = new Intent(MainActivity.this,IatDemo.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,AsrDemo.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this,TtsDemo.class);
                        break;
                        default:
                }

                if(intent != null) {
                    startActivity(intent);
                }
            }
        });
    }

    private void initDatas() {
        mListView = findViewById(R.id.listview_main);
        mList = new ArrayList<>();
        mList.add("立刻体验语音听写");
        mList.add("立刻体验语法识别");
        mList.add("立刻体验语义理解");
        mList.add("立刻体验语音合成");
        mList.add("立刻体验语音唤醒");
        mList.add("立刻体验声纹密码");

        MyAdapter adapter = new MyAdapter(MainActivity.this,mList);
        mListView.setAdapter(adapter);
    }

    private void requestPermissions() {
        int permission = ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[] {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.LOCATION_HARDWARE,
                Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.READ_CONTACTS
            },0x0010);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 0x0010:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this,"权限申请成功",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"你拒绝了权限",Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
    }

}
