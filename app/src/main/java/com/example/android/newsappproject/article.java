package com.example.android.newsappproject;

public class article {

    // headline of the article
    private String mArticleHeadline;

    // the section the article belongs to
    private String mArticleSection;

    // the date the article was published
    private String mArticleDate;

    // the article url
    private String mArticleUrl;

    // create a new article object

    public article(String sArticleHeadline, String sArticleSection, String sArticleDate, String sArticleUrl){
        mArticleHeadline = sArticleHeadline;
        mArticleSection = sArticleSection;
        mArticleDate = sArticleDate;
        mArticleUrl= sArticleUrl;


    }

    // method to get the article headline
    // returns a string
    public String getArticleHeadline (){
      return mArticleHeadline;
    }

    // method to get the section the article belongs to
    public String getArticleSection (){
        return mArticleSection;
    }

    // method to get the date the article was published
    public String getArticleDate () {
        mArticleDate= mArticleDate.substring(0,10);
        return mArticleDate;
    }

    public String getArticleUrl(){
        return mArticleUrl;
    }


}
