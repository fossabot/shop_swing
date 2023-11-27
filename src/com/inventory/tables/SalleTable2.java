package com.inventory.tables;

import com.inventory.DAO.CaisseDAO;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.inventory.DAO.ProductDAO;

public class SalleTable2 extends DefaultTableModel {

    public SalleTable2() {

    }

    public DefaultTableModel generateTable( ) {
        return TableData.generateTable(this.getRows(), this.getColums());
    }

    public DefaultTableModel generateSearchTable(String txt) {
        return TableData.generateTable(getRowsSearch(txt), this.getColums());
    }

    public DefaultTableModel generateSearchDateTable(String start, String end) {
        return TableData.generateTable(this.getRowsSearchDate(start, end), this.getColums());
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3; // To change body of generated methods, choose Tools | Templates.
    }

    String getTableName() {
        return "salledata";
    }

    public String[] getColums() {
        String[] COLUMNS = {
            "idVente", "Date", "Code_Client", "Total_payee", "recu", "retourner", "Vender_par"
        };
        return COLUMNS;

    }

    ResultSet getData() {
        CaisseDAO productDAO = new CaisseDAO();

        ResultSet res = productDAO.getSalesOnly();
        // ResultSetMetaData metaData = res.getMetaData();
        // int colCount = metaData.getColumnCount();
        return res;
    }

    ResultSet getSearchData(String txt) {
        CaisseDAO productDAO = new CaisseDAO();

        ResultSet res = productDAO.getSalesOnlySearchInfo(txt);
        // ResultSetMetaData metaData = res.getMetaData();
        // int colCount = metaData.getColumnCount();
        return res;
    }

    ResultSet getSearchByDateData(String start, String end) {
        CaisseDAO productDAO = new CaisseDAO();

        ResultSet res = productDAO.getDateOfSalesOnlySearchInfo(start, end);
        // ResultSetMetaData metaData = res.getMetaData();
        // int colCount = metaData.getColumnCount();
        return res;
    }

    public Object[][] getRows() {
        ResultSet res = this.getData();
        ResultSet res2 = this.getData();

        Object[][] ROWS = TableData.fetchDataQuery(this.getTableName(), res, this.getColumnCount(), new ProductDAO().fetchDataCount3(res2));
        return ROWS;
    }

    public Object[][] getRowsSearch(String txt) {
        ResultSet res = this.getSearchData(txt);
        ResultSet res2 = this.getSearchData(txt);
        Object[][] ROWS = TableData.fetchDataQuery(this.getTableName(), res, this.getColumnCount(), new ProductDAO().fetchDataCount3(res2));
        return ROWS;
    }

    public Object[][] getRowsSearchDate(String start, String end) {
        ResultSet res = this.getSearchByDateData(start, end);
        ResultSet res2 = this.getSearchByDateData(start, end);
        Object[][] ROWS = TableData.fetchDataQuery(this.getTableName(), res, this.getColumnCount(), new ProductDAO().fetchDataCount3(res2));
        return ROWS;
    }
}
