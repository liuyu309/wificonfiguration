package com.sevenplus.wificonfiguration.view.popwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sevenplus.wificonfiguration.activity.R;

import java.util.List;

public class ListSelectAdapter extends BaseAdapter {

    private Context context;

    List<String> list;

    public ListSelectAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {

        return list.get(position);
    }

    public long getItemId(int position) {

        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {

        final String l = list.get(position);

        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.listselect_pop_item, parent, false);
            holder = new ViewHolder();
            holder.item_tv = (TextView) view.findViewById(R.id.item_tv);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.item_tv.setText("" + l);
        return view;
    }

    class ViewHolder {
        TextView item_tv;

    }

}
