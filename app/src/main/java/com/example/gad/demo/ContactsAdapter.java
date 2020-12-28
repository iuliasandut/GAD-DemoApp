package com.example.gad.demo;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>
{
    private final ArrayList<String>         mDataSet;   // actual data set
    private final ArrayList<Character>      mHeaders;   // list of headers

    // maps virtual position to type and actual index (<virtual_position, <type, actual_position>>
    private final HashMap<Integer, Pair<Integer, Integer>> mTypeMapping;

    public static final int TYPE_HEADER     = 0;
    public static final int TYPE_CONTACT    = 1;

    public ContactsAdapter(ArrayList<String> contact_list) {
        mDataSet = contact_list;

        // sort data set alphabetically
        Collections.sort(mDataSet, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });

        // initialize header list with first letter
        mHeaders = new ArrayList<>();
        mHeaders.add(mDataSet.get(0).charAt(0));

        // initialize type mapping
        int map_index       = 0; // auto-incrementing map index, refers to virtual position
        int contact_index   = 0; // actual index in the contacts data set
        int index_header    = 0; // actual index in the headers array
        mTypeMapping  = new HashMap<>();

        // add first item, always the first header
        mTypeMapping.put(map_index++, Pair.create(TYPE_HEADER, index_header++));

        // extract first letters into the header list
        // and create mapping of type and position
        for (String name : mDataSet) {

            // get current name and extract first letter
            char current_char = name.charAt(0);

            // compare first letter to the last letter in the header list
            if (current_char != mHeaders.get(mHeaders.size()-1)) {
                // letters are different -> new header

                // add letter to the header list
                mHeaders.add(current_char);

                // add new mapping of type "header" to actual index in header list
                mTypeMapping.put(map_index++, Pair.create(TYPE_HEADER,  index_header++));
            }

            // add the current name to the mapping list
            // map virtual position to type "contact" and actual index in the contact list (data set)
            mTypeMapping.put(map_index++, Pair.create(TYPE_CONTACT, contact_index++));
        }
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // switch returned view holder based on the type of the item at the virtual position
        if (viewType == TYPE_HEADER) {
            RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_contact, parent, false);
            return new EntryViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        // get the type of the item at the virtual position from the mapping
        int type = mTypeMapping.get(position).first;

        if (type == TYPE_HEADER) {
            holder.update(mHeaders.get(mTypeMapping.get(position).second).toString());
        }

        if (type == TYPE_CONTACT) {
            holder.update(mDataSet.get(mTypeMapping.get(position).second).toString());
        }
    }

    @Override
    public int getItemCount() {
        // list size is initial data set size plus the headers
        return mDataSet.size() + mHeaders.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mTypeMapping.get(position).first;
    }

    public abstract static class ContactsViewHolder extends RecyclerView.ViewHolder
    {
        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void update(String value) {};
    }

    public static class EntryViewHolder extends ContactsAdapter.ContactsViewHolder
    {
        private final TextView mTV_Name;
        private final TextView mTV_Initials;

        public EntryViewHolder(@NonNull View itemView) {
            super(itemView);

            mTV_Name = itemView.findViewById(R.id.listContactsEntry_tvName);
            mTV_Initials = itemView.findViewById(R.id.listContactsEntry_tvInitials);
        }

        public void update(String value) {
            mTV_Name.setText(value);

            String initials = value.split(" ")[0].charAt(0) + " " + value.split(" ")[1].charAt(0);
            mTV_Initials.setText(initials);
        }
    }

    public static class HeaderViewHolder extends ContactsAdapter.ContactsViewHolder
    {
        private final TextView mTV_Letter;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            mTV_Letter = itemView.findViewById(R.id.itemContactsHeader_tvLetter);
        }

        public void update(String value) {
            mTV_Letter.setText(value);
        }
    }


}
