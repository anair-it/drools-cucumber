package playlist;

import java.io.Serializable;

public class Song implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Genre {
		JAZZ, ROCK, POP, CLASSICAL
	};

	private String title;
	private Genre type;
	private Artist artist;
	private int duration;

	public Song() {}

	public Song(String name, Genre type, int duration) {
		this();
		this.title = name;
		this.type = type;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public Genre getGenre() {
		return type;
	}

	public void setGenre(Genre type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
