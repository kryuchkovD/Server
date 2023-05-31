package com.samsung.springtest.repository;

import com.samsung.springtest.domain.Sites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public interface SitesRepository extends JpaRepository<Sites, Long> {
    static Sites getSitesByUrl(String url) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Sites sites = null;

        try {
            // получаем соединение с базой данных
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/reliab", "postgres", "Beautiful220206.");

            // создаем PreparedStatement для выполнения запроса
            stmt = conn.prepareStatement("SELECT * FROM sites WHERE sites.url = ?");
            stmt.setString(1, url);

            // выполняем запрос и получаем результаты
            rs = stmt.executeQuery();

            // если запрос вернул результаты, создаем объект Record и заполняем его данными из результата запроса
            if (rs.next()) {
                sites = new Sites();
                sites.setName(rs.getString("name"));
                sites.setUrl(rs.getString("url"));
                sites.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // закрываем все открытые ресурсы
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return sites;
    }
}