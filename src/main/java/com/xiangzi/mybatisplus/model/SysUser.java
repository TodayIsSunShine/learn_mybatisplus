package com.xiangzi.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianjiu
 * @since 2019-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String password;

    private String salt;

    private Integer state;

    private String username;

    private LocalDateTime createdTime;

    private LocalDateTime modifyTime;

    private Integer createdBy;

    private Integer modifyBy;


}
