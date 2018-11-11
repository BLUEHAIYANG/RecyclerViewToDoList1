package com.example.administrator.recyclerviewtodolist1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> arr ;
    public MyAdapter adapter ;
    int position;
    final  String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        arr = new ArrayList<String>();
        adapter = new MyAdapter(arr);
        for (int i =0;i<3;i++)
        {
            //Log.d(TAG, "add:前 ");
            arr.add(0,"");
            //Log.d(TAG, "add:后 ");
            adapter.notifyItemInserted(0);
            //Log.d(TAG,"notify后");
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        Log.d("MainActivity", "onCreate:末端 ");
        Button button_add = (Button) findViewById(R.id.button_add);//在主界面中不用写converView.findVById
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print(position);

                {//Log.d("MainActivity","+前");
                arr.add(arr.size()-1,"");
                //Log.d("MainActivity","+后");
                //adapter.notifyDataSetChanged();//强制执行getView刷新界面；
                adapter.notifyDataSetChanged();
                //Log.d("MainActivity","notify前");
                    }
            }
        });
        //Log.d("MainActivity","getItemCount()");
    }


    /*public void initOuterArr() {
        outerArr.add("");
        outerArr.add("123");
        outerArr.add("456");
        System.out.print("啊啊啊啊啊啊啊"+outerArr.size());
    }*/


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {//Q1：这个继承的是什么适配器类？它的泛型又是什么？
        private ArrayList<String> innerArr;

        public MyAdapter(ArrayList<String>arr){
            innerArr = arr;
        }

        class ViewHolder extends RecyclerView.ViewHolder {//Q2.这里非得继承一次RecyclerView.ViewHolder；？
            EditText editText;
            Button button_del;

            //注意这里ViewHolder构造器的形参是一个View对象
            public ViewHolder(View view) {
                super(view);
                editText = (EditText) view.findViewById(R.id.edit_item);
                button_del = (Button) view.findViewById(R.id.button_del);
            }
        }

        @NonNull
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //这三个参数我竟然记住了哈哈哈！！！！
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item,parent,false);
            final MyAdapter.ViewHolder holder = new MyAdapter.ViewHolder(view);
            holder.button_del.setOnClickListener(new View.OnClickListener() {//这里为什么是调用View类方法，findViewByID方法是调用view的？
                @Override
                public void onClick(View v) {
                    Log.d("MyAdapter", "del del delonClick:开始");System.out.print("del键触发时的position="+position);
                    int position = holder.getAdapterPosition();
                    Log.d("MyAdapter", "del del delonClick:后");

                    if(position>=0)
                    {arr.set(position,"");
                    arr.remove(position);
                    Log.d("MyAdapter", "del onClick: adapter.notifyDataSetChange前");
                    adapter.notifyDataSetChanged();//这个地方怎么搞；
                    //adapter.notifyItemRangeChanged(0, arr.size()-1);
                    Log.d("MyAdapter", "del onClick: adapter.notifyDataSetChange后");
                        }
                }
            });
            holder.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    int position = holder.getAdapterPosition();
                    System.out.println(position);
                    if (arr.size() >0 && position>=0&&position <=innerArr.size()-1) {
                        arr.set(position, holder.editText.getText().toString());
                        Log.d(TAG, "777777777777777777777777777777");
                    }
                }
            });

            return holder;
        }

        public void onBindViewHolder(MyAdapter.ViewHolder holer, int position) {
            Log.d(TAG, "666666666666666666666666666");
            if(position>=0)
            holer.editText.setText(arr.get(position));
            Log.d(TAG,"66666666666666666666666666666666" );
        }

        @Override
        public int getItemCount() {
            return innerArr.size();
        }


    }

}