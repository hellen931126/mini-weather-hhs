package com.example.hhs.mini_weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hhs.app.MyApplication;
import com.example.hhs.bean.City;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hhs on 2016/10/18.
 */
public class SelectCity extends Activity implements View.OnClickListener {

    private ImageView mBackBtn;
//    private ListView mListCity;
//
//    MyApplication myApplication;
//    private String[] data=myApplication.getCityList();

    private ArrayList<String> dataCity ;
    private ArrayList<String> dataCode;
    private ListView mlistView ;
    private String selectcode;
    private TextView selectct_tv;
    List<City> cityList;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);
        selectct_tv=(TextView)findViewById(R.id.title_name1);
        mBackBtn = (ImageView) findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);

        dataCity = new ArrayList<String>();
        dataCode = new ArrayList<String>();
        myApplication= (MyApplication)getApplication();
        cityList=myApplication.getCityList();

        for(int i=0;i<cityList.size();i++)
        {
            dataCity.add(cityList.get(i).getCity().toString());
            dataCode.add(cityList.get(i).getNumber().toString());
        }

        mlistView =(ListView)findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SelectCity.this,android.R.layout.simple_list_item_1,dataCity);
        mlistView.setAdapter(adapter);
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SelectCity.this,"你单击了："+dataCode.get(i),Toast.LENGTH_SHORT).show();
                selectcode=dataCode.get(i);
                selectct_tv.setText("你选择了："+dataCity.get(i));

            }
        });
        Log.d("info",cityList.get(0).getNumber());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                Intent i = new Intent();
                i.putExtra("cityCode", "selectcode");
                setResult(RESULT_OK, i);
                finish();
                break;
            default:
                break;
        }
    }
}
