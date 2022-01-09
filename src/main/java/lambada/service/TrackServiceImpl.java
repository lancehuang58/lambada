package lambada.service;

import lambada.dao.TrackDao;
import lambada.entity.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

  private final TrackDao trackDao;

  @Override
  public List<Track> getAll() {
    return trackDao.list();
  }
}
