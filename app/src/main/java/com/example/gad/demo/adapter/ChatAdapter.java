package com.example.gad.demo.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gad.demo.R;
import com.example.gad.demo.model.ChatMessage;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatMessageViewHolder>
{
    private ArrayList<ChatMessage> mDataSource;

    public ChatAdapter(ArrayList<ChatMessage> ds) {
        mDataSource = ds;
    }

    @NonNull
    @Override
    public ChatMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // load (inflate) the item layout into a variable
        RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chatmessage, parent, false);

        // return a new view holder instance based on the layout
        return new ChatMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatMessageViewHolder holder, int position) {
        holder.update(position);
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public class ChatMessageViewHolder extends RecyclerView.ViewHolder
    {
        private TextView    mTVMessage;
        private ImageView   mAvatar;
        private int         mBoundPosition;
        private View        mViewContainer;

        public ChatMessageViewHolder(@NonNull View item_view) {
            super(item_view);

            mViewContainer  = item_view;
            mTVMessage      = item_view.findViewById(R.id.itemChat_tvMessage);
            mAvatar         = item_view.findViewById(R.id.itemChat_ivAvatar);
        }

        public void update(int position) {
            mBoundPosition = position;

            ChatMessage current_message = mDataSource.get(mBoundPosition);

            mViewContainer.setLayoutDirection(current_message.getDirection());
            mTVMessage.setText(current_message.getMessage());
            mTVMessage.setBackgroundColor(Color.parseColor(current_message.getBackgroundColor()));
            mAvatar.setImageResource(current_message.getAvatar());

            if (mBoundPosition > 0) {
                ChatMessage previous_message = mDataSource.get(mBoundPosition-1);

                if (previous_message.getSource() == current_message.getSource()) {
                    mAvatar.setVisibility(View.INVISIBLE);
                } else {
                    mAvatar.setVisibility(View.VISIBLE);
                }
            } else {
                mAvatar.setVisibility(View.VISIBLE);
            }
        }
    }

}
