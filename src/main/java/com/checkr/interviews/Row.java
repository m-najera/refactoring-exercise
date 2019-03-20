package com.checkr.interviews;

public class Row {
    String permalink, company_name, number_employees, category, city, state, funded_date, raised_amount,
            raised_currency, round;

    public Row() {

    }

    public Row(String permalink, String company_name, String number_employees, String category, String city,
            String state, String funded_date, String raised_amount, String raised_currency, String round) {
        this.permalink = permalink;
        this.company_name = company_name;
        this.number_employees = number_employees;
        this.category = category;
        this.city = city;
        this.state = state;
        this.funded_date = funded_date;
        this.raised_amount = raised_amount;
        this.raised_currency = raised_currency;
        this.round = round;
    }
}