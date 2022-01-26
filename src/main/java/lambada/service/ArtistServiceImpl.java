package lambada.service;

import lambada.dao.ArtistDao;
import lambada.entity.Artist;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements ArtistService {

  private final ArtistDao artistDao;

  @Override
  public List<Artist> getAll() {
    return artistDao.list();
  }

  @Override
  public List<Artist> getArtistFrom(String location) {
    Predicate<Artist> p = artist -> StringUtils.equalsIgnoreCase(artist.getOrigin(), location);
    return getAll().stream().filter(p).collect(Collectors.toList());
  }
}
