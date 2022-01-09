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
@TableName("artist")
public class Artist extends Model<Artist> implements Serializable {
  private static final long serialVersionUID = 1L;

  /** id */
  @TableId private Integer id;
  /** name */
  private String name;
  /** members */
  private String members;
  /** origin */
  private String origin;
}
