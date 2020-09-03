package com.arnav.carrental;

import java.util.*;

class CarRentalManagement
{
    Scanner kb = new Scanner(System.in);
    ArrayList carDetails = null;
    HashMap<String, String> car = null;
    ArrayList customerDetails = null;
    HashMap<String, Object> user = null;
    ArrayList<String> cars = null;

    void startApplication()
    {
        System.out.println("Hello, Welcome to Arnav's Rental");

        CarDetails carDetails = new CarDetails();
        this.carDetails = carDetails.getDetails();
        customerDetails = carDetails.customerDetails();

        login();
    }

    void login()
    {
        do
        {
            System.out.println("\nPlease Enter Username: ");
            String enteredUsername = kb.next();
            String username = "";
            System.out.println("Please Enter Password: ");
            String enteredPassword = kb.next();
            String password = "";

            for (int i = 0; i < customerDetails.size(); i++)
            {
                user = (HashMap<String, Object>) customerDetails.get(i);

                username = (String) user.get("Username");
                password = (String) user.get("Password");
                if (enteredUsername.equals(username) && enteredPassword.equals(password))
                {
                    System.out.println("\nYou have been successfully logged in");
                    cars = (ArrayList<String>) user.get("Cars");
                    activity();
                    break;
                }
            }
            if (!enteredUsername.equals(username) && !enteredPassword.equals(password))
            {
                System.out.println("Try again");
            }
        } while (true);
    }

    void activity()
    {
        do
        {
            int activity = 0;
            do
            {
                System.out.println("\nEnter Action");
                System.out.println("\n1 = See All Cars");
                System.out.println("2 = See Cars You Have");
                System.out.println("3 = See Balance");
                System.out.println("4 = Add Money To Balance");
                System.out.println("5 = Rent Car");
                System.out.println("6 = Return Car");
                System.out.println("7 = Sign Out");
                activity = kb.nextInt();
                if (activity > 7 && activity <= 0)
                {
                    System.out.println("\nTry Again");
                }
            } while (activity > 6 && activity <= 0);

            if (activity == 7)
            {
                System.out.println("BYE");
                break;
            } else if (activity == 1)
            {
                if (carDetails.size() == 0)
                {
                    System.out.println("\nSorry there are no cars avaiable");
                } else
                {
                    int counter = 1;
                    System.out.println("These are the available cars");
                    for (int i = 0; i < carDetails.size(); i++)
                    {
                        car = (HashMap<String, String>) carDetails.get(i);
                        String status = car.get("Status");
                        String company = car.get("Company");
                        String model = car.get("Model");
                        String price = car.get("Price");

                        if (status.equals("Ava"))
                        {
                            System.out.println("\n" + counter + " - " + company + " " + model + " for $" + price + " per day");
                            counter++;
                        }
                    }
                }
            } else if (activity == 2)
            {
                if (cars.size() == 0)
                {
                    System.out.println("\nYou have no cars");
                } else
                {
                    System.out.println("\nThese are the cars you have");
                    for (int i = 0; i < cars.size(); i++)
                    {
                        for (int j = 0; j < carDetails.size(); j++)
                        {
                            HashMap<String, String> carTemp = (HashMap<String, String>) carDetails.get(j);
                            String id = carTemp.get("ID");
                            String model = carTemp.get("Model");
                            if (id.equals(cars.get(i)))
                            {
                                System.out.println(cars.get(i) + " - " + model);
                            }
                        }

                    }
                }
            } else if (activity == 3)
            {
                System.out.println("Your Balance is $" + user.get("Balance"));
            } else if (activity == 4)
            {
                System.out.println("\nEnter amount you want to add");
                double add = kb.nextDouble();

                String balanceString = (String) user.get("Balance");
                double balance = Double.parseDouble(balanceString);
                balance = balance + add;
                String doubleString = String.valueOf(balance);

                user.replace("Balance", doubleString);
            } else if (activity == 5)
            {
                if (carDetails.size() == 0)
                {
                    System.out.println("\nSorry, there are no cars avaiable");
                } else
                {
                    System.out.println("Select Car You Want To Rent");
                    for (int i = 0; i < carDetails.size(); i++)
                    {
                        car = (HashMap<String, String>) carDetails.get(i);
                        String id = car.get("ID");
                        String status = car.get("Status");
                        String company = car.get("Company");
                        String model = car.get("Model");
                        String price = car.get("Price");

                        if (status.equals("Ava"))
                        {
                            System.out.println("\n" + id + " - " + company + " " + model + " for $" + price + " per day");
                        }
                    }

                    int selectedCarIndex;
                    do
                    {
                        selectedCarIndex = kb.nextInt();
                        selectedCarIndex = selectedCarIndex - 1;
                        if (selectedCarIndex >= cars.size() && selectedCarIndex < 0)
                        {
                            System.out.println("\nTry Again");
                        }
                    } while (selectedCarIndex >= carDetails.size() && selectedCarIndex < 0);

                    car = (HashMap<String, String>) carDetails.get(selectedCarIndex);
                    String id = car.get("ID");
                    String status = car.get("Status");

                    cars.add(id);
                    car.replace("Status", "Not");

                    System.out.println("Successfully Rented");
                }
            } else if (activity == 6)
            {
                if (cars.size() == 0)
                {
                    System.out.println("\nYou have no cars");
                } else
                {
                    System.out.println("\nSelect a car you want to return");
                    String model = "";
                    for (int i = 0; i < cars.size(); i++)
                    {
                        for (int j = 0; j < carDetails.size(); j++)
                        {
                            HashMap<String, String> carTemp = (HashMap<String, String>) carDetails.get(j);
                            String id = carTemp.get("ID");
                            model = carTemp.get("Model");
                            if (id.equals(cars.get(i)))
                            {
                                System.out.println(cars.get(i) + " - " + model);
                            }
                        }

                    }
                    int selectedCarIndex;
                    do
                    {
                        selectedCarIndex = kb.nextInt();
                        selectedCarIndex = selectedCarIndex - 1;

                        if (selectedCarIndex >= cars.size() && selectedCarIndex < 0)
                        {
                            System.out.println("\nTry again");
                        }
                    } while (selectedCarIndex >= cars.size() && selectedCarIndex < 0);

                    System.out.println("\nNumber of Days Car was Rented");
                    int days = kb.nextInt();

                    cars.remove(String.valueOf((selectedCarIndex)));

                    car = (HashMap<String, String>) carDetails.get(selectedCarIndex);
                    model = car.get("Model");
                    String status = car.get("Status");
                    String priceString = car.get("Price");

                    double price = Double.parseDouble(priceString);
                    String balanceString = (String) user.get("Balance");
                    double balance = Double.parseDouble(balanceString);
                    balance = balance - (price * days);
                    String doubleString = String.valueOf(balance);

                    user.replace("Balance", doubleString);
                    car.replace("Status", "Ava");

                    System.out.println("Successfully Removed");

                    System.out.println("\nRental Summary:");
                    System.out.println(model + " with a rental fee of " + price + " per day was rented for " + days + " days");
                    System.out.println("Total Rental Fee is " + (price * days) + " and account balance is " + balance);
                }
            }
        } while (true);
    }
}


