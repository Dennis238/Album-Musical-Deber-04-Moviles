
import jdk.nashorn.internal.objects.Global
import java.time.LocalDateTime
import java.util.*

fun main(args: Array<String>){
        var usuario = Usuario("Dennis Fernando", "Masculino", 21, "Dennis", "dennis238")
        val cuenta = Cuenta("Premium",  LocalDateTime.now().toString(), 0)
        usuario.crearCuenta(cuenta)

        BaseDeDatos.datos.add(usuario)

        var cancion = Cancion("Levels", "Avicii", "Electronica", "True")
        var cancion2 = Cancion("Come as you are", "Nirvana", "Rock", "Nevermind")
        var cancion3 = Cancion("Nuestro juramento", "Julio Jaramillo", "Pasillo", "20 Éxitos")
        var cancion4 = Cancion("Uptown funk", "Bruno Mars", "Pop", "Uptown Special")
        var cancion5 = Cancion("Do i wanna know", "Arctic Monkeys", "Rock", "AM")
        BaseDeDatos2.datos2.add(cancion)
        BaseDeDatos2.datos2.add(cancion2)
        BaseDeDatos2.datos2.add(cancion3)
        BaseDeDatos2.datos2.add(cancion4)
        BaseDeDatos2.datos2.add(cancion5)





        println("\\\\\\\\\\\\\\\\Bienvenido a su Álbum de Música////////")

        abrirMenuPrincipal()
        }


    fun abrirMenuPrincipal() {
        println("\t\t\t\t\t\tMenú Principal\nHaga su selección:\n\t1. Crear Usuario\n" +
                "\t2. Ingresar con Usuario ya creado\n\t3. Salir")
        var opcion = readLine()!!.toInt()
        when (opcion) {
            1 -> {
                creacionUsuario()
            }
            2 -> {
                ingresoUsuario()
            }
        else -> {
                println("\nSaliendo de su álbum de música...")
            }
        }
    }


fun creacionUsuario() {
        println("Creacion de Usuario\nIngrese:\n\t1. Nombre de Usuario: ")
        var nombreUsuario = readLine()!!
        println("\t2. Contrasena: ")
        var contraseña = readLine()!!
        println("\t3. Nombre Completo: ")
        var nombre = readLine()!!
        println("\t4. Cedula: ")
        var genero = readLine()!!
        println("\t5. Edad: ")
        var edad = readLine()!!.toInt()
        val usuario = Usuario(nombre, genero, edad, nombreUsuario, contraseña)
        println("Usuario creado con éxito!")

        creacionCuenta(usuario)
        }

        fun creacionCuenta(usuario: Usuario) {
                println("\"¿Qué tipo de cuenta deseea adquirir?\nSeleccione una:\n\t1. Tipo:\n\t\t1. Normal\n" +
                        "\t\t2. Premium\n" +
                        "\t\t3. Deluxe")
                var tipo = when (readLine()!!.toInt()) {
                        1 -> {
                                "Normal"
                        }
                        2 -> {
                                "Premium"
                        }
                        else -> {
                                "Deluxe"
                        }
                }

                var ultimaConexion = LocalDateTime.now().toString()
                var numeroCancionesEscuchadas = 0
                val cuenta = Cuenta(tipo,  ultimaConexion, numeroCancionesEscuchadas)
                usuario.crearCuenta(cuenta)
                BaseDeDatos.datos.add(usuario)
                println("Cuenta creada exitosamente!")
                mostrarMenuUsuario(usuario)

        }


fun ingresoUsuario() {
        println("Ingreso a su álbum de música\nIngrese:\n\t1. Nombre de Usuario: ")
        var nombreUsuario = readLine()!!
        println("\t2. Contraseña: ")
        var contraseña = readLine()!!
        var usuario = BaseDeDatos.recuperarPorNombreUsuario(nombreUsuario)
        if (usuario != null) {
                if (usuario.nContraseña.equals(contraseña)) {
                        mostrarMenuUsuario(usuario)
                } else {
                        println("Contrasena Incorrecta! Verifique sus datos de ingreso.")
                        ingresoUsuario()
                }
        } else {
                println("Cliente no registrado en el sistema")
                abrirMenuPrincipal()
        }
}
fun mostrarMenuUsuario(usuario: Usuario) {
        if (usuario.existeCuenta) {
                mostrarMenuMusical(usuario)
        } else {
                println("No existe cuenta asociada al usuario")
                println("Menu de Usuario\n\t1. Crear Cuenta\n\t2. Eliminar Usuario\n" +
                        "\t3. Salir")
                var selection = readLine()!!.toInt()
                when (selection) {
                        1 -> {
                                creacionCuenta(usuario)
                                mostrarMenuUsuario(usuario)
                        }
                        2 -> {
                                println("Seguro desea eliminar su usuario del sistema?\n" +
                                        "\t1. Si\t2. No")
                                selection = readLine()!!.toInt()
                                if (selection == 1) {
                                        BaseDeDatos.datos.remove(usuario)
                                        println("Cliente eliminado correctamente!")
                                        abrirMenuPrincipal()
                                } else {
                                        mostrarMenuUsuario(usuario)
                                }
                        }
                        else -> {
                                abrirMenuPrincipal()
                        }
                }
        }
}

fun mostrarMenuMusical(usuario:Usuario) {

        println("Nombre del Usuario: ${usuario.nNombreUsuario}")
        println("Cuenta de Tipo: ${usuario.nCuenta.nTipo}")
        println("Última conexión: ${usuario.nCuenta.nUltimaConexion}")
        println("Nº de Canciones Escuchadas: ${usuario.nCuenta.nNumeroCancionesEscuchadas}")

        usuario.nCuenta.conexion(LocalDateTime.now().toString())

        println("Menú de opciones: \n\t1. Buscar canción por autor\n" +
                "\t2. Buscar canción por su nombre\n" +
                "\t3. Eliminar Usuario\n" +
                "\t4. Salir")
        var selection = readLine()!!.toInt()
        when (selection) {

                1 -> {
                        println("Ingrese el nombre por autor: ")
                        var nombreAutor = readLine()!!
                        var cancion = BaseDeDatos2.recuperarPorNombreAutor(nombreAutor)
                        println("La canción buscada es: \n\tNombre: ${cancion?.nNombre} \n" +
                                "\tAutor: ${cancion?.nAutor}\n" +
                                "\tGenero: ${cancion?.nGenero}\n" +
                                "\tÁlbum: ${cancion?.nAlbum}")
                }
                2 -> {
                        println("Ingrese el nombre por nombre de Canción: ")
                        var nombreAutor = readLine()!!
                        var cancion = BaseDeDatos2.recuperarPorNombreCancion(nombreAutor)
                        println("La canción buscada es: \n\tNombre: ${cancion?.nNombre} \n" +
                                "\tAutor: ${cancion?.nAutor}\n" +
                                "\tGenero: ${cancion?.nGenero}\n" +
                                "\tÁlbum: ${cancion?.nAlbum}")
                }
                3 -> {
                        println("¿Seguro desea eliminar su cuenta de Usuario?\n" +
                                "\t1. Si\t2. No")
                        selection = readLine()!!.toInt()
                        if (selection == 1) {
                                usuario.existeCuenta = false
                                println("Cuenta eliminada correctamente!")
                                abrirMenuPrincipal()
                        }
                }else ->{
                abrirMenuPrincipal()
                }
        }
        println("Desea hallar otra canción?\n" +
                "\t1. Si\t2. No")
        selection = readLine()!!.toInt()
        when (selection) {
                1 -> {
                        mostrarMenuMusical(usuario)
                }
                else -> {
                        abrirMenuPrincipal()
                }
        }
}






