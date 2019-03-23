package com.checkr.interviews;

public class Row {
    public String permalink = null;
    public String company_name = null;
    public String number_employees = null;
    public String category = null;
    public String city = null;
    public String state = null;
    public String funded_date = null;
    public String raised_amount = null;
    public String raised_currency = null;
    public String round = null;

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

    public boolean rowMatchesFilters(Row filter) {
        return ((filter.company_name == null || this.company_name.equals(filter.company_name))
                && (filter.city == null || this.city.equals(filter.city))
                && (filter.state == null || this.state.equals(filter.state))
                && (filter.round == null || this.round.equals(filter.round)));
    }
}