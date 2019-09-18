package com.example.kedaxunfei;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<String> mData;

    public MyAdapter(Context mContext, ArrayList<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.list_item,null);
            holder.listText = view.findViewById(R.id.list_text);
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        holder.listText.setText(mData.get(i));
        return view;
    }

    class ViewHolder {
        TextView listText;
    }
}
