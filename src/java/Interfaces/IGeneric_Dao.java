
package Interfaces;

import DTO.Usuario_dto;
import java.util.List;

public interface IGeneric_Dao <T> {
    public List<T> Select();
    public Usuario_dto Buscar(int codigo);
    public String Update(Usuario_dto usuario);
    public String Delete(int codigo);
    public String Insert(Usuario_dto usuario);
    
    
    
}
