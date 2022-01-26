package lambada.controller;

import lambada.entity.Artist;
import lambada.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArtistController {

  private final ArtistService artistService;

  @GetMapping(value = "/artist")
  public List<Artist> listArtist() {
    return artistService.getAll();
  }

  @GetMapping(value = "/artist/from/{location}")
  public List<Artist> listArtistFrom(@PathVariable String location) {
    return artistService.getArtistFrom(location);
  }
}
