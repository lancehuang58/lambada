package lambada.dao;

import lombok.extern.slf4j.Slf4j;
import lambada.entity.Artist;
import lambada.mapper.ArtistMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class ArtistDao extends ServiceImpl<ArtistMapper, Artist> {}
