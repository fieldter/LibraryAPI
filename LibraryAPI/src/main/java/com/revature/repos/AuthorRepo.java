package com.revature.repos;

import com.revature.models.Author;
import com.revature.utils.ConnectionFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AuthorRepo implements AuthorRepoInterface {


    @Override
    public Author getAuthorById(int id) {

        try(Connection conn = ConnectionFactory.getConnection()){

            String sql = "select * from library.authors where author_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();


            while(rs.next()) {

                return new Author(
                        rs.getInt("author_id"),
                        rs.getString("author_name")
                );

            }


        } catch (SQLException e) {
            System.out.println("Something went wrong fetching this data!!");
            e.printStackTrace();
        }

        return null;
    }

}
