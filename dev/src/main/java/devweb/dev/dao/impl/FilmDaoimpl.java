package devweb.dev.dao.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import devweb.dev.dao.FilmDao;
import devweb.dev.entities.Film;

public class FilmDaoimpl implements FilmDao{

	@Override
	public Film getFilm(Integer id) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM film WHERE film_id = ?")) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						return  new Film(resultSet.getInt("id"), resultSet.getString("name"), 
								resultSet.getDate("releaseDate").toLocalDate(), resultSet.getInt("duration"), 
								resultSet.getString("director"), resultSet.getString("summary"),resultSet.getInt("note"),resultSet.getString("acteur"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Film addFilm(Film film) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO film(id,name, releaseDate,duration, director, summary,acteur,note) VALUES(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, film.getTitle());
				statement.setDate(2, Date.valueOf(film.getReleaseDate()));
				statement.setInt(3, film.getDuration());
				statement.setString(4, film.getDirector());
				statement.setString(5, film.getSummary());
				statement.setString(6, film.getActeur());
				statement.setInt(7,film.getNote());
				statement.setInt(8, film.getId());
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						film.setId(resultSet.getInt(1));
						return film;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
