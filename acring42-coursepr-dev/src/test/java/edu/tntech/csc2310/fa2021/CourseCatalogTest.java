package edu.tntech.csc2310.fa2021;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CourseCatalogTest {

    private CourseCatalog catalog;
    private CourseCatalog other;
    private CourseCatalog other2;
    private CourseCatalog other3;

    @Before
    public void setUp() throws Exception {
        catalog = new CourseCatalog("CSC", "202180");
        other = new CourseCatalog("ENGR", "202180");
        other2 = new CourseCatalog("LAW", "202180");
        other3 = new CourseCatalog("MATH", "202180");
    }

    @Test
    public void getCourse() {
        Course c = catalog.getCourse("2770");
        assertEquals("Course test", "Intro to Systems & Networking", c.getTitle());
        assertEquals("Course test credits", 3, c.getCredits());
        Course c1 = catalog.getCourse("2001");
        assertNull(c1);

        Course c2 = catalog.getCourse("2500");
        assertEquals("Course test", "Unix Laboratory", c2.getTitle());
        assertEquals("Course test credits", 1, c2.getCredits());
        Course cOther = catalog.getCourse("2501");
        assertNull(cOther);

        Course c3 = catalog.getCourse("4990");
        assertEquals("Course test", "Computer Science Internship", c3.getTitle());
        assertEquals("Course test credits", 6, c3.getCredits());
        Course cOther2 = catalog.getCourse("2121");
        assertNull(cOther2);

        Course c4 = catalog.getCourse("4803");
        assertEquals("Course test", "Directed Studies in CSC", c4.getTitle());
        assertEquals("Course test credits", 3, c4.getCredits());
        Course cOther3 = catalog.getCourse("4804");
        assertNull(cOther3);

        Course c5 = other.getCourse("3020");
        assertEquals("Course test", "Numerical Methods", c5.getTitle());
        assertEquals("Course test credits", 3, c5.getCredits());
        Course cOther4 = other.getCourse("3021");
        assertNull(cOther4);

        Course c6 = other2.getCourse("4720");
        assertEquals("Course test", "Business Law", c6.getTitle());
        assertEquals("Course test credits", 3, c6.getCredits());
        Course cOther5 = other2.getCourse("1923");
        assertNull(cOther5);

        Course c7 = other3.getCourse("1730");
        assertEquals("Course test", "Pre-Calculus Math", c7.getTitle());
        assertEquals("Course test credits", 5, c7.getCredits());
        Course cOther6 = other3.getCourse("1731");
        assertNull(cOther6);
    }

    @Test
    public void getCatalogYear() {
        assertEquals("Catalog Year", "202180", catalog.getCatalogYear());
        assertEquals("Catalog Year", "202180", other.getCatalogYear());
        assertEquals("Catalog Year", "202180", other2.getCatalogYear());
        assertEquals("Catalog Year", "202180", other3.getCatalogYear());
    }

    @Test
    public void getSubject() {
        assertEquals("Subject", "CSC", catalog.getSubject());
        assertEquals("Subject", "ENGR", other.getSubject());
        assertEquals("Subject", "LAW", other2.getSubject());
        assertEquals("Subject", "MATH", other3.getSubject());
    }
}