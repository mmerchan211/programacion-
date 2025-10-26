def contar_ocurrencias(cadena, palabra):
    cadena = cadena.lower()
    palabra = palabra.lower()

    palabras = cadena.split()

    contador = palabras.count(palabra)

    
    print(f'La palabra "{palabra}" se repite {contador} {"vez" if contador == 1 else "veces"}.')
    return contador


# Ejemplo de uso:
texto = "A adriana le gusta mucho ir a cine, por eso adriana va todos los miercoles"
contar_ocurrencias(texto, "Adriana")
