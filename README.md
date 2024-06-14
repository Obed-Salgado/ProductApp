# ProductApp
Aplicación móvil para la plataforma Android que simula una lista de productos que puedes agregar, editar o eliminar.


Esta aplicación se creó para practicar el consumo de APIs con la librería Retrofit.


# Descripción
La aplicación es un crud mediante Retrofit. 
La primera pantalla muestra una lista de productos que se han agregado.
En la segunda pantalla podemos agregar o editar un producto, sus datos son los siguientes:
- Nombre
- Descripción
- Precio
- Imagen(url)


En el campo de imagen se tiene que poner una url de alguna imagen de internet.


# Tecnologías utilizadas
- Kotlin
- Retrofit2
- Corroutinas
- Navigation Component
- Fragmentos
- Glide
- Dagger Hilt
- MVVM


# Info
La API que se usó para este ejercicio fue “CrudCrud”, a la cual se tiene acceso solo 24 horas y se tiene que volver a renovar el endpoint para poder usarlo en el proyecto. Se seguirán los siguientes pasos.


1. Entre al siguiente enlace https://www.crudcrud.com/ y copie los dígitos del final como aparece en la imagen.

![Logo](https://firebasestorage.googleapis.com/v0/b/using-firebase-af6b1.appspot.com/o/paso1.png?alt=media&token=a105f57a-d37c-4b4e-9f5c-d14dfd5b2a95)

2. Ahora dentro del proyecto buscamos el archivo ”RetrofitModule” y lo abrimos.

![Logo](https://firebasestorage.googleapis.com/v0/b/using-firebase-af6b1.appspot.com/o/paso2.png?alt=media&token=21f99e96-1377-48f5-917c-fa4c6f439d46)

3. Por último, una vez dentro de ”RetrofitModule” buscamos la variable “endpoint” y pegamos los dígitos que copiamos en el paso 1, así como se muestra en la imagen. Una vez hecho esto, el proyecto estará listo para ejecutarse.

![Logo](https://firebasestorage.googleapis.com/v0/b/using-firebase-af6b1.appspot.com/o/paso3.png?alt=media&token=934b5d6d-35f2-4689-9968-a64f1d1cae0c)
