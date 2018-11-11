package com.example.administrator.recyclerviewtodolist1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/*public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {//Q1：这个继承的是什么适配器类？它的泛型又是什么？
    MyAdapter adapter;
    private ArrayList<String> innerArr;

    public MyAdapter(ArrayList<String>outerArr){
        innerArr = outerArr;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {//Q2.这里非得继承一次RecyclerView.ViewHolder；？
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //这三个参数我竟然记住了哈哈哈！！！！
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.button_del.setOnClickListener(new View.OnClickListener() {//这里为什么是调用View类方法，findViewByID方法是调用view的？
            @Override
            public void onClick(View v) {
                Log.d("MyAdapter", "onClick:开始");
                int position = holder.getAdapterPosition();
                innerArr.set(position,"");
                innerArr.remove(position);
                Log.d("MyAdapter", "onClick: adapter.notifyDataSetChange前");
                adapter.notifyDataSetChanged();//这个地方怎么搞；
                Log.d("MyAdapter", "onClick: adapter.notifyDataSetChange后");
            }
        });
        holder.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int position = holder.getAdapterPosition();
                if (innerArr.size() > 0 && position <= innerArr.size() - 1) {
                    innerArr.set(position, holder.editText.getText().toString());
                }
            }
        });

        return holder;
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.editText.setText(innerArr.get(position));
    }

    @Override
    public int getItemCount() {
        return innerArr.size();
    }
}*/
