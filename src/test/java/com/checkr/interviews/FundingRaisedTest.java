package com.checkr.interviews;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FundingRaisedTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FundingRaisedTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(FundingRaisedTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testWhereGivenCompany() {
        try {
            Row filter = new Row();
            filter.company_name= "Facebook";
            assertEquals(FundingRaised.where(filter).size(), 7);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereGivenCity() {
        try {
            Row filter = new Row();
            filter.city= "Tempe";
            assertEquals(FundingRaised.where(filter).size(), 3);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereGivenState() {
        try {
            Row filter = new Row();
            filter.state= "CA";
            assertEquals(FundingRaised.where(filter).size(), 873);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereGivenRound() {
        try {
            Row filter = new Row();
            filter.round= "a";
            assertEquals(FundingRaised.where(filter).size(), 582);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testMultipleOptions() {
        try {
            Row filter = new Row();
            filter.round= "a";
            filter.company_name= "Facebook";
            assertEquals(FundingRaised.where(filter).size(), 1);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereNotExists() {
        try {
            Row filter = new Row();
            filter.company_name= "NotFacebook";
            assertEquals(FundingRaised.where(filter).size(), 0);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereCorrectKeys() {
        try {
            Row filter = new Row();
            filter.company_name= "Facebook";
            Row row = FundingRaised.where(filter).get(0);

            assertEquals(row.permalink, "facebook");
            assertEquals(row.company_name, "Facebook");
            assertEquals(row.number_employees, "450");
            assertEquals(row.category, "web");
            assertEquals(row.city, "Palo Alto");
            assertEquals(row.state, "CA");
            assertEquals(row.funded_date, "1-Sep-04");
            assertEquals(row.raised_amount, "500000");
            assertEquals(row.round, "angel");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testFindByGivenCompanyName() {
        try {
            Row filter = new Row();
            filter.company_name= "Facebook";
            Row row = FundingRaised.findBy(filter);

            assertEquals(row.permalink, "facebook");
            assertEquals(row.company_name, "Facebook");
            assertEquals(row.number_employees, "450");
            assertEquals(row.category, "web");
            assertEquals(row.city, "Palo Alto");
            assertEquals(row.state, "CA");
            assertEquals(row.funded_date, "1-Sep-04");
            assertEquals(row.raised_amount, "500000");
            assertEquals(row.round, "angel");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testFindByGivenState() {
        try {
            Row filter = new Row();
            filter.state = "CA";
            Row row = FundingRaised.findBy(filter);

            assertEquals(row.permalink, "digg");
            assertEquals(row.company_name, "Digg");
            assertEquals(row.number_employees, "60");
            assertEquals(row.category, "web");
            assertEquals(row.city, "San Francisco");
            assertEquals(row.state, "CA");
            assertEquals(row.funded_date, "1-Dec-06");
            assertEquals(row.raised_amount, "8500000");
            assertEquals(row.round, "b");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testFindByMultipleOptions() {
        try {
            Row filter = new Row();
            filter.company_name = "Facebook";
            filter.round = "c";
            Row row = FundingRaised.findBy(filter);

            assertEquals(row.permalink, "facebook");
            assertEquals(row.company_name, "Facebook");
            assertEquals(row.number_employees, "450");
            assertEquals(row.category, "web");
            assertEquals(row.city, "Palo Alto");
            assertEquals(row.state, "CA");
            assertEquals(row.funded_date, "1-Oct-07");
            assertEquals(row.raised_amount, "300000000");
            assertEquals(row.round, "c");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testFindByNotExists() {
        try {
            Row filter = new Row();
            filter.company_name= "NotFacebook";
            filter.round= "c";
            Row row = FundingRaised.findBy(filter);
            fail("findBy should throw exception");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
        }
    }
}
