package lambada.dao;

import lombok.extern.slf4j.Slf4j;
import lambada.entity.Album;
import lambada.mapper.AlbumMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class AlbumDao extends ServiceImpl<AlbumMapper, Album> {}
