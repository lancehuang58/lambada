package lambada.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("album")
public class Album extends Model<Album> implements Serializable {
  private static final long serialVersionUID = 1L;

  /** id */
  @TableId private Integer id;
  /** trackId */
  private Integer trackId;
}
