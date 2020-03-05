package com.r2017.bookbank;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class SearchViewHolder extends RecyclerView.ViewHolder {

    TextView bookName, authorName;

    SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        bookName = itemView.findViewById(R.id.bookName);
        authorName = itemView.findViewById(R.id.authorName);

    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Book> books;

    SearchAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item, parent, false);

        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        holder.bookName.setText(books.get(position).getBookName());
        holder.authorName.setText(books.get(position).getAuthorName());

    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
