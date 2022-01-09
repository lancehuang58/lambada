package lambada.dao;

import lombok.extern.slf4j.Slf4j;
import lambada.entity.Track;
import lambada.mapper.TrackMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TrackDao extends ServiceImpl<TrackMapper, Track> {}
