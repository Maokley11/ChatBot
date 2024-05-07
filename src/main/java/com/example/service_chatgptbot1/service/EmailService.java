package com.example.service_chatgptbot1.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailService {

    public void saveEmail(String email) {
        Connection connection = null;
        PreparedStatement countStatement = null;
        PreparedStatement insertStatement = null;
        ResultSet resultSet = null;

        try {
            // Verbindung zur Datenbank herstellen
            connection = DriverManager.getConnection("YourConnectionStringHere");

            // SQL-Abfrage, um die Anzahl der Einträge mit dieser E-Mail-Adresse zu zählen
            String countQuery = "SELECT COUNT(KundeMail) FROM Kunde WHERE KundeMail = ?";
            countStatement = connection.prepareStatement(countQuery);
            countStatement.setString(1, email);
            resultSet = countStatement.executeQuery();

            // Überprüfen, ob die E-Mail-Adresse bereits vorhanden ist
            if (resultSet.next() && resultSet.getInt(1) == 0) {
                // Die E-Mail-Adresse ist neu, daher in die Datenbank einfügen
                String insertQuery = "INSERT INTO Kunde (KundeMail) VALUES (?)";
                insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setString(1, email);
                insertStatement.executeUpdate();
            } else {
                // Die E-Mail-Adresse ist bereits vorhanden, daher eine entsprechende Nachricht senden
                System.out.println("E-Mail-Adresse ist vorhanden. Wie kann ich Ihnen weiterhelfen?");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Ressourcen schließen
            try {
                if (resultSet != null) resultSet.close();
                if (countStatement != null) countStatement.close();
                if (insertStatement != null) insertStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
