package com.example.kcampusmanager;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class ClassListViewAdapter extends BaseAdapter {
    private ArrayList<ClassListItem> listViewItemList = new ArrayList<ClassListItem>();

    public ClassListViewAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_classroom_oc_class, parent, false);
        }

        TextView name = (TextView) view.findViewById(R.id.tv_classroom_name);
        Switch open = (Switch) view.findViewById(R.id.switch_classroom_open);

        ClassListItem listViewItem = listViewItemList.get(position);

        name.setText(listViewItem.getName());
        open.setChecked(listViewItem.getOpen());

        open.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ClassListItem item = listViewItemList.get(position);
            item.setOpen(isChecked);
        });

        return view;
    }

    public void addItem(String name, Boolean open) {
        ClassListItem item = new ClassListItem();

        item.setName(name);
        item.setOpen(open);

        listViewItemList.add(item);
    }
}
