package com.example.books_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // -------------- For Drawer Menu : ------------------------
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private Button btnSearch;
    private EditText edtSearch;
    private RecyclerView rvBooks;
    private LinearLayoutManager linearLayoutManager;
    private Adapter adapter;
    private List<BookCard> booksList;

    //---------------- Clicking Drawer Menu : -------------------------
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //-------------------- OnCreate Methode -------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch=findViewById(R.id.btnSearch);
        edtSearch=findViewById(R.id.edtSearch);
        // ------------------- Volley Code ----------------------------------------
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BooksDataService booksDataService=new BooksDataService(MainActivity.this);
                booksDataService.getBooks(edtSearch.getText().toString(), new BooksDataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(List<BookModel> response) {
                        booksList=new ArrayList<>();
                       for(int i=0;i<response.size();i++){
                           BookCard bookCard=new BookCard();
                           bookCard.setBook_image(response.get(i).getImageLink());
                           bookCard.setBook_title(response.get(i).getTitle());
                           bookCard.setBook_subtitle(response.get(i).getSubtitle());
                           bookCard.setBook_authors(response.get(i).getAuthors().toString());
                           bookCard.setBook_published_date(response.get(i).getPublishedDate());
                           bookCard.setBook_publisher(response.get(i).getPublisher());
                           bookCard.setBook_page_count(String.valueOf(response.get(i).getPageCount()));
                           bookCard.setBook_description(response.get(i).getDescription());
                           booksList.add(bookCard);
                       }

                        initRecycleView();
                    }
                });

            }
        });



        //-------------------- Drawer Menu Code : ------------------------------------
        drawer=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigationView);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        break;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        break;
                    case R.id.nav_settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        break;
                    case R.id.nav_users:
                        startActivity(new Intent(getApplicationContext(), UsersActivity.class));
                        break;
                    case R.id.nav_share:
                        startActivity(new Intent(getApplicationContext(), ShareActivity.class));
                        break;
                    case R.id.nav_repair:
                        startActivity(new Intent(getApplicationContext(), DonateActivity.class));
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(getApplicationContext(), LogoutActivity.class));
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Something went wrong !", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
        //------------------------- End Drawer Menu ------------------------------------



    }
    //---- End onCreate Method ----------
    private void initRecycleView() {
        rvBooks=findViewById(R.id.rvBooks);
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvBooks.setLayoutManager(linearLayoutManager);
        adapter=new Adapter(booksList,MainActivity.this);
        rvBooks.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}