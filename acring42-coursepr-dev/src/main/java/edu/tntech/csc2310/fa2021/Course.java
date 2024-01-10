package edu.tntech.csc2310.fa2021;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;

public class Course {
    private String subject;
    private String number;
    private String title;
    private String description;
    private String[] prerequisites;
    private int credits;

    public Course(String subject, String number, String catalogYear) throws Exception{
        Document doc= Jsoup.connect("https://ttuss1.tntech.edu/PROD/bwckctlg.p_disp_course_detail?cat_term_in="+catalogYear+"&subj_code_in="+subject+"&crse_numb_in="+number+"").get();

        Elements CourseTitle = doc.select(".nttitle");
        Elements CourseDescription = doc.select(".ntdefault");
        Elements prereqs = doc.select("[href*=\"one_subj\"]");

        //getting title, subject, and course number
        String fullTitle = CourseTitle.text();
        String[] partsTitle = fullTitle.split(" - ");
        String part1 = partsTitle[0];
        String part2 = partsTitle[1];
        this.subject = part1.replaceAll("[^A-Z]", "");
        this.subject = this.subject.trim();
        this.number = part1.replaceAll("[^0-9]", "");
        this.number = this.number.trim();
        this.title = part2;
        this.title = this.title.trim();

        //getting description
        for(int i = 0; i < CourseDescription.size(); i++) {
            String desc = CourseDescription.get(i).text();
            if(desc.contains("Credit hours")){
                this.description = desc;
            }
        }

        //getting credit hours
        for(int i=0; i<10; ++i)
            if (getDescription().contains(i + ".000 Credit hours"))
                this.credits = i;

        // getting prerequisites
        if(!getDescription().contains("General Requirements"))
            this.prerequisites = null;
        else{
            String coursePrereqs = getDescription().substring(getDescription().indexOf("General Requirements"));
            coursePrereqs = coursePrereqs.replaceAll("General Requirements:", "");
            coursePrereqs = coursePrereqs.replaceAll("Course or Test:", "");
            coursePrereqs = coursePrereqs.replaceAll("Minimum Grade of", "");
            coursePrereqs = coursePrereqs.replaceAll("be taken concurrently\\.", "");
            coursePrereqs = coursePrereqs.replaceAll(" D ", "");
            coursePrereqs = coursePrereqs.replaceAll(" C ", "");
            coursePrereqs = coursePrereqs.replaceAll(" May ", "");
            coursePrereqs = coursePrereqs.replaceAll("not", "");
            coursePrereqs = coursePrereqs.replaceAll("or", "");
            coursePrereqs = coursePrereqs.replaceAll("and", "");
            coursePrereqs = coursePrereqs.replaceAll("\\(", "");
            coursePrereqs = coursePrereqs.replaceAll("\\)", "");
            coursePrereqs = coursePrereqs.trim();
            String[] parts = coursePrereqs.split(" (?=\\p{Upper})");
            this.prerequisites = new String[parts.length];
            for (int i = 0; i < parts.length; ++i)
                this.prerequisites[i] = parts[i].trim();
        }
    }

    public String toString(int credits){
        return Integer.toString(credits);
    }

    public String getSubject() {
        return this.subject;
    }

    public String getNumber() {
        return this.number;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getPrerequisites() {
        return this.prerequisites;
    }

    public int getCredits() {
        return this.credits;
    }
}





