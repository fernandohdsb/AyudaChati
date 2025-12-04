package com.example.categorias.DataSet

import android.util.Log
import com.example.categorias.model.Categoria
import com.example.categorias.model.Producto

class DataSet {

    companion object{
        val listaCarrito: ArrayList<Producto> = arrayListOf()

        fun getCategorias(categoria: Categoria): ArrayList<Producto>{
            val listaProducto: ArrayList<Producto> = arrayListOf()

            when(categoria.categoria){
                "Todas" -> {

                    val productos = listOf(
                        Producto(
                            nombre = "Reloj inteligente Xiaomi Mi Band 8",
                            precio = 39,
                            imagen = "https://m.media-amazon.com/images/I/61r6oAiR1JL._AC_SX679_.jpg",
                            stock = 15,
                            descripcion = "Pulsera de actividad y salud con monitor cardiaco.",
                            categoria = "tecnologia"
                        ),
                        Producto(
                            nombre = "Mascarilla reutilizable negra",
                            precio = 8,
                            imagen = "https://m.media-amazon.com/images/I/61jq2p1JaJL._AC_SY450_.jpg",
                            stock = 120,
                            descripcion = "Mascarilla lavable para protección diaria.",
                            categoria = "ropa"
                        ),
                        Producto(
                            nombre = "Auriculares inalámbricos JBL Tune 510BT",
                            precio = 49,
                            imagen = "https://m.media-amazon.com/images/I/71N8GZ52TRL._AC_SX679_.jpg",
                            stock = 23,
                            descripcion = "Bluetooth, micrófono integrado y sonido potente.",
                            categoria = "tecnologia"
                        ),
                        Producto(
                            nombre = "Humidificador ultrasónico TaoTronics",
                            precio = 29,
                            imagen = "https://m.media-amazon.com/images/I/61EkrDsv4lL._AC_SX679_.jpg",
                            stock = 59,
                            descripcion = "Mejora la calidad del aire y la salud respiratoria.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Mochila deportiva Under Armour Hustle",
                            precio = 42,
                            imagen = "https://m.media-amazon.com/images/I/713xlDbK6sL._AC_SX679_.jpg",
                            stock = 33,
                            descripcion = "Resistente al agua, con múltiples compartimentos.",
                            categoria = "ropa"
                        ),
                        Producto(
                            nombre = "Freidora de aire Cosori 4.7L",
                            precio = 99,
                            imagen = "https://m.media-amazon.com/images/I/71SOIo4loPL._AC_SX679_.jpg",
                            stock = 8,
                            descripcion = "Cocina saludable sin aceite, fácil limpieza.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Teclado gaming Logitech G213",
                            precio = 59,
                            imagen = "https://m.media-amazon.com/images/I/81a6hk+3UIL._AC_SX679_.jpg",
                            stock = 19,
                            descripcion = "RGB, resistente a salpicaduras, ideal para gamers.",
                            categoria = "tecnologia"
                        ),
                        Producto(
                            nombre = "Tablet Samsung Galaxy Tab A8",
                            precio = 199,
                            imagen = "https://m.media-amazon.com/images/I/81D3N903b6L._AC_SX679_.jpg",
                            stock = 10,
                            descripcion = "Tablet de 10.5 pulgadas, 64GB almacenamiento.",
                            categoria = "tecnologia"
                        ),
                        Producto(
                            nombre = "Pendientes de plata Tous",
                            precio = 69,
                            imagen = "https://m.media-amazon.com/images/I/71FK4TUXRAL._AC_SY450_.jpg",
                            stock = 25,
                            descripcion = "Pendientes originales Tous en plata.",
                            categoria = "belleza"
                        ),
                        Producto(
                            nombre = "Leggings deportivos Nike One",
                            precio = 36,
                            imagen = "https://m.media-amazon.com/images/I/71kfnPOfqVL._AC_UX522_.jpg",
                            stock = 40,
                            descripcion = "Elásticos y cómodos para deporte.",
                            categoria = "ropa"
                        ),
                        Producto(
                            nombre = "Botella de agua Chillys 500ml",
                            precio = 22,
                            imagen = "https://m.media-amazon.com/images/I/615fH5rvedL._AC_SX679_.jpg",
                            stock = 80,
                            descripcion = "Botella de acero inoxidable, mantiene frío/calor.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Esterilla de yoga Amazon Basics",
                            precio = 17,
                            imagen = "https://m.media-amazon.com/images/I/81Dy9tKEuML._AC_SX679_.jpg",
                            stock = 50,
                            descripcion = "Ideal para yoga y pilates, antideslizante.",
                            categoria = "belleza"
                        ),
                        Producto(
                            nombre = "Juego de mesa Catan",
                            precio = 36,
                            imagen = "https://m.media-amazon.com/images/I/91FqpFhfFPL._AC_SX679_.jpg",
                            stock = 12,
                            descripcion = "El clásico juego de estrategia y recursos.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Aceite esencial Lavanda Pranarom",
                            precio = 15,
                            imagen = "https://m.media-amazon.com/images/I/61-nrBWWlGL._AC_SY450_.jpg",
                            stock = 60,
                            descripcion = "Relajante y natural para difusores.",
                            categoria = "belleza"
                        ),
                        Producto(
                            nombre = "Silla de escritorio ergonómica Hbada",
                            precio = 109,
                            imagen = "https://m.media-amazon.com/images/I/71HMZ-8lTtL._AC_SX679_.jpg",
                            stock = 7,
                            descripcion = "Ajuste lumbar, ruedas suaves, diseño moderno.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Aspiradora robot Cecotec Conga",
                            precio = 179,
                            imagen = "https://m.media-amazon.com/images/I/61LwrBFGpeL._AC_SX679_.jpg",
                            stock = 15,
                            descripcion = "Robot inteligente auto limpieza para hogar.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Panel solar portátil Bluetti",
                            precio = 229,
                            imagen = "https://m.media-amazon.com/images/I/51nkrFhQHcL._AC_SX679_.jpg",
                            stock = 5,
                            descripcion = "Energía renovable portátil para viajes.",
                            categoria = "tecnologia"
                        ),
                        Producto(
                            nombre = "Té matcha japonés Bio",
                            precio = 12,
                            imagen = "https://m.media-amazon.com/images/I/71IeJaoBDlL._AC_SY450_.jpg",
                            stock = 34,
                            descripcion = "Matcha premium, antioxidante y energizante.",
                            categoria = "belleza"
                        ),
                        Producto(
                            nombre = "Trípode móvil Joby GripTight",
                            precio = 18,
                            imagen = "https://m.media-amazon.com/images/I/51KKo1EyFeL._AC_SX679_.jpg",
                            stock = 27,
                            descripcion = "Trípode flexible para smartphone y cámaras.",
                            categoria = "tecnologia"
                        ),
                        Producto(
                            nombre = "Vintage jeans Levi’s 501",
                            precio = 85,
                            imagen = "https://m.media-amazon.com/images/I/81HbQZQJwEL._AC_UX466_.jpg",
                            stock = 18,
                            descripcion = "Vaqueros clásicos vintage, edición especial.",
                            categoria = "ropa"
                        ),
                        Producto(
                            nombre = "Pestañas postizas MAGNETIC Ardell",
                            precio = 11,
                            imagen = "https://m.media-amazon.com/images/I/41xZmyShfYL._AC_SX466_.jpg",
                            stock = 58,
                            descripcion = "Fácil aplicación, resultado profesional.",
                            categoria = "belleza"
                        ),
                        Producto(
                            nombre = "Corrector de postura Beurer",
                            precio = 29,
                            imagen = "https://m.media-amazon.com/images/I/613XrU3sTVL._AC_SY450_.jpg",
                            stock = 22,
                            descripcion = "Ajustable para espalda, alivia dolores.",
                            categoria = "belleza"
                        ),
                        Producto(
                            nombre = "Cama para gatos Amazon Basics",
                            precio = 27,
                            imagen = "https://m.media-amazon.com/images/I/71EcmyDIa9L._AC_SX679_.jpg",
                            stock = 36,
                            descripcion = "Cama mullida y segura para mascotas.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Coletero scrunchie satinado",
                            precio = 4,
                            imagen = "https://m.media-amazon.com/images/I/61I8yHjMK7L._AC_SX679_.jpg",
                            stock = 100,
                            descripcion = "Accesorio de moda para el cabello.",
                            categoria = "belleza"
                        ),
                        Producto(
                            nombre = "Lavadora portátil COSTWAY Mini",
                            precio = 139,
                            imagen = "https://m.media-amazon.com/images/I/718XPlGVnOS._AC_SX679_.jpg",
                            stock = 4,
                            descripcion = "Pequeña, eficiente y fácil de transportar.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Caña de pescar telescópica Sougayilang",
                            precio = 29,
                            imagen = "https://m.media-amazon.com/images/I/718-V4cM4RL._AC_SX679_.jpg",
                            stock = 21,
                            descripcion = "Ideal para pesca deportiva y recreativa.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Rascador para gatos Feandrea",
                            precio = 59,
                            imagen = "https://m.media-amazon.com/images/I/81zsMZBJPAL._AC_SX679_.jpg",
                            stock = 15,
                            descripcion = "Juguete multifunción, sisal natural.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Mochila portabebés Ergobaby",
                            precio = 139,
                            imagen = "https://m.media-amazon.com/images/I/715I2Q0vRuL._AC_SX679_.jpg",
                            stock = 7,
                            descripcion = "Ergonómica, segura y fácil de ajustar.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Batidora portátil TOPESCT",
                            precio = 26,
                            imagen = "https://m.media-amazon.com/images/I/61mrhYDa7pL._AC_SX679_.jpg",
                            stock = 24,
                            descripcion = "Batidora personal con USB recargable.",
                            categoria = "mueble"
                        ),
                        Producto(
                            nombre = "Pantalón Cargo Urban Classics",
                            precio = 34,
                            imagen = "https://m.media-amazon.com/images/I/71LRDAr9JiL._AC_UX569_.jpg",
                            stock = 20,
                            descripcion = "Pantalón con bolsillos, estilo casual.",
                            categoria = "ropa"
                        )
                    )
                    listaProducto.clear()
                    listaProducto.addAll(productos)

                }// listaProducto.addAll(meto unos cuantos productos metiendo imagen con URL)
                "Tecnologia" -> {
                    val tecnologia = listOf(
                        Producto("Reloj inteligente Xiaomi Mi Band 8", 39, "https://m.media-amazon.com/images/I/61r6oAiR1JL._AC_SX679_.jpg", 15, "Pulsera de actividad y salud con monitor cardiaco.", "tecnologia"),
                        Producto("Auriculares inalámbricos JBL Tune 510BT", 49, "https://m.media-amazon.com/images/I/71N8GZ52TRL._AC_SX679_.jpg", 23, "Bluetooth, micrófono integrado y sonido potente.", "tecnologia"),
                        Producto("Teclado gaming Logitech G213", 59, "https://m.media-amazon.com/images/I/81a6hk+3UIL._AC_SX679_.jpg", 19, "RGB, resistente a salpicaduras, ideal para gamers.", "tecnologia"),
                        Producto("Tablet Samsung Galaxy Tab A8", 199, "https://m.media-amazon.com/images/I/81D3N903b6L._AC_SX679_.jpg", 10, "Tablet de 10.5 pulgadas, 64GB almacenamiento.", "tecnologia"),
                        Producto("Panel solar portátil Bluetti", 229, "https://m.media-amazon.com/images/I/51nkrFhQHcL._AC_SX679_.jpg", 5, "Energía renovable portátil para viajes.", "tecnologia"),
                        Producto("Trípode móvil Joby GripTight", 18, "https://m.media-amazon.com/images/I/51KKo1EyFeL._AC_SX679_.jpg", 27, "Trípode flexible para smartphone y cámaras.", "tecnologia")
                    )
                    listaProducto.clear()
                    listaProducto.addAll(tecnologia)
                }
                "Ropa" -> {
                    val ropa = listOf(
                        Producto("Mascarilla reutilizable negra", 8, "https://m.media-amazon.com/images/I/61jq2p1JaJL._AC_SY450_.jpg", 120, "Mascarilla lavable para protección diaria.", "ropa"),
                        Producto("Mochila deportiva Under Armour Hustle", 42, "https://m.media-amazon.com/images/I/713xlDbK6sL._AC_SX679_.jpg", 33, "Resistente al agua, con múltiples compartimentos.", "ropa"),
                        Producto("Leggings deportivos Nike One", 36, "https://m.media-amazon.com/images/I/71kfnPOfqVL._AC_UX522_.jpg", 40, "Elásticos y cómodos para deporte.", "ropa"),
                        Producto("Vintage jeans Levi’s 501", 85, "https://m.media-amazon.com/images/I/81HbQZQJwEL._AC_UX466_.jpg", 18, "Vaqueros clásicos vintage, edición especial.", "ropa"),
                        Producto("Pantalón Cargo Urban Classics", 34, "https://m.media-amazon.com/images/I/71LRDAr9JiL._AC_UX569_.jpg", 20, "Pantalón con bolsillos, estilo casual.", "ropa")
                    )
                    listaProducto.clear()
                    listaProducto.addAll(ropa)
                }
                "Muebles" -> {
                    val muebles = listOf(
                        Producto("Humidificador ultrasónico TaoTronics", 29, "https://m.media-amazon.com/images/I/61EkrDsv4lL._AC_SX679_.jpg", 59, "Mejora la calidad del aire y la salud respiratoria.", "mueble"),
                        Producto("Freidora de aire Cosori 4.7L", 99, "https://m.media-amazon.com/images/I/71SOIo4loPL._AC_SX679_.jpg", 8, "Cocina saludable sin aceite, fácil limpieza.", "mueble"),
                        Producto("Botella de agua Chillys 500ml", 22, "https://m.media-amazon.com/images/I/615fH5rvedL._AC_SX679_.jpg", 80, "Botella de acero inoxidable, mantiene frío/calor.", "mueble"),
                        Producto("Juego de mesa Catan", 36, "https://m.media-amazon.com/images/I/91FqpFhfFPL._AC_SX679_.jpg", 12, "El clásico juego de estrategia y recursos.", "mueble"),
                        Producto("Silla de escritorio ergonómica Hbada", 109, "https://m.media-amazon.com/images/I/71HMZ-8lTtL._AC_SX679_.jpg", 7, "Ajuste lumbar, ruedas suaves, diseño moderno.", "mueble"),
                        Producto("Aspiradora robot Cecotec Conga", 179, "https://m.media-amazon.com/images/I/61LwrBFGpeL._AC_SX679_.jpg", 15, "Robot inteligente auto limpieza para hogar.", "mueble"),
                        Producto("Cama para gatos Amazon Basics", 27, "https://m.media-amazon.com/images/I/71EcmyDIa9L._AC_SX679_.jpg", 36, "Cama mullida y segura para mascotas.", "mueble"),
                        Producto("Lavadora portátil COSTWAY Mini", 139, "https://m.media-amazon.com/images/I/718XPlGVnOS._AC_SX679_.jpg", 4, "Pequeña, eficiente y fácil de transportar.", "mueble"),
                        Producto("Caña de pescar telescópica Sougayilang", 29, "https://m.media-amazon.com/images/I/718-V4cM4RL._AC_SX679_.jpg", 21, "Ideal para pesca deportiva y recreativa.", "mueble"),
                        Producto("Rascador para gatos Feandrea", 59, "https://m.media-amazon.com/images/I/81zsMZBJPAL._AC_SX679_.jpg", 15, "Juguete multifunción, sisal natural.", "mueble"),
                        Producto("Mochila portabebés Ergobaby", 139, "https://m.media-amazon.com/images/I/715I2Q0vRuL._AC_SX679_.jpg", 7, "Ergonómica, segura y fácil de ajustar.", "mueble"),
                        Producto("Batidora portátil TOPESCT", 26, "https://m.media-amazon.com/images/I/61mrhYDa7pL._AC_SX679_.jpg", 24, "Batidora personal con USB recargable.", "mueble")
                    )
                    listaProducto.clear()
                    listaProducto.addAll(muebles)
                }
                "Belleza" -> {
                    val belleza = listOf(
                        Producto("Pendientes de plata Tous", 69, "https://m.media-amazon.com/images/I/71FK4TUXRAL._AC_SY450_.jpg", 25, "Pendientes originales Tous en plata.", "belleza"),
                        Producto("Esterilla de yoga Amazon Basics", 17, "https://m.media-amazon.com/images/I/81Dy9tKEuML._AC_SX679_.jpg", 50, "Ideal para yoga y pilates, antideslizante.", "belleza"),
                        Producto("Aceite esencial Lavanda Pranarom", 15, "https://m.media-amazon.com/images/I/61-nrBWWlGL._AC_SY450_.jpg", 60, "Relajante y natural para difusores.", "belleza"),
                        Producto("Té matcha japonés Bio", 12, "https://m.media-amazon.com/images/I/71IeJaoBDlL._AC_SY450_.jpg", 34, "Matcha premium, antioxidante y energizante.", "belleza"),
                        Producto("Pestañas postizas MAGNETIC Ardell", 11, "https://m.media-amazon.com/images/I/41xZmyShfYL._AC_SX466_.jpg", 58, "Fácil aplicación, resultado profesional.", "belleza"),
                        Producto("Corrector de postura Beurer", 29, "https://m.media-amazon.com/images/I/613XrU3sTVL._AC_SY450_.jpg", 22, "Ajustable para espalda, alivia dolores.", "belleza"),
                        Producto("Coletero scrunchie satinado", 4, "https://m.media-amazon.com/images/I/61I8yHjMK7L._AC_SX679_.jpg", 100, "Accesorio de moda para el cabello.", "belleza")
                    )
                    listaProducto.clear()
                    listaProducto.addAll(belleza)
                }
            }
            return listaProducto
        }

        fun aniadirAlCarrito(producto: Producto){
            listaCarrito.add(producto)

            Log.v("añadirAlCarrito",listaCarrito.size.toString())

        }
        fun quitarDelCarrito(producto: Producto){
            listaCarrito.remove(producto)
            Log.v("quitarDelCarrito",listaCarrito.size.toString())

        }
    }
}