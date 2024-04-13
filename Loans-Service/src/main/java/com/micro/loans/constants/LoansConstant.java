package com.micro.loans.constants;

public class LoansConstant {
    private LoansConstant() {
        //restrict instantiation
    }
    public static final String STATUS_400="STATUS_400";
    public static final String MESSAGE_400="Invalid request,Please try again after some time";

    public static final String STATUS_404="STATUS_404";
    public static final String MESSAGE_404="Resource not found !!!";
    public static final String STATUS_201="STATUS_201";
    public static final String MESSAGE_201="Loan is created successfully";
    public static final int NEW_LOAN_LIMIT=100000;
    public static final String STATUS_200="STATUS_200";
    public static final String MESSAGE_200="Request processed successfully";
    public static final String STATUS_500="STATUS_500";
    public static final String MESSAGE_500="Server is unable to process current request";

}
