package com.example.android.newsappproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ArticleAdapter extends ArrayAdapter<article> {
    private static final String LOG_TAG = ArticleAdapter.class.getSimpleName();

    // context is the current context and is used to inflate the layout
    // article parameter is a list of article objects to display in a list

    public ArticleAdapter(Activity context, ArrayList<article> articles) {
        // initialise the internal storage of the array adapter
        super(context, R.layout.activity_main, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // check is the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);

        }
        // get the article object located at this position
        article currentArticle = getItem(position);

        String headlineAndName = currentArticle.getArticleHeadline();

        String articleHeadline;
        String authorName;
        if(headlineAndName.contains("|")){
            String[] parts = headlineAndName.split("\\|");
            articleHeadline = parts[0];
            authorName = parts[1];
        }
        else{
            articleHeadline= currentArticle.getArticleHeadline();
            authorName = "Author Unknown";
        }

        TextView headlineTextView = (TextView) listItemView.findViewById(R.id.headline_view);
        headlineTextView.setText(articleHeadline);


        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_view);
        authorTextView.setText(authorName);


        // section name
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section_view);
        sectionTextView.setText(currentArticle.getArticleSection());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_view);
        dateTextView.setText(currentArticle.getArticleDate());



        return listItemView;
    }

}