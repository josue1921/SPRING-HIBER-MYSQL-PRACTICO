package com.app.ibatis.controller;
import com.app.ibatis.entity.Constact;
import com.app.ibatis.entity.User;
import com.app.ibatis.mapper.ContactMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@Path("/contacts")
public class ContactController {
	static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@Autowired
	private ContactMapper contactMapper;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(Constact constact) {
		LinkedHashMap<Object, Object> serviceResponse = new LinkedHashMap<Object, Object>();
		logger.info("Inicia la creación de usuarios..");
		
		try {
			Set<ConstraintViolation<Constact>> validateErrors = validator.validate(constact);
			if (validateErrors.isEmpty()) {
				logger.info("Validacion validateErrors es concluida..");
					logger.info("Inicia el insert y registro de los datos en BD..");
					Integer createPerson = contactMapper.insertContact(constact);

					if (createPerson != 1) {
						logger.info("No se pudo crear al usuario..");
						serviceResponse.put("message", "No se puede crear el contacto");
					} else {
						logger.info("SUCCES USUARIO CREADO.");
						serviceResponse.put("message", "Contacto Registrado");
					}
				
				logger.info("Responde con peticion aceptada estatus 200 todo exitoso..");
				return Response.status(Response.Status.CREATED).entity(serviceResponse).build();
			} else {
				logger.info("Failed to create a user due to field validation errors.");
				logger.debug("Unable to create a user due to validation errors using {}", constact);
				// JSONObject jsonObj = new JSONObject(validateErrors.toString());
				serviceResponse.put("message", validateErrors.toString());
				return Response.status(400).entity(serviceResponse).build();

			}
		} catch (Exception e) {
			logger.debug("<< create()");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(serviceResponse).build();
		}
	}
	@GET
	@Produces("application/json")
	public Response getContacts() {
		logger.info("Entra obtener el total de los contactactos.");
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		try {
			List<Constact> listContacts = contactMapper.getContacts();
			if (listContacts == null) {
				logger.info("Sin datos.");
				response.put("users", Collections.emptyMap());
			} else {
				logger.info("Consulta exitosa, existen datos.");
				response.put("total", listContacts.size());
				response.put("users", listContacts);
			}
			logger.info("Se devuelven los datos y se expone el servicio.");
			return Response.status(Response.Status.OK).entity(listContacts).build();
		} catch (Exception ex) {
			logger.info("Ocurrio un error en el proceso de la consulta.");
			response.put("user", "Not Found");
			return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
		}
	}
}
