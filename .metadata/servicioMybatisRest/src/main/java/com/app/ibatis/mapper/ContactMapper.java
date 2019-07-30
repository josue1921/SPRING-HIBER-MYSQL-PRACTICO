package com.app.ibatis.mapper;

import com.app.ibatis.entity.Constact;

import java.util.List;
import org.apache.ibatis.annotations.*;
import com.app.ibatis.entity.Constact;

@Mapper
public interface ContactMapper {
    @Insert("INSERT INTO CONTACT ( name, phone, mail, photo ) VALUES ( #{contact.name}, #{contact.phone},#{contact.mail},#{contact.photo})")
    Integer insertContact(@Param("contact") Constact constact) throws Exception;

    @Select("select * from contact")
    List<Constact> getContacts();
}
