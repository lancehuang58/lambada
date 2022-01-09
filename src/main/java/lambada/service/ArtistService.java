package lambada.service;

import lambada.entity.Artist;

import java.util.List;

public interface ArtistService {
  List<Artist> getAll();

  List<Artist> getArtistFrom(String location);
}
