import java.util.Date;

public class Clases {

open class Cliente (nombre: String, genero:String, edad:int){

    var nombre = nombre
    var genero= genero
    var edad= edad
    }

class Usuario(nombreUsuario: String, contraseña:String)
            :Cliente(nombre, genero, edad){
    var nNombreUsuario = nombreUsuario
    var nContraseña = contraseña
    lateinit var Cuenta : Cuenta
    var existeCuenta = false

    fun crearCuenta (cuenta : Cuenta)
        nCuenta = crearCuenta
        existeCuenta = true
    }

class Cuenta (tipo:String, ultimaConexion: Date, numeroCancionesEscuchadas){
    var nTipo = tipo
    var nUltimaConexion = ultimaConexion
    var nNumeroCancionesEscuchadas = numeroCancionesEscuchadas

    fun conexion (fecha:Date){
            nUltimaConexion = fecha
        }

     fun escucharCancion (cantidad : Integer)
        nNumeroCancionesEscuchadas = nNumeroCancionesEscuchadas +
}
}
