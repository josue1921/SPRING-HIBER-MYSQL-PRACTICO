package com.app.ibatis.mapper;

import com.app.ibatis.entity.Constact;
import java.util.List;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface ContactMapper {
    //@Insert("INSERT INTO CONTACT ( name, phone, mail, photo ) VALUES ( #{contact.name}, #{contact.phone},#{contact.mail},#{contact.photo})")
	//Integer insertContact(@Param("contact") Constact constact) throws Exception;
	
    @Select(value = "{CALL UPCONTACT(#{contact.name}, #{contact.phone},#{contact.mail},#{contact.photo}, #{contact.mailuser})}")
    @Options(statementType = StatementType.CALLABLE) String insertContact(@Param("contact") Constact constact) throws Exception;   
    
    @Select("select * from contact")
    List<Constact> getContacts();

    @Select(value = "{CALL LOWCONTACT(#{personId},#{mailUser})}")
    @Options(statementType = StatementType.CALLABLE) String lowPersonContact(@Param("personId") Integer personId, @Param("mailUser") String mailUser) throws Exception;   

}


