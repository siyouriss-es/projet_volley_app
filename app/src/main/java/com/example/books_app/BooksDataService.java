package com.example.books_app;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BooksDataService {

    // Attributes :
    public static final String BOOKS_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    Context context;

    // Constructor :
    public BooksDataService(Context context) {
        this.context = context;
    }
    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(List<BookModel> response);
    }

    // getBooks method :
    public void getBooks(String bookName,VolleyResponseListener volleyResponseListener){
        List<BookModel> booksModels=new ArrayList<BookModel>();
        String url = BOOKS_URL +bookName;

        // Creating request :
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray books=response.getJSONArray("items");
                    for(int i=0;i<books.length();i++)
                    {
                        BookModel book=new BookModel();
                        JSONObject volume=(JSONObject) books.get(i);
                        JSONObject book_from_api=volume.getJSONObject("volumeInfo");
                        if(book_from_api.has("title"))
                            book.setTitle(book_from_api.getString("title"));
                        if(book_from_api.has("subtitle"))
                            book.setSubtitle(book_from_api.getString("subtitle"));
                        if(book_from_api.has("authors"))
                        {
                            JSONArray jsonArray=book_from_api.getJSONArray("authors");

                            String[] stringArray=new String[jsonArray.length()];
                            for(int j=0; j<stringArray.length; j++) {
                                stringArray[j]=jsonArray.optString(j);
                            }
                            book.setAuthors(stringArray);
                        }
                        if(book_from_api.has("publishedDate"))
                            book.setPublishedDate(book_from_api.getString("publishedDate"));
                        if(book_from_api.has("publisher"))
                            book.setPublisher(book_from_api.getString("publisher"));
                        if(book_from_api.has("description"))
                            book.setDescription(book_from_api.getString("description"));
                        if(book_from_api.has("pageCount"))
                            book.setPageCount(book_from_api.getInt("pageCount"));
                        if(book_from_api.has("imageLinks"))
                            book.setImageLink(book_from_api.getJSONObject("imageLinks").getString("smallThumbnail"));
                        booksModels.add(book);
                    }


                    volleyResponseListener.onResponse(booksModels);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error happened !", Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Something went wrong!");
            }
        });


        // Adding request to queue :
        MySingleton.getInstance(context).addToRequestQueue(request);
        //return "hello";
    }
    //end getBooks method.
}
