# Manual de Uso
Para el manejo de la aplicación de gestión de socios de nuestro Club JDOCX se deberán seguir los siguientes pasos:

1) Para ejecutar la aplicación se debe entrar en la carpeta Java / out / artifacts / demoReal_jar y ejecutar el fichero GestiónSocios.bat.

![](/Fotos%20Manual%20de%20Usuario/img1.png)
2) Iniciar sesión con sus credenciales de acceso.
3) Si su cuenta esta insertada como administrador podrá acceder a todas las opciones del CRUD y en caso contrario solo podrá acceder a la opción de *BuscarSocio* y *AñadirSocio*.
# Agregar Socio
 Para *AgregarSocio* debe asegurarse de que todos los campos obligatorios estén correctamente rellenados y luego clickar en el boton de *AgregarSocio* según se muestra en la siguiente imagen.

![](/Fotos%20Manual%20de%20Usuario/img3.png)
***IMPORTANTE***
    
El formato de la fecha debe ser (yyyy-mm-dd)

El siguiente paso es elegir la zona y luego el asiento del socio en la ventana emergente que sale luego de clickar el botón de *Agregar* y esperar unos segundos a que la aplicación envíe el email al cliente con sus datos para que conste el proceso de alta. Si hacemos clic antes de que los campos de la Pantalla de Registro de Clientes se vuelvan a quedar en blanco podemos provocar que el programa deje de responder. Esto es producto de que no se han implementado los *Threads* para que se realizen ambos procesos de manera sincronizada. 

# Editar Socio
Para *EditarSocio* se debe seleccionar primeramente debe seleccionar un campo de búsqueda para filtrar por *DNI*, *Nombre*, *PrimerApellido*, *SegundoApellido*, *Email*.

Luego rellenamos el campo segun a quien queremos buscar y el filtro que hayamos elegido y a continuación clickar en *BuscarSocio*. Imagen a continuación: 

![](/Fotos%20Manual%20de%20Usuario/img4.png)

Los nombres se mostraran en la lista que se encuentra encima del botón *Seleccionar* una vez encontremos al cliente que buscamos hacemos *doble click* encima y pulsamos el botón de *Seleccionar*
o la tecla *Enter*. Los campos que se encontraban vacíos se rellenarán con los datos de la persona seleccionada y si desea modificar algo solamente lo escribimos en uno de los campos y hacemos *click* sobre el botón *Confirmar Cambios*.

# Borrar Socio
Para *EliminarSocio* se realiza el mismo proceso para la búsqueda seleccionando el filtro deseado ya sea *DNI*, *Nombre*, *Primer Apellido*, *Segundo Apellido* o *Email*. 

![](/Fotos%20Manual%20de%20Usuario/img5.png)

Luego de hacer *Doble Click* sobre el cliente que se va eliminar pulsamos el botón *Eliminar* y nos saldrá una ventana de confirmación en caso de que nos equivoquemos.

# Buscar Socio
Para *BuscarSocio* realizamos el mismo proceso de búsqueda anteriormente explicado.

![](/Fotos%20Manual%20de%20Usuario/img6.png)

# Olvidé mi contraseña
En esta sección pulsamos sobre el enlace en la ventana de *Login* he introducimos el correo electrónico que tenemos registrado en nuestra cuenta como *Gestor de Datos en JDOCX*. A continuación esperamos unos segundos a que nos salga la ventana que nos dice *"Le hemos enviado un código a su email"* como se muestra a continuación .

![](/Fotos%20Manual%20de%20Usuario/img7.png)

Cuando pulse en *Aceptar* aparecerá la siguiente ventana

![](/Fotos%20Manual%20de%20Usuario/img8.png)

En esta debe ingresar el código recibido en su correo electrónico y así continuar a la última ventana donde ingresará la nueva contraseña que desee para su cuenta.

![](/Fotos%20Manual%20de%20Usuario/img9.png)

# Funciones para versiones posteriores
- Importar y exportar datos desde un XML para agilización del programa y así no tener que consultar la base de datos    - Implementar los *Threads* para que el envío de email sea sincronizado a la ejecución del programa.
- Cambios en la estética en de la aplicación.
- Implementar la selección múltiple en la lista donde se muestran los clientes.

# Contratiempos
- Excepción al dejar los *TextFields* en agregar vacíos.  //Resuelto

- Excepción al presionar el botón de *Confirmar* y los campos estan vacíos, dice que los que cambios se han realizado con exito aunque no se hayan realizado.  //Resuelto

- Exception al buscar con los campos vacíos //Resuelto

- Teléfono no lo inserta en la base de Datos //Resuelto

- Filtros para elegir campo para buscar socio //Resuelto

- Cambiar el color del HyperLink al ser Clickado porque no se ve //Resuelto

- Cuando borras a un socio actualizar campo **esSocio** en la tabla **usuariosWeb** //Resuelto

- Cuando demos alta a un socio guardar la contraseña con md5; //Resuelto

- Cambiar letra de botones en ventana de *GestionUsuariosNormales*(No Admins) //Resuelto

- Insertar en el correo el número de asiento que se te ha asignado y la zona //Resuelto

- Conseguir enviar el Email sin hacer que el programe deje de responder hasta que el email sea enviado //No resuelto



