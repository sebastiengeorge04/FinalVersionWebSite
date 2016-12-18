package devweb.dev.entities;

import java.time.LocalDate;

public class Film {
	private Integer id;
	private String title;
	private LocalDate releaseDate;
	private Integer duration;
	private String director;
	private String summary;
    private String name;
    private String acteur;
    public String getActeur() {
		return acteur;
	}

	public void setActeur(String acteur) {
		this.acteur = acteur;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	private Integer note;
    
	public Film(Integer id, String name, LocalDate releaseDate, Integer duration, String director,
			String summary,Integer note,String acteur) {
		super();
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.director = director;
		this.summary = summary;
		this.note=note;
		this.acteur=acteur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}


