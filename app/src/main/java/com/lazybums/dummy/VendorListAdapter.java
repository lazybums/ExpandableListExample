package com.lazybums.dummy;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Abhishek on 8/30/2015.
 */
public class VendorListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> vendors;
    private HashMap<String,List<String>> items;

    public VendorListAdapter(Context context, List<String> vendors, HashMap<String, List<String>> items){

        this.context = context;
        this.vendors = vendors;
        this.items = items;
    }

    @Override
    public int getGroupCount() {
        return this.vendors.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.items.get(this.vendors.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.vendors.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.items.get(this.vendors.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final String vendorText = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.vendor, null);
        }

        TextView vendorName = (TextView) convertView
                .findViewById(R.id.vendorListItem);
        vendorName.setTypeface(null, Typeface.BOLD);
        vendorName.setText(vendorText);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.itemList);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
