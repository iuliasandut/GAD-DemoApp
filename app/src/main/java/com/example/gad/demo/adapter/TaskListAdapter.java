package com.example.gad.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gad.demo.R;
import com.example.gad.demo.model.Task;

import java.util.ArrayList;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>
{
    private ArrayList<Task> mDataSource;

    public TaskListAdapter(ArrayList<Task> ds) {
        mDataSource = ds;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // load (inflate) the item layout into a variable
        RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);

        // return a new view holder instance based on the layout
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        // get the item at the specified position
        Task current_task = mDataSource.get(position);

        // update the holder instance with the new values
        holder.update(current_task);
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTVTitle;
        private TextView mTVDescription;
        private CheckBox mCBStatus;

        public TaskViewHolder(@NonNull View item_view) {
            super(item_view);

            mTVTitle        = item_view.findViewById(R.id.itemTask_tvTitle);
            mTVDescription  = item_view.findViewById(R.id.itemTask_tvDescription);
            mCBStatus       = item_view.findViewById(R.id.itemTask_cbStatus);
        }

        public void update(Task task) {
            mTVTitle.setText(task.getTitle());
            mTVDescription.setText(task.getDescription());
            mCBStatus.setChecked(task.isDone());
        }
    }

}
