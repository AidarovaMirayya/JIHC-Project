package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {
    private static final String TAG = "RecyclerAdapter";
    List<String> teacherslist;
    List<String> teachersListALL;
    public RecyclerAdapter(List<String> teacherslist) {
        this.teacherslist = teacherslist;
        this.teachersListALL = new ArrayList<>(teacherslist);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(teacherslist.get(position));

    }


    @Override
    public int getItemCount() {
        return teacherslist.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        private Object String;
        private Object Collection;

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {


            List<String> filteredList = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {
                filteredList.addAll(teachersListALL);
            } else {
                for (String teacher : teachersListALL) {
                    if (teacher.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(teacher);
                    }
                }

            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            teacherslist.clear();
            teacherslist.addAll((java.util.Collection<? extends java.lang.String>) filterResults.values);
            notifyDataSetChanged();


        }
    };

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView, rowCountTextView;

    }
}
