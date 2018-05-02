
import jdk.nashorn.internal.objects.Global
import java.util.*

fun main(args: Array<String>){

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
        var selection = readLine()!!.toInt()

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
                println("\t2. Saldo Inicial: ")
                var ultimaConexion = Global.getDate().toString()
                var numeroCancionesEscuchadas = 0
                val cuenta = Cuenta(tipo,  ultimaConexion, numeroCancionesEscuchadas)
                usuario.crearCuenta(cuenta)
                BaseDeDatos.datos.add(usuario)
                println("Cuenta creada exitosamente!")
        }
}

fun ingresoUsuario() {
        println("Ingreso a su álbum de música\nIngrese:\n\t1. Nombre de Usuario: ")
        var nombreUsuario = readLine()!!
        println("\t2. Contraseña: ")
        var contraseña = readLine()!!
        var usuario = BaseDeDatos.recuperarPorNombreUsuario(nombreUsuario)
        if (usuario != null) {
                if (usuario.nContraseña.equals(contrasena)) {
                        mostrarMenuUsuario(usuario)
                } else {
                        println("Contrasena Incorrecta! Verifique sus datos de ingreso.")
                        ingresoCliente()
                }
        } else {
                println("Cliente no registrado en el sistema")
                mostrarMenuPrincipal()
        }
}
fun mostrarMenuUsuario(usuario: Usuario) {
        if (usuario.existeCuenta) {
                mostrarMenuMusical(usuario)
        } else {
                println("No existe cuenta asociada al cliente")
                println("Menu de Usuario\n\t1. Crear Cuenta\n\t2. Eliminar Cliente\n" +
                        "\t3. Salir")
                var selection = readLine()!!.toInt()
                when (selection) {
                        1 -> {
                                creacionCuenta(cliente)
                                mostrarMenuCliente(cliente)
                        }
                        2 -> {
                                println("Seguro desea eliminar su usuario del sistema?\n" +
                                        "\t1. Si\t2. No")
                                selection = readLine()!!.toInt()
                                if (selection == 1) {
                                        BaseDeDatos.datos.remove(cliente)
                                        println("Cliente eliminado correctamente!")
                                        mostrarMenuPrincipal()
                                } else {
                                        mostrarMenuCliente(cliente)
                                }
                        }
                        else -> {
                                mostrarMenuPrincipal()
                        }
                }
        }
}

fun mostrarMenuMusical(usuario:Usuario) {

        println("Nombre del Usuario: ${usuario.nNombreUsuario}")
        println("Cuenta de Tipo: ${usuario.nCuenta.nTipo}")
        println("Última conexión: ${usuario.nCuenta.nUltimaConexion}")
        println("Nº de Canciones Escuchadas: ${usuario.nCuenta.nNumeroCancionesEscuchadas}")

        usuario.nCuenta.conexion(Global.getDate().toString())

        println("Menú de opciones: \n\t1. Buscar canción por autor\n" +
                "\t2. Buscar canción por género\n" +
                "\t3. Eliminar Usuario\n" +
                "\t4. Salir")
        var selection = readLine()!!.toInt()
        when (selection) {

                3 -> {
                        println("¿Seguro desea eliminar su cuenta de Usuario?\n" +
                                "\t1. Si\t2. No")
                        selection = readLine()!!.toInt()
                        if (selection == 1) {
                                usuario.existeCuenta = false
                                println("Cuenta eliminada correctamente!")
                                abrirMenuPrincipal()
                        }
                }else{
                mostrarMenuUsuario()
                }
        }
        println("Desea realizar otra transaccion?\n" +
                "\t1. Si\t2. No")
        selection = readLine()!!.toInt()
        when (selection) {
                1 -> {
                        mostrarMenuMusical(usuario)
                }
                else -> {
                        mostrarMenuMusical(Usuario()
                }
        }
}


    /* Recuperar datos del array
    BaseDeDatos.datos.add(66) //adiciona un item
    BaseDeDatos.datos.add(23) //adiciona un item
    BaseDeDatos.datos.add(55) //adiciona un item

    println(BaseDeDatos.recuperarPorIndice(1)) //devuelve un item por indice
     */

