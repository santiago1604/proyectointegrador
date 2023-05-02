<%-- 
    Document   : index
    Created on : 27/04/2023, 11:58:09 p. m.
    Author     : Brayan
--%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Formulario de Registro</title>
    <link rel="stylesheet" href="estilos.css">
  </head>
  <body>
    <div class="contenedor">
      <h1>Registro</h1>
      <form action="servletPersona" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre"><br>

        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido"><br>

        <label for="correo">Correo Electrónico:</label>
        <input type="email" id="correo" name="correo"><br>

        <label for="telefono">Teléfono:</label>
        <input type="tel" id="telefono" name="telefono"><br>

        <input type="submit" value="Registrarse">
    </form>
    </div>
  </body>
</html> 
