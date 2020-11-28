package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

public class Activity extends AppCompatActivity {
    private List<People> peopleList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        initPeople();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManger=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManger);
        PeopleAdapter adapter=new PeopleAdapter(peopleList);
        recyclerView.setAdapter(adapter);
    }
    private void initPeople(){
        People people1=new People("退休&不回复私聊",R.drawable.people_1);
        peopleList.add(people1);
        People people2=new People("(有事问其他管理)",R.drawable.people_2);
        peopleList.add(people2);
        People people10=new People("退休|水群|私聊不回复",R.drawable.people_10);
        peopleList.add(people10);
        People people4=new People("Android-张涛(有问题先bing或者百度)",R.drawable.people_4);
        peopleList.add(people4);
        People people3=new People("Android-林潼",R.drawable.people_3);
        peopleList.add(people3);
        People people5=new People("Android-王天齐",R.drawable.people_5);
        peopleList.add(people5);
        People people6=new People("Android-徐国林",R.drawable.people_6);
        peopleList.add(people6);
        People people7=new People("Android-张煜",R.drawable.people_7);
        peopleList.add(people7);
        People people8=new People("Android-张哲",R.drawable.people_8);
        peopleList.add(people8);
        People people13=new People("Android-实钱淦",R.drawable.people_13);
        peopleList.add(people13);
        People people9=new People("果冻冻",R.drawable.people_9);
        peopleList.add(people9);
        People people12=new People("他--->大佬",R.drawable.people_12);
        peopleList.add(people12);
        People people11=new People("我--->菜逼",R.drawable.people_11);
        peopleList.add(people11);
    }
}