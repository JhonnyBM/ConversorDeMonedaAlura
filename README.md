Proyecto conversor de monedas con API.
La clase principal consta de un menu de opciones encerradas en un ciclo while con opcion de "salir".
Dentro de las opciones puedes elegir la moneda a cambiar y la moneda deseada (El menu ofrece unas sugerencias pero tambien puedes ingresar la moneda de forma manual), esta moneda debe estar en Currency code (puedes consultar más 
información en: https://www.exchangerate-api.com/docs/supported-currencies)
Luego de ello el programa pide la cantidad a convertir y con ello hace una consulta a la API, esta nos devuelve por el metodo GET un formato Json, el cual a través de un record lo transformamos en una clase.
De esta imprimimos un resultado en el compilador y a su vez ejecuta una funcion para crear una lista con el resultado, al momento de "salir", se crea un archivo JSon con dicho historial
