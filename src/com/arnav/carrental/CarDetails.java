package com.arnav.carrental;

import java.util.*;

public class CarDetails
{
    public ArrayList getDetails()
    {
        ArrayList<HashMap<String, String>> carDetails = new ArrayList();
        HashMap<String, String> carDetail = null;

        carDetail = new HashMap();
        carDetail.put("ID", "1");
        carDetail.put("Company", "Honda");
        carDetail.put("Model", "Pilot");
        carDetail.put("Year", "2021");
        carDetail.put("Status", "Ava");
        carDetail.put("Price", "100");
        carDetails.add(carDetail);

        carDetail = new HashMap();
        carDetail.put("ID", "2");
        carDetail.put("Company", "Toyta");
        carDetail.put("Model", "Corola");
        carDetail.put("Year", "2021");
        carDetail.put("Status", "Ava");
        carDetail.put("Price", "50");
        carDetails.add(carDetail);

        carDetail = new HashMap();
        carDetail.put("ID", "3");
        carDetail.put("Company", "Tesla");
        carDetail.put("Model", "Model S");
        carDetail.put("Year", "2021");
        carDetail.put("Status", "Ava");
        carDetail.put("Price", "200");
        carDetails.add(carDetail);

        return carDetails;
    }

    public ArrayList customerDetails()
    {
        ArrayList<HashMap<String, Object>> customerDetails = new ArrayList();
        HashMap<String, Object> customerDetail = null;
        ArrayList<String> cars = null;

        customerDetail = new HashMap();
        customerDetail.put("Name", "Customer1");
        customerDetail.put("Username", "a");
        customerDetail.put("Password", "a");
        cars = new ArrayList();
        customerDetail.put("Cars", cars);
        customerDetail.put("Balance", "0");
        customerDetails.add(customerDetail);

        customerDetail = new HashMap();
        customerDetail.put("Name", "Customer1");
        customerDetail.put("Username", "b");
        customerDetail.put("Password", "b");
        cars = new ArrayList();
        customerDetail.put("Cars", cars);
        customerDetail.put("Balance", "0");
        customerDetails.add(customerDetail);

        return customerDetails;
    }
}
