package com.example.android.newsappproject;

public class article {

    // headline of the article
    private String mArticleHeadline;

    // the section the article belongs to
    private String mArticleSection;

    // the date the article was published
    private String mArticleDate;

    // the author's name
    private String mArticleAuthorName;

    // create a new article object

    public article(String sArticleHeadline, String sArticleSection, String sArticleDate, String sArticleAuthorName){
        mArticleHeadline = sArticleHeadline;
        mArticleSection = sArticleSection;
        mArticleDate = sArticleDate;
        mArticleAuthorName = sArticleAuthorName;
    }

    public article(String sArticleHeadline, String sArticleSection, String sArticleDate){
        mArticleHeadline = sArticleHeadline;
        mArticleSection = sArticleSection;
        mArticleDate = sArticleDate;

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
        return mArticleDate;
    }

    // method to get the author of the article
    public String getArticleAuthorName(){
        return mArticleAuthorName;
    }

}
