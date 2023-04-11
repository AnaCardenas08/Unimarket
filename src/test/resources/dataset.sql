/* ----------------------------------------------USUARIO--------------------------------------------------------------------------------------------------------------------------------------------------*/
/* USUARIO: CODIGO(PK), CORREO, NOMBRE, PASSWORD, DIRECCION, TELEFONO */
insert into usuario values (1, "juanperez@gmail.com", "Juan Perez", "000", "Cr 10 #25-30, Bogota", "3001234567");
insert into usuario values (2, "lgomez@hotmail.com", "Laura Gomez", "001", "Cll 30 #8-23, Medellin", "3102345678");
insert into usuario values (3, "cramirez@yahoo.com", "Carlos Ramirez", "002", "Av 4 #18-15, Cali", "3013456789");
insert into usuario values (4, "dcastro@gmail.com", "Diana Castro", "003", "Cr 8 #16-45, Barranquilla", "3204567890");
insert into usuario values (5, "amorales@outlook.com", "Andres Morales", "004", "Cll 12 #9-60, Bucaramanga", "3155678901");

/* ----------------------------------------------MODERADOR---------------------------------------------------------------------------------------------------------------------------------------------------*/
/* MODERADOR: CODIGO(PK), CORREO, NOMBRE, PASSWORD */
insert into moderador values (1, "martalopez@hotmail.com", "Marta Lopez", "00");
insert into moderador values (2, "alejandro.gutierrez@gmail.com", "Alejandro Guiterrez", "01");
insert into moderador values (3, "anamaria.rodriguez@yahoo.com", "Ana Maria Rodriguez", "02");
insert into moderador values (4, "sebastian.ramirez@hotmail.com", "Sebastian Ramirez", "03");
insert into moderador values (5, "lucia.moreno@outlook.com", "Lucia Moreno", "04");

/* ----------------------------------------------PRODUCTO------------------------------------------------------------------------------------------------------------------------------------------------------*/
/* PRODUCTO: CODIGO(PK), DESCRIPCION, DISPONIBILIDAD(ENUM), FECHA_LIMITE, NOMBRE, PRECIO, UNIDADES, MODERADOR_CODIGO, USUARIO_CODIGO */
insert into producto values (1, "Reloj Inteligente con seguimiento de actividad, GPS y pantalla siempre activa", 'INACTIVO', "2023-04-15", "Reloj Inteligente", 1500000, 30, 1, 1);
insert into producto values (2, "Juego de Sabanas de algodon egipcio de alta calidad con estampado floral", 'INACTIVO', "2023-04-16", "Juego de Sabanas", 200000, 20, 2, 2);
insert into producto values (3, "Conjunto de Maquillaje que incluye sombras de ojos, delineadores y lapices labiales de buena pigmentacion", 'APROBADO', "2023-04-17", "Set de Maquillaje", 180000, 40, 3, 3);
insert into producto values (4, "Camisa de Vestir de algodon de corte clasico y botones de nacar", 'APROBADO', "2023-04-18", "Camisa de Vestir", 100000, 50, 4, 4);
insert into producto values (5, "Bicicleta de Montaña con marco de fibra de carbono, suspension delantera y frenos de disco hidraulicos", 'RECHAZADO', "2023-04-19", "Bicicleta de Montaña", 2000000, 10, 5, 5);
insert into producto values (6, "Juego de Vajilla de porcelana con diseños florales y borde dorado", 'ACTIVO', "2023-04-20", "Juego de Vajilla", 500000, 15, 1, 1);
insert into producto values (7, "Auriculares Inalambricos con cancelacion de ruido avanzada y bateria de larga duracion", 'ACTIVO', "2023-04-21", "Auriculares Inalambricos", 800000, 20, 2, 2);

/* ----------------------------------------------PRODUCTO_CATEGORIAS------------------------------------------------------------------------------------------------------------------------------------------*/
/* PRODUCTO_CATEGORIAS: CODIGO(PK), CATEGORIAS(ENUM) */
insert into producto_categorias values (1, 'TECNOLOGIA');
insert into producto_categorias values (2, 'HOGAR');
insert into producto_categorias values (3, 'BELLEZA');
insert into producto_categorias values (4, 'ROPA');
insert into producto_categorias values (5, 'DEPORTE');
insert into producto_categorias values (6, 'HOGAR');
insert into producto_categorias values (7, 'TECNOLOGIA');

/* ----------------------------------------------IMAGEN---------------------------------------------------------------------------------------------------------------------------------------------*/
/* IMAGEN: CODIGO(PK), IMAGEN */
insert into imagen values (1, "Link Imagen", 1);
insert into imagen values (2, "Link Imagen", 1);
insert into imagen values (3, "Link Imagen", 2);
insert into imagen values (4, "Link Imagen", 3);
insert into imagen values (5, "Link Imagen", 4);
insert into imagen values (6, "Link Imagen", 5);
insert into imagen values (7, "Link Imagen", 6);
insert into imagen values (8, "Link Imagen", 7);

/* ----------------------------------------------USUARIO_PRODUCTO_FAVORITO----------------------------------------------------------------------------------------------------------------------------------*/
/* USUARIO_PRODUCTO_FAVORITO: USUARIO_FAVORITO_CODIGO, PRODUCTO_FAVORITO_CODIGO*/
insert into usuario_producto_favorito values (1, 7);
insert into usuario_producto_favorito values (2, 3);
insert into usuario_producto_favorito values (3, 4);
insert into usuario_producto_favorito values (4, 6);
insert into usuario_producto_favorito values (5, 7);

/* ----------------------------------------------COMPRA-----------------------------------------------------------------------------------------------------------------------------------------------------*/
/* COMPRA: CODIGO(PK), FECHA_COMPRA, METODO_PAGO(ENUM), TOTAL_PAGO, USUARIO_CODIGO */
insert into compra values (1, "2023-03-10", 'TARJETA_CREDITO', 180000,1);
insert into compra values (2, "2023-03-12", 'TRANSFERENCIA_PSE', 200000,2);
insert into compra values (3, "2023-03-15", 'PAGO_EFECTY', 1500000,3);
insert into compra values (4, "2023-03-16", 'TARJETA_CREDITO', 800000,4);
insert into compra values (5, "2023-03-10", 'TRANSFERENCIA_PSE', 360000,5);

/* ----------------------------------------------COMPRA_PRODUCTO-------------------------------------------------------------------------------------------------------------------------------------------*/
/* COMPRA_PRODUCTO: CODIGO(PK), PRECIO, UNIDADES, COMPRA_CODIGO, PRODUCTO_CODIGO */
insert into compra_producto values (1, 180000, 1, 1, 3);
insert into compra_producto values (2, 100000, 2, 2, 4);
insert into compra_producto values (3, 500000, 3, 3, 6);
insert into compra_producto values (4, 800000, 1, 4, 7);
insert into compra_producto values (5, 180000, 2, 5, 3);

/* ----------------------------------------------CALIFICACION--------------------------------------------------------------------------------------------------------------------------------------------*/
/* CALIFICACION: CODIGO(PK), CALIFICACION, PRODUCTO_CODIGO, USUARIO_CODIGO */
insert into calificacion values (1, "Bueno", 3, 1);
insert into calificacion values (2, "Excelente", 4, 2);
insert into calificacion values (3, "Regular", 6, 3);
insert into calificacion values (4, "Bueno", 7, 4);
insert into calificacion values (5, "Malo", 3, 5);

/* ----------------------------------------------COMENTARIO----------------------------------------------------------------------------------------------------------------------------------------------*/
/* COMENTARIO: CODIGO(PK), DESCRIPCION, FECHA, PRODUCTO_CODIGO, USUARIO_CODIGO */
insert into comentario values (1,"Comentario...", "2023-03-16", 3, 1);
insert into comentario values (2,"Comentario...", "2023-03-17", 4, 2);
insert into comentario values (3,"Comentario...", "2023-03-18", 6, 3);
insert into comentario values (4,"Comentario...", "2023-03-19", 7, 4);
insert into comentario values (5,"Comentario...", "2023-03-20", 7, 1);

/* ----------------------------------------------FORO---------------------------------------------------------------------------------------------------------------------------------------------------*/
/* FORO: CODIGO(PK), COMENTARIOS, PRODUCTO_CODIGO, USUARIO_CODIGO */
insert into foro values (1, "Comentarios de Foro...", 3, 1);
insert into foro values (2, "Comentarios de Foro...", 4, 2);
insert into foro values (3, "Comentarios de Foro...", 6, 3);
insert into foro values (4, "Comentarios de Foro...", 7, 4);
insert into foro values (5, "Comentarios de Foro...", 3, 1);
