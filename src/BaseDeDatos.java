import java.util.ArrayList;

public class BaseDeDatos {

    companion object {

        val datos: ArrayList<Int> = ArrayList()

        fun recuperarPorIndice(indice: Int) : Int? {
            for (indiceArreglo in datos.indice){
                if (indiceArreglo == indice) {
                    return datos[indiceArreglo]
                }
            }
            return null
        }
    }
}
