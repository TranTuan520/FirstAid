package com.example.firstaid.model;

import android.widget.Filter;


import com.example.firstaid.adapter.ListDataAdapter;
import com.example.firstaid.model.Accident;

import java.util.ArrayList;

public class CustomFilter extends Filter {
    ArrayList<Accident> filterList;
    ListDataAdapter myAdapter;

    public CustomFilter(ArrayList<Accident> filterList, ListDataAdapter myAdapter) {
        this.filterList = filterList;
        this.myAdapter = myAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = new FilterResults();
        if(constraint !=null && constraint.length()>0)
        {
            constraint = constraint.toString().toUpperCase();
            ArrayList<Accident> filterContacts = new ArrayList<>();
            for(int i = 0; i< filterList.size();i++)
            {
                if(filterList.get(i).getmName().toUpperCase().contains(constraint)){
                    filterContacts.add(filterList.get(i));
                }
            }
            filterResults.count = filterContacts.size();
            filterResults.values = filterContacts;
        }else
        {
            filterResults.values = filterList;
            filterResults.count = filterList.size();

        }
        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        myAdapter.listData = (ArrayList)results.values;
        myAdapter.notifyDataSetChanged();
    }
}
