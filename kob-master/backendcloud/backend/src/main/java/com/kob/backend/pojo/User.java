package com.kob.backend.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type= IdType.AUTO)
    public Integer id;
    public String username;
    public String password;
    private String photo;
    private Integer rating;


}
