import java.util.ArrayList;

public class BaseDeDatos {

    companion object {

        val datos: ArrayList<Usuario> = ArrayList()

        fun recuperarPorNombreUsuario(nombreUsuario: String) : Usuario? {
            for (usuario in datos){
                if (usuario.nNombreUsuario.equals(nombreUsuario)) {
                    return usuario
                }
            }
            return null
        }
    }
}
