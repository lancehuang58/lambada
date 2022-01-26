package lambada.controller;

import lambada.entity.Track;
import lambada.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TrackController {
  private final TrackService trackService;

  @GetMapping("track")
  public List<Track> getTracks() {
    return trackService.getAll();
  }
}
