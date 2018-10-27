package com.tpm.tobitoi.prototype.internal.utils;

public interface IConstants {
    /**
     * Jurnal API
     */
    interface IApis {
        String LOGIN = "v1/login";
        String LOGOUT = "v1/logout";
        String SWITCH_COMPANY = "v1/users/switch_company";
        String DASBHOARD_SALES ="v1/dashboard/sales";
        String DASHBOARD_PURCHASE = "v1/dashboard/purchases";
        String DASHBOARD_EXPENSE = "v1/dashboard/expenses";
        String DASHBOARD_PROFITLOSS = "v1/dashboard/profit_loss";
        String REPORTS = "v1/reports/menu";
        String BALANCE_SHEET = "v1/balance_sheet";
        String PROFIT_AND_LOSS = "v1/profit_and_loss";
        String CASH_FLOW = "internal/cash_flow";
        String SALES_INVOICES = "v1/sales_invoices";
        String EXPENSE = "v1/expenses";
        String EXPENSE_DETAIL = "v1/expenses/{id}";
        String PRODUCTS = "v1/products";
        String SALES_INVOICE_DETAILS = "v1/sales_invoices/{id}";
        String SALES_OVERVIEW = "v1/overview/sales/";
        String PRODUCT_DETAILS = "v1/products/{id}";
        String PRODUCT_DETAILS_STOCK = "v1/products/{id}/stock_info";
        String PRODUCT_TRANSACTION = "v1/products/{id}/transaction_info";
        String WAREHOUSE = "v1/warehouses";
        String PURCHASE_OVERVIEW = "v1/overview/purchases";
        String PURCHASE_INVOICES = "v1/purchase_invoices";
        String PURCHASE_INVOICE = "v1/purchase_invoices/{id}";


    }

    /**
     * Object Prefixes
     */
    interface IPrefixes {
        String CORE = "key/core/api/";
        String JWT = "jwt/core/api/";
    }

    /**
     * Parcelable Objects
     */
    interface IBundles {
        String MENU = "menu";

        String DASHBOARD = "dashboard";
        String BALANCESHEET = "balancesheet";
        String BALANCESHEET_FILTER = "balancesheet_filter";
        String PROFIT_AND_LOSS = "profit_and_loss";
        String PROFIT_AND_LOSS_FILTER = "profit_and_loss_filter";
        String CASHFLOW = "cashflow";
        String CASHFLOW_FILTER = "cashflow_filter";
    }

    /**
     * Navigation Menu
     */
    interface IMenus {
        int DASHBOARD = 1;
        int REPORTS = 2;
        int CASH_BANK = 3;
        int SALES = 4;
        int PURCHASES = 5;
        int EXPENSES = 6;
        int CUSTOMERS = 7;
        int VENDORS = 8;
        int PRODUCTS = 9;
        int ASSETS = 10;
        int CHART_OF_ACCOUNTS = 11;
        int OTHER_LIST = 12;
        int OPTIONS = 13;
        int LOGOUT = 14;
    }

    /**
     * Options Menu
     */
    interface IOptions {
        int COMPANIES = 1;
        int COMPANY = 2;
        int ACCOUNT = 3;
        int LANGUAGE = 4;
        int GUIDE_BOOK = 6;
        int SUPPORT = 7;
    }

    /**
     * Reports Menu
     */
    interface IReports {
        int BUSINESS_OVERVIEW = 1;
        int SALES = 2;
        int PURCHASES = 3;
        int PRODUCTS = 4;
        int ASSETS = 5;
        int FOREIGN_EXCHANGE = 6;
    }

    /**
     * Business Overview Reports
     */
    interface IBusinessOverview {
        int BALANCE_SHEET = 1;
        int PROFIT_LOSS = 2;
        int CASH_FLOW = 3;
        int STATEMENT_OF_CHANGE_IN_EQUITY = 4;
        int GENERAL_LEDGER = 6;
        int BANK_RECONCILIATION_SUMMARY = 7;
        int JOURNAL = 8;
        int TRIAL_BALANCE = 9;
    }

    /**
     * URL Business Overview Reports
     */
    interface BaseUrl {
        String STATEMENTOFCHANGEINEQUITY = "reports/statement_of_change_in_equity";
        String GENERALLEDGER = "reports/account_transaction";
        String BANKRECONCILIATIONSUMMARY = "reports/bank_reconciliation_summary";
        String JOURNALS = "reports/journal";
        String TRIALBALANCE = "reports/trial_balance";
    }

    /**
     * Sales Reports
     */
    interface ISales {
        int SALES_LIST = 1;
        int CUSTOMER_BALANCE = 2;
        int SALES_DELIVERY_REPORT = 3;
        int SALES_BY_CUSTOMER = 4;
        int AGED_RECEIVABLE = 5;
        int SALES_BY_PRODUCT = 6;
    }

    /**
     * URL Sales Reports
     */
    interface BaseUrlSalesReport{

        String SALESLIST = "reports/sales_list";
        String CUSTOMERBALANCE = "reports/sales_delivery";
        String SALESDELIVERYREPORT = "reports/sales_by_customer";
        String SALESBYCUSTOMER = "reports/sales_by_customer";
        String AGEDRECEIVABLE = "reports/aged_receivable";
        String SALESBYPRODUCT = "reports/sales_by_product";
    }

    /**
     * Purchase Reports
     */
    interface IPurchase {
        int PURCHASE_LIST = 1;
        int VENDOR_BALANCE = 2;
        int EXPENSE_DETAILS = 3;
        int PURCHASE_DELIVERY_REPORT = 4;
        int PURCHASE_BY_VENDOR = 5;
        int EXPENSE_LIST = 6;
        int AGED_PAYABLE = 7;
        int PURCHASE_BY_PRODUCT = 8;
    }

    /**
     * URL Purchase Reports
     */
    interface BaseUrlPurchaseReport{

        String PURCHASELIST = "reports/purchases_list";
        String VENDORBALANCE = "reports/vendor_balance";
        String EXPENSEDETAILS = "reports/expense_details";
        String PURCHASEDELIVERYREPORT = "reports/purchases_delivery";
        String PURCHASEBYVENDOR = "reports/purchases_by_vendor";
        String EXPENSELIST = "reports/expense_list";
        String AGEDPAYABLE ="reports/aged_payable";
        String PURCHASEBYPRODUCT = "reports/purchases_by_product ";
    }

    /**
     * Product Reports
     */
    interface IProduct {
        int INVENTORI_SUMMARY = 1;
        int INVENTORY_VALUATION = 2;
        int INVENTORI_DETAILS = 3;
        int WAREHOUSE_STOCK_QUANTITY = 4;
        int WAREHOUSE_ITEMS_VALUATION = 5;
        int WAREHOUSE_ITEMS_STOCK_MOVEMENT = 6;
    }

    /**
     * URL Product Reports
     */
    interface BaseUrlProductReport{

        String INVENTORISUMMARY = "reports/inventory_summary";
        String INVENTORYVALUTION = "reports/inventory_valuation";
        String INVENTORIDETAILS = "reports/inventory_details";
        String WAREHOUSESTOCKQUANTITY = "reports/warehouse_stock_quantity";
        String WAREHOUSEITEMVALUTION = "reports/warehouse_items_valuation";
        String WAREHOUSEITEMSSTOCKMOVEMENT = "reports/warehouse_items_stock_movement_summary";
    }

    /**
     * Assets Reports
     */
    interface IAssets {
        int FIXED_ASSET_SUMMARY = 1;
        int FIXED_ASSET_DETAILS = 2;
    }

    /**
     * URL ASSET Reports
     */
    interface BaseUrlAssetReport{

        String FIXEDASSETSUMMARY = "reports/fixed_asset_summary";
        String FIXEDASSETDETAILS = "reports/fixed_asset_details";
    }

    /**
     * Foreign Exchange Reports
     */
    interface IForeignExchange {
        int BANK_SUMMARY = 1;
        int FOREIGN_EXCHANGE_GAIN_LOSS = 2;
        int REALISED_CURRENCY_GAIN_LOSS = 3;
        int UNREALISED_CURRENCY_GAIN_LOSS = 4;
    }

    /**
     * URL Foreign Exchange  Reports
     */
    interface BaseUrlForeignExchangeReport{

        String BANKSUMMARY = "reports/bank_summary";
        String FOREIGNEXCHANGEGAINLOSS = "reports/foreign_exchange_gain_loss";
        String REALISEDCURRENCYGAINLOSS = "reports/realised_currency_gain_loss";
        String UNREALISEDCURRENCYGAINLOSS = "reports/unrealised_currency_gain_loss";
    }

    /**
     * URL Option
     */
    interface BaseUrlOption{

        String COMPANYSETTING = "company/setting";
        String ACCOUNT = "user_account/profile";
    }

    /**
     * Format Patterns
     */
    interface IPatterns {
        String ddMMyyyy = "dd/MM/yyyy";
    }

    /**
     * Intent Request Codes
     */
    interface IRequestCodes {
        int BALANCESHEET_FILTER = 300;
        int PROFIT_AND_LOSS_FILTER = 301;
        int CASHFLOW_FILTER = 302;
    }
}