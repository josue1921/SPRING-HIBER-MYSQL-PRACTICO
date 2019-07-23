package com.app.ibatis.mapper;
import java.util.List;
import org.apache.ibatis.annotations.*;
import com.app.ibatis.entity.User;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER ( first_name,last_name, email,password ) VALUES ( #{user.first_name}, #{user.last_name},#{user.email},#{user.password})")
    Integer insertUser(@Param("user") User user) throws Exception;

    @Select("select * from user where email = #{email}")
    User findByEmail(@Param("email") String email);

    @Select("select * from user where email = #{email} AND id!=#{id}")
    User findByEmailNotUser(@Param("email") String email,@Param("id") Integer id);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where email = #{email} AND password = #{password}")
    User login(@Param("email") String email,@Param("password") String password);


    @Select("select * from user")
    List<User> getUsers();

    @Update("UPDATE USER SET first_name = #{user.first_name},last_name = #{user.last_name},email = #{user.email},phone = #{user.phone},age = #{user.age} WHERE id = #{user.id}")
    Integer updateUser(@Param("user") User user) throws Exception;

    @Delete("DELETE from user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);
}