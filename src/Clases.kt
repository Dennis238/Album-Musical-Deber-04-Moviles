import java.util.Date;

 open class Cliente (nombre: String, genero:String, edad:Int){

    var nombre = nombre
    var genero= genero
    var edad= edad
}


class Cuenta (tipo:String, ultimaConexion: String, numeroCancionesEscuchadas: Int){
    var nTipo = tipo
    var nUltimaConexion = ultimaConexion
    var nNumeroCancionesEscuchadas = numeroCancionesEscuchadas

    fun conexion (fecha:String){
            nUltimaConexion = fecha
        }

     fun escucharCancion (cantidad : Int){
        nNumeroCancionesEscuchadas = nNumeroCancionesEscuchadas
     }
}

class Usuario(nombre: String, genero: String, edad: Int, nombreUsuario: String, contraseña:String) : Cliente (nombre,genero,edad) {
    var nNombreUsuario = nombreUsuario
    var nContraseña = contraseña
    lateinit var nCuenta : Cuenta
    var existeCuenta = false

    fun crearCuenta (cuenta : Cuenta){
        nCuenta = cuenta
        existeCuenta = true
    }}

class Cancion(nombre: String, autor: String, genero: String, album:String) {
    var nNombre = nombre
    var nAutor = autor
    var nGenero = genero
    var nAlbum = album
}

