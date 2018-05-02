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

public class BaseDeDatos2 {

    companion object {

        val datos2: ArrayList<Cancion> = ArrayList()

        fun recuperarPorNombreAutor(nombreAutor: String) : Cancion? {
            for (cancion in datos2){
                if (cancion.nAutor.equals(nombreAutor)) {
                    return cancion
                }
            }
            return null
        }

        fun recuperarPorNombreCancion(nombre: String) : Cancion? {
            for (cancion in datos2){
                if (cancion.nNombre.equals(nombre)) {
                    return cancion
                }
            }
            return null
        }

    }
}
