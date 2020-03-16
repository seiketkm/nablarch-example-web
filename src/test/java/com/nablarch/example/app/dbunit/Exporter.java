package com.nablarch.example.app.dbunit;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

public class Exporter implements AutoCloseable {

    public Exporter(DatabaseConnection conn) {
        this.conn = conn;
    }

    public static void main(String[] args) throws SQLException, IOException, DataSetException {

        DatabaseConnection conn = DataSourceInitializer.getDatabaseConnection();
        try (Exporter me = new Exporter(conn)) {
            me.export();
        }
    }

    private final DatabaseConnection conn;

    void export() throws SQLException, IOException, DataSetException {

        IDataSet dataset = conn.createDataSet();
        try (OutputStream out = new FileOutputStream("export.xls")) {
            XlsDataSet.write(dataset, out);
        }
    }

    @Override
    public void close() throws SQLException {
        conn.close();
    }
}
