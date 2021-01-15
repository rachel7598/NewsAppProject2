package com.example.android.newsappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the list of articles from the QueryUtils method
        ArrayList<article> articles = QueryUtils.extractArticles();

        // create an article adapter to display the list items
        ArticleAdapter articleAdapter = new ArticleAdapter(this, articles);

        // get a reference to the article list view and attach it to the adapter
       ListView articleListView = findViewById(R.id.article_list);

       // set the adapter
       articleListView.setAdapter(articleAdapter);

    }
}