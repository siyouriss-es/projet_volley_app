package com.example.books_app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final List<BookCard> booksList;
    private final Context context;
    public Adapter(List<BookCard> booksList,Context context) {
        this.booksList = booksList;
        this.context=context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        String image=booksList.get(position).getBook_image();
        String title=booksList.get(position).getBook_title();
        String subtitle=booksList.get(position).getBook_subtitle();
        String authors=booksList.get(position).getBook_authors();
        String publishedDate=booksList.get(position).getBook_published_date();
        String publisher=booksList.get(position).getBook_publisher();
        String pageCount=booksList.get(position).getBook_page_count();
        String description=booksList.get(position).getBook_description();
        holder.setData(image,title,subtitle,authors,publishedDate,publisher,pageCount,description);
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView book_image;
        private final TextView book_title;
        private final TextView book_subtitle;
        private final TextView book_authors;
        private final TextView book_published_date;
        private final TextView book_publisher;
        private final TextView book_page_count;
        private final TextView book_description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            book_image=itemView.findViewById(R.id.book_image);
            book_title=itemView.findViewById(R.id.book_title);
            book_subtitle=itemView.findViewById(R.id.book_subtitle);
            book_authors=itemView.findViewById(R.id.book_authors);
            book_published_date=itemView.findViewById(R.id.book_published_date);
            book_publisher=itemView.findViewById(R.id.book_publisher);
            book_page_count=itemView.findViewById(R.id.book_page_count);
            book_description=itemView.findViewById(R.id.book_description);
        }
        public void setData(String image,String title,String subtitle,String authors,String publishedDate,String publisher,String pageCount,String description)
        {
            //Uri uri=Uri.parse(image);
           // book_image.setImageURI(uri);
            Glide.with(context).load(image).into(book_image);
            book_title.setText(title);
            book_subtitle.setText(subtitle);
            book_authors.setText(authors);
            book_published_date.setText(publishedDate);
            book_publisher.setText(publisher);
            book_page_count.setText(pageCount);
            book_description.setText(description);

        }
    }
}
