package devweb.dev.dao;

import devweb.dev.entities.Film;
import java.util.List;

public interface FilmDao {
	

	public Film getFilm(Integer id);

	public Film addFilm(Film film);
	

}
