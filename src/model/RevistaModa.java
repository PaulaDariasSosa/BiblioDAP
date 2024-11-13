package model;

import service.*;

import java.util.Scanner;

public class RevistaModa extends Revista{
    public RevistaModa(String abstract_, String web_url_, String lead_paragraph_, String source_, int word_count_){
        super( abstract_,  web_url_,  lead_paragraph_,  source_,  word_count_);
    }

    public String toString(){
        return "Abstract: " + abstract_ + "\n" + "Web URL: " + web_url_ + "\n" + "Lead Paragraph: " + lead_paragraph_ + "\n" + "Source: " + source_ + "\n" + "Word Count: " + word_count_ + "\n" + "Es una revista de Moda";
    }
}
