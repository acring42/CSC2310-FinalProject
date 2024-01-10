package edu.tntech.csc2310.fa2021;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class CourseCatalog {
    private ArrayList<Course> db;
    private String subject;
    private String catalogYear;

    public CourseCatalog(String subject, String catalogYear) throws Exception {
        Document doc2= Jsoup.connect("https://ttuss1.tntech.edu/PROD/bwckctlg.p_display_courses?sel_crse_strt=1000&sel_crse_end=4999&sel_subj=&sel_levl=&sel_schd=&sel_coll=&sel_divs=&sel_dept=&sel_attr=&term_in="+catalogYear+"&one_subj="+subject+"").get();
        Elements courses = doc2.select("[href*=\"subj_code_in\"]");
        db = new ArrayList(courses.size());
        this.subject = subject;
        this.catalogYear = catalogYear;
        for(int i = 0; i < courses.size(); i++) {
            String courseString = courses.get(i).text();
            String[] partsTitle = courseString.split(" - ");
            String part1 = partsTitle[0];
            part1 = part1.replaceAll("[^0-9]", "");
            String number = part1;
            number = number.trim();
            Course course = new Course(this.subject, number, this.catalogYear);
            db.add(course);
        }
    }
    public Course getCourse(String number){
        Course course = null;
        for (int i = 0; i < db.size(); i++){
            Course temp = db.get(i);
            if (temp.getNumber().equalsIgnoreCase(number)){
                course = temp;
                break;
            }
        }
        return course;
    }

    public String getSubject(){
        for (int i = 0; i < db.size(); i++){
            Course temp = db.get(i);
            if (temp.getSubject().equalsIgnoreCase(subject)){
                subject = temp.getSubject();
                break;
            }
        }
        return subject;
    }
    public String getCatalogYear(){
        return catalogYear;
    }
}
