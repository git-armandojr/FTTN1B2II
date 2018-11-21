
package ws;

import DAO.Db_Connection;
import DAO.Usuario_DAO;
import DTO.Usuario_dto;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Igor Martins
 */
@Path("api")
public class GenericResource {

    @Context
    private UriInfo context;

    public GenericResource() {
    }
    /**
     * Retrieves representation of an instance of ws.GenericResource
     * @param codigo
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/usuario/select/{codigo}")
    public String getUsuarios(@PathParam("codigo") int codigo){
        Usuario_DAO usuario = new Usuario_DAO();
        // List<Usuario_dto> lista_usuario = usuario.Buscar(codigo);   
        Usuario_dto dto = usuario.Buscar(codigo);
        Gson g = new Gson();
        return g.toJson(dto);          
    }

    @GET
    @Path("/test_connection")
    @Produces(MediaType.TEXT_HTML)
    public String getConnection() throws SQLException, ClassNotFoundException{
        try{
        Db_Connection a = new Db_Connection();
        Connection connection = Db_Connection.getDB_Connection();        
        return a.Status;
        } 
        catch (Exception erro)
        {
            return erro.getMessage();
        }
    }
    /**
     * }
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return 
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {     
        Usuario_dto usuario;       
        Gson g = new Gson();
        usuario = g.fromJson(content, Usuario_dto.class);
        Usuario_DAO metodo = new Usuario_DAO();
        return metodo.Update(usuario);
    }
    
    @GET
    @Path("/usuario/delete/{codigo}")
    public String delete (@PathParam("codigo") int codigo){
        Usuario_DAO usuario = new Usuario_DAO();
        return usuario.Delete(codigo);
    }
    
    @POST
    @Path("/usuario/inserir")
    @Consumes(MediaType.APPLICATION_JSON)
    public String insert(String content) {
        Usuario_dto usuario;       
        Gson g = new Gson();
        usuario = g.fromJson(content, Usuario_dto.class);
        Usuario_DAO metodo = new Usuario_DAO();
        return metodo.Insert(usuario);
    }
    
   
    
}

