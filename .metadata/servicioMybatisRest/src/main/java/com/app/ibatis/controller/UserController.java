package com.app.ibatis.controller;

import com.app.ibatis.entity.User;
import com.app.ibatis.entity.Constact;
import com.app.ibatis.mapper.UserMapper;
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
@Path("/users")
public class UserController {
	static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Autowired
	private UserMapper userMapper;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(User user) {
		LinkedHashMap<Object, Object> serviceResponse = new LinkedHashMap<Object, Object>();
		logger.info("Inicia la creación de usuarios..");

		try {
			Set<ConstraintViolation<User>> validateErrors = validator.validate(user);
			if (validateErrors.isEmpty()) {
				logger.info("Validacion validateErrors es concluida..");
				if (userMapper.findByEmail(user.getEmail()) != null) {
					logger.info("Validacion de mail existente exitosa, existe ya un mail en la BD..");
					serviceResponse.put("message", "La direccion de mail ya se encuentra registrado.");
					return Response.status(400).entity(serviceResponse).build();
				} else {
					logger.info("Inicia el insert y registro de los datos en BD..");
					Integer createPerson = userMapper.insertUser(user);

					if (createPerson != 1) {
						logger.info("No se pudo crear al usuario..");
						serviceResponse.put("message", "No se puede crear el usuario");
					} else {
						logger.info("SUCCES USUARIO CREADO.");
						serviceResponse.put("message", "Usuario Registrado");
					}
				}
				logger.info("Responde con peticion aceptada estatus 200 todo exitoso..");
				return Response.status(Response.Status.CREATED).entity(serviceResponse).build();
			} else {
				logger.info("Failed to create a user due to field validation errors.");
				logger.debug("Unable to create a user due to validation errors using {}", user);
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
	public Response getUsers() {
		logger.info("Entra obtener el total de datos de usuarios.");
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		try {
			List<User> listUsers = userMapper.getUsers();
			if (listUsers == null) {
				logger.info("Sin datos.");
				response.put("users", Collections.emptyMap());
			} else {
				logger.info("Consulta exitosa, existen datos.");
				response.put("total", listUsers.size());
				response.put("users", listUsers);
			}
			logger.info("Se devuelven los datos y se expone el servicio.");
			return Response.status(Response.Status.OK).entity(listUsers).build();
		} catch (Exception ex) {
			logger.info("Ocurrio un error en el proceso de la consulta.");
			response.put("user", "Not Found");
			return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Produces("application/json")
	public Response updateUser(@PathParam("id") Integer id, User user) {
		// String personJson = gson.toJson(user);
		// logger.debug(">> create({})", personJson);
		// LinkedHashMap<Object, Object> apiResponse = new LinkedHashMap<>();
		LinkedHashMap<Object, Object> serviceResponse = new LinkedHashMap<Object, Object>();
		logger.info("Comienza con la carga de los datos a editar");

		try {
			Set<ConstraintViolation<User>> validateErrors = validator.validate(user);
			logger.info("Entro a validar validateErrors");
			if (validateErrors.isEmpty()) {
				if (userMapper.findById(id) == null) {
					logger.info("Id que se quiere actualizar no existe");
					serviceResponse.put("message", "Usuario no existe.");
				} else {
					if (userMapper.findByEmailNotUser(user.getEmail(), user.getId()) != null) {
						serviceResponse.put("message", "Usuario ya existe en la BD");
						logger.info("El usuarios si existe en la BD..");
					} else {
						int updateUser = userMapper.updateUser(user);
						if (updateUser == 0) {
							serviceResponse.put("message", "No se puede actualizar el usuario");
							logger.info("No se puede actualizar al usuario..");
						} else {
							serviceResponse.put("message", "Se actualizo el usuario exitosamente.");
							logger.info("Modificacion exitosa.");
						}
					}
				}
				//return Response.status(Response.Status.OK).entity(user).build();
				return Response.status(Response.Status.OK).entity(serviceResponse).build();
			} else {
				logger.info("Failed to update a user due to field validation errors.");
				// logger.debug("Unable to update a user due to validation errors using {}",
				// personJson);
				logger.info("La validacion validateErrors encontro un error..");
				serviceResponse.put("message", validateErrors.toString());
				return Response.status(400).entity(serviceResponse).build();
			}
		} catch (Exception e) {
			logger.info("Se encontro un error en el flujo..");
			logger.debug("<< create()");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(serviceResponse).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getPerson(@PathParam("id") int userId) {

		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();

		try {
			User user = userMapper.findById(userId);

			if (user == null) {
				response.put("User", Collections.emptyMap());
			} else {
				response.put("user", user);
			}
			return Response.status(Response.Status.OK).entity(user).build();
		} catch (Exception ex) {

			response.put("user", "Not Found");
			return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
		}
	}
	
	@GET
	@Path("/{email},{password}")
	@Produces("application/json")
	public Response loginUser(@PathParam("email") String userEmail, @PathParam("password") String userPassword) {
		logger.info("Entro a validar datos de usuario.");
		LinkedHashMap<Object, Object> serviceResponse = new LinkedHashMap<Object, Object>();
		try {
			if (userMapper.findByEmail(userEmail) != null) {
				logger.info("El usuario y/o correo, ingresado si se encuentra registrado.");
				if (userMapper.login(userEmail, userPassword) != null) {
					logger.info("Autentica credenciales de usuario.");
					serviceResponse.put("message", "AUTENTICADO");
		            return Response.status(Response.Status.OK).entity(serviceResponse).build();
				} else {
					logger.info("Contraseña incorrecta.");
					serviceResponse.put("message", "Contraseña es incorrecta, validar.");
					return Response.status(Response.Status.UNAUTHORIZED).entity(serviceResponse).build();
				}
			} else {
				logger.info("El usuario y/o correo, ingresado no existe.");
				serviceResponse.put("message", "Usuario ingresado no existe.");
				return Response.status(Response.Status.UNAUTHORIZED).entity(serviceResponse).build();
			}
			
        } catch (Exception e) {
            logger.debug("<< create()");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(serviceResponse).build();
        }
	}
	
	@GET
	@Path("/{email}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response userContactos(@PathParam("email") String userEmail) { 
		logger.info("Entro a extraer contactos del usuario.");
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		try {
			logger.info("Comienza la busqueda de contactos para: " + userEmail );
			List<Constact> listContact = userMapper.findContact(userEmail );
			if (listContact == null) {
				logger.info("Sin datos.");
				response.put("users", Collections.emptyMap());
			} else {
				logger.info("Consulta exitosa, existen datos.");
				response.put("total", listContact.size());
				response.put("contacts", listContact);
			}
			logger.info("Se devuelven los datos y se expone el servicio.");
			return Response.status(Response.Status.OK).entity(listContact).build();
		} catch (Exception e) {
            logger.debug("<< search()");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
	}
	
	
	
	@DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteUser(@PathParam("id") int userId) {

        //LinkedHashMap<Object, Object> apiResponse = new LinkedHashMap<>();
        LinkedHashMap<Object, Object> serviceResponse = new LinkedHashMap<Object, Object>();
        logger.info("Starting to delete a user");

        try {
            int deletePerson = userMapper.deleteById(userId);
            if (deletePerson == 0) {
                serviceResponse.put("delete", "unable delete user");
            } else {
                logger.info("Successfully delete user.");
                serviceResponse.put("delete", "Successfully delete user.");
            }
            return Response.status(Response.Status.OK).entity(serviceResponse).build();

        } catch (Exception e) {

            logger.debug("<< create()");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(serviceResponse).build();
        }
    }
	
	
	
	
	
	
	
	
	
	

}