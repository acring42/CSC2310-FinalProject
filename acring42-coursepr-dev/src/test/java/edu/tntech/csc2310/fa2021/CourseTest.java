package edu.tntech.csc2310.fa2021;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    Course data;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getSubject() throws Exception {
        data = new Course("CSC", "1300", "202180");
        assertEquals("Subject", "CSC", data.getSubject());

        data = new Course("CEE", "3415", "202180");
        assertEquals("Subject", "CEE", data.getSubject());

        data = new Course("CSC", "4990", "202180");
        assertEquals("Subject", "CSC", data.getSubject());

        data = new Course("MATH", "1920", "202180");
        assertEquals("Subject", "MATH", data.getSubject());

        data = new Course("ENGR", "1220", "202180");
        assertEquals("Subject", "ENGR", data.getSubject());

        data = new Course("MATH", "1015", "202180");
        assertEquals("Subject", "MATH", data.getSubject());
    }

    @Test
    public void getNumber() throws Exception {
        data = new Course("CSC", "1300", "202180");
        assertEquals("Number", "1300", data.getNumber());

        data = new Course("CEE", "3415", "202180");
        assertEquals("Number", "3415", data.getNumber());

        data = new Course("CSC", "4990", "202180");
        assertEquals("Number", "4990", data.getNumber());

        data = new Course("MATH", "1920", "202180");
        assertEquals("Number", "1920", data.getNumber());

        data = new Course("ENGR", "1220", "202180");
        assertEquals("Number", "1220", data.getNumber());

        data = new Course("MATH", "1015", "202180");
        assertEquals("Number", "1015", data.getNumber());
    }

    @Test
    public void getTitle() throws Exception {
        data = new Course("CSC", "1300", "202180");
        assertEquals("Title", "Intro/Prob Solving-Comp Prog", data.getTitle());

        data = new Course("CEE", "3415", "202180");
        assertEquals("Title", "Fluid Mechanics", data.getTitle());

        data = new Course("CSC", "4990", "202180");
        assertEquals("Title", "Computer Science Internship", data.getTitle());

        data = new Course("MATH", "1920", "202180");
        assertEquals("Title", "Calculus II", data.getTitle());

        data = new Course("ENGR", "1220", "202180");
        assertEquals("Title", "Intro-Emrging Tech (GSET)", data.getTitle());

        data = new Course("MATH", "1015", "202180");
        assertEquals("Title", "MATH1010R50:Math/Liberal Arts", data.getTitle());
    }

    @Test
    public void getPrerequisites() throws Exception {
        // CSC 1020 has no course pre-requisites; just a standing
        data = new Course("CSC", "1020", "202180");
        assertNull(data.getPrerequisites());

        // CSC 1300 has three course-based pre-requisites
        data = new Course("CSC", "1300", "202180");
        String[] eresults = {"CSC 1200","MATH 1845","MATH 1910"};
        String[] aresults = data.getPrerequisites();
        for (int i = 0; i < eresults.length; i++) {
            assertEquals("prereq list", eresults[i], aresults[i].trim());
        }
        // MATH 1910
        data = new Course("MATH", "1910", "202180");
        String[] e0results = {"MATH 1710","MATH 1720","MATH 1730", "A02 27 to 36", "S02 610 to 800", "S12B 630 to 800"};
        aresults = data.getPrerequisites();
        for (int i = 0; i < e0results.length; i++) {
            assertEquals("prereq list", e0results[i], aresults[i].trim());
        }
        // MATH 1730
        data = new Course("MATH", "1730", "202180");
        String[] e1results = {"CM03 51","A02 25 to 36","S02 570 to 800", "S12B 590 to 800"};
        aresults = data.getPrerequisites();
        for (int i = 0; i < e1results.length; i++) {
            assertEquals("prereq list", e1results[i], aresults[i].trim());
        }
        // CEE 3415
        data = new Course("CEE", "3415", "202180");
        String[] e2results = {"ME 2330"};
        aresults = data.getPrerequisites();
        for (int i = 0; i < e2results.length; i++) {
            assertEquals("prereq list", e2results[i], aresults[i].trim());
        }
        // CSC 4990
        data = new Course("CSC", "4990", "202180");
        String[] e3results = {"CSC 3040","CSC 3300"};
        aresults = data.getPrerequisites();
        for (int i = 0; i < e3results.length; i++) {
            assertEquals("prereq list", e3results[i], aresults[i].trim());
        }
        // ENGR 1220
        data = new Course("ENGR", "1220", "202180");
        assertNull(data.getPrerequisites());

        // MATH 1015
        data = new Course("MATH", "1015", "202180");
        String[] e4results = {"A02 19 to 36"};
        aresults = data.getPrerequisites();
        for (int i = 0; i < e4results.length; i++) {
            assertEquals("prereq list", e4results[i], aresults[i].trim());
        }

        // MATH 1730
        data = new Course("MATH", "1730", "202180");
        String[] e5results = {"CM03 51", "A02 25 to 36", "S02 570 to 800", "S12B 590 to 800"};
        aresults = data.getPrerequisites();
        for (int i = 0; i < e5results.length; i++) {
            assertEquals("prereq list", e5results[i], aresults[i].trim());
        }
    }

    @Test
    public void getCRH() throws Exception {
        data = new Course("CSC", "3500", "202180");
        assertTrue("Credit Hours", 1 == data.getCredits());
        data = new Course("CSC", "4100", "202180");
        assertTrue("Credit Hours", 3 == data.getCredits());
        data = new Course("CSC", "3300", "202180");
        assertTrue("Credit Hours", 3 == data.getCredits());

        data = new Course("CEE", "3415", "202180");
        assertTrue("Credit Hours", 3 == data.getCredits());

        data = new Course("CSC", "2400", "202180");
        assertTrue("Credit Hours", 3 == data.getCredits());

        data = new Course("CSC", "4990", "202180");
        assertTrue("Credit Hours", 6 == data.getCredits());

        data = new Course("MATH", "1920", "202180");
        assertTrue("Credit Hours", 4 == data.getCredits());

        data = new Course("MATH", "1015", "202180");
        assertTrue("Credit Hours", 3 == data.getCredits());
    }

}