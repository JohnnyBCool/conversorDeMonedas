# conversorDeMonedas
Challenge de ALURA LATAM- Conversor de Divisas
<h1 align="center"> Conversor de Monedas, Challenge. </h1>

## 📓:Descripción del Proyecto
Esta carpeta contiene el Challenge "Conversor de Monedas" que consiste en una aplicación para el Back-End cuyo propóisto es convertir una moneda a otra por medio de la implementación de APIs para acceder a información vigente del tipo de cambio a través del servidor https://www.exchangerate-api.com y su API de libre acceso.

Las área del conocimiento requeridas para la construcción de esta aplicación son las siguientes:
- ``: Programación orientada a objetos.
- ``: Consumo de APIs.
- ``: Manejo de excepciones.

## :hammer:Funcionalidades del proyecto
- `Menú de Inicio`: Es la pantalla principal donde el usuario seleccionará una opción introduciendo un valor entero.
- `1 Convertir una divisa`: Es una serie de pasos con los que se coniuge la equivalencia de una moneda a otra.
- `2 Consultar los códigos de las divisas disponibles.`: Se muestran los códigos que corresponden a lo tipos de cambio que se introducen como parámetro en el proceso de "Convertir una divisa".
- `3 Salir`: Salir de la aplicación.

## 📂 Composición del proyecto

- `3 Salir`: Esta aplicación hecha para el Back-End funciona con la clase principal donde se encuentran los métodos principale para el funcionamiento de la app.
- Se construyeron métodos en clases auxiliares que desempeñan las siguiente funciones
`⚙️`:​ 
`💻:` 
      - `Muestra Códigos`: Se visualizan los códigos disponibles para la divisas.
      - 'Efectuar Peticiones': Funciones de API para obtener información de las divisas desde el servidor de https://www.exchangerate-api.com.
      - 'Manejo de objetos JSON' : Una vez obtenida los datos del serivdor, se estructuro una cadena de carácteres para formar un objeto JSON para el manejo de sus datos, también se implementó una clae record.
`⚠️:` Se implementó el manejo de excepciones para forzar la correcta entrada de datos y prevenir el malfuncionamiento de la app.    
`🛠️:` Para ejecutar el proyecto, copiar los archivos en una carpeta en su equipo local y compilar la clase principal "Principal.java", ubicado en: com.aluracursos.conversordemonedas.Principal
-`💾`: Las clases auxiliares encuentran en: com.aluracursos.conversordemonedas.modelos

