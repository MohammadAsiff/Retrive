package com.example.sys.retrive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class CustomAdapter extends BaseAdapter{
    Context context;
    ArrayList <Map <String, String>> arr;
    public CustomAdapter(Context context, ArrayList <Map <String, String>> arr)
    {
        this.context=context;
        this.arr=arr;
    }
    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customview;
        customview = LayoutInflater.from(context).inflate( R.layout.custom_item,viewGroup,false);
        TextView name = customview.findViewById( R.id.tv1);
        TextView college = customview.findViewById( R.id.tv2);
        TextView branch = customview.findViewById( R.id.tv3);
        name.setText(arr.get(i).get(ExampleDB.NAME));
        college.setText(arr.get(i).get(ExampleDB.COLLEGE));
        branch.setText(arr.get(i).get(ExampleDB.BRANCH));

        return customview;
    }

}
