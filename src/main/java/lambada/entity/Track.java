package lambada.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (track)实体类
 *
 * @author kancy
 * @since 2022-01-09 21:23:31
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("track")
public class Track extends Model<Track> implements Serializable {
  private static final long serialVersionUID = 1L;

  /** id */
  @TableId private Integer id;
  /** name */
  private String name;
}
