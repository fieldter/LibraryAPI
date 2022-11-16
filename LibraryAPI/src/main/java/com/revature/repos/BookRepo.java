package com.revature.repos;

import com.revature.models.Author;
import com.revature.models.Book;
import com.revature.utils.ConnectionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

    @Query(value = "FROM Book WHERE author_id = :authorId")
    public List<Book> findAllByAuthorId(int authorId);

    /*
    @Override
    public List<Book> getAllBooks() {
        AuthorRepo ar = new AuthorRepo();
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "select * from library.books;";
            ResultSet rs;
            Statement s = conn.createStatement();
            rs = s.executeQuery(sql);

            ArrayList<Book> bookList = new ArrayList<>();

            while (rs.next()) {

                Book b = new Book(
                        rs.getInt("book_id"),
                        rs.getString("book_title"),
                        rs.getBoolean("is_stocked"),
                        null
                );

                int authorId = rs.getInt("author_id_fk");

                Author a = ar.getAuthorById(authorId);
                b.setAuthorFk(a);

                System.out.println(b);

                bookList.add(b);
            }

            return bookList;

        } catch (SQLException e) {
            System.out.println("Something went wrong selecting all books!");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Book insertBook (Book b){

        try(Connection conn = ConnectionFactory.getConnection()){

            String sql = "insert into library.books (book_title, is_stocked, author_id_fk)"
                    + "values (?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, b.getTitle());
            ps.setBoolean(2, b.getIsStocked());
            ps.setInt(3, b.getAuthorFk().getAuthorId());

            ps.executeUpdate();

            return b;

        } catch (SQLException e) {
            System.out.println("Something went wrong inserting Employee!");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Book getBookById (int id){

        AuthorRepo ar = new AuthorRepo();
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "select * from library.books where book_id=?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            ArrayList<Book> bookList = new ArrayList<>();

            while (rs.next()) {

                Book b = new Book(
                        rs.getInt("book_id"),
                        rs.getString("book_title"),
                        rs.getBoolean("is_stocked"),
                        null
                );

                int authorId = rs.getInt("author_id_fk");

                Author a = ar.getAuthorById(authorId);
                b.setAuthorFk(a);

                System.out.println(b);

                return b;
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong selecting all books!");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Book> getBooksByAuthorId (int id) {
        AuthorRepo ar = new AuthorRepo();
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "select * from library.books where author_id_fk=?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            ArrayList<Book> bookList = new ArrayList<>();

            while (rs.next()) {

                Book b = new Book(
                        rs.getInt("book_id"),
                        rs.getString("book_title"),
                        rs.getBoolean("is_stocked"),
                        null
                );

                int authorId = rs.getInt("author_id_fk");

                Author a = ar.getAuthorById(authorId);
                b.setAuthorFk(a);

                System.out.println(b);

                bookList.add(b);
            }

            return bookList;

        } catch (SQLException e) {
            System.out.println("Something went wrong selecting all books!");
            e.printStackTrace();
        }

        return null;
    }
    */
}
