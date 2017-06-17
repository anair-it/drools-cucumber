package playlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private List<Song> songs = new ArrayList<>();

	public Playlist() {}

	public Playlist(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public boolean addSong(Song song) {
		return songs.add(song);
	}
}
