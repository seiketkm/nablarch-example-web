package com.nablarch.example.app.dbunit;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ITableIterator;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.dataset.filter.DefaultColumnFilter;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @see <a href="http://dbunit.sourceforge.net/howto.html">Getting Started</a> Ignoring some columns in comparison
 */
public class Comparator {

    public static void main(String[] args) throws Exception {
        DatabaseConnection conn = DataSourceInitializer.getDatabaseConnection();
        Comparator me = new Comparator(conn);
        me.compare(new File("./export.xls"));
    }

    private final DatabaseConnection conn;

    public Comparator(DatabaseConnection conn) {
        this.conn = conn;
    }


    /**
     * 期待値が記載されたxlsファイルと実際のデータベースを比較する。
     * 期待値のファイルに記載されたテーブル、カラムのみが比較対象となる。
     *
     * @param xlsFile 期待値が記載されたxlsファイル
     * @throws Exception 予期しない例外
     */
    void compare(File xlsFile) throws Exception {
        compare(new XlsDataSet(xlsFile));
    }


    void compare(IDataSet expectedDataSet) throws DatabaseUnitException, SQLException {
        String[] tableNames = expectedDataSet.getTableNames();
        IDataSet actualDataSet = conn.createDataSet(tableNames);
        ITableIterator itr = expectedDataSet.iterator();
        while (itr.next()) {
            ITable expectedTable = itr.getTable();
            String tableName = expectedTable.getTableMetaData().getTableName();
            ITable actualTable = actualDataSet.getTable(tableName);
            compare(expectedTable, actualTable);
        }
    }

    private void compare(ITable expected, ITable actual) throws DatabaseUnitException {
        Column[] columns = expected.getTableMetaData().getColumns();
        ITable filteredTable = DefaultColumnFilter.includedColumnsTable(actual, columns);
        Assertion.assertEquals(expected, filteredTable);
    }
}
