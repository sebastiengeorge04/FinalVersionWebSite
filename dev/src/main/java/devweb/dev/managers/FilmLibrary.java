package devweb.dev.managers;

import java.util.List;

import devweb.dev.dao.impl.FilmDaoimpl;
import devweb.dev.dao.FilmDao;

import devweb.dev.dao.impl.FilmDaoimpl;
import devweb.dev.entities.Film;


public class FilmLibrary {
	
	private static class FilmLibraryHolder {
		private final static FilmLibrary instance = new FilmLibrary();
	}
	
	public static FilmLibrary getInstance() {
		return FilmLibraryHolder.instance;
	}
	
	private FilmDao filmDao = new FilmDaoimpl();
	

	private FilmLibrary() {
	}


	public Film getFilm(Integer id) {
		return filmDao.getFilm(id);
	}

	public Film addFilm(Film film) {
		return filmDao.addFilm(film);
	}





}

