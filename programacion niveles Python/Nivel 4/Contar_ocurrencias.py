def contar_ocurrencias(cadena, palabra):
    if palabra == "":
        raise ValueError("La palabra a buscar no puede ser vacía.")
    lower_cadena = cadena.lower()
    lower_palabra = palabra.lower()
    count = 0
    start = 0
    while True:
        idx = lower_cadena.find(lower_palabra, start)
        if idx == -1:
            break
        count += 1
        start = idx + len(lower_palabra)  # evitar solapamiento
    return count

# main
if __name__ == "__main__":
    texto = input("Ingrese la cadena (texto): ")
    palabra = input("Ingrese la palabra a contar: ")
    print("Ocurrencias:", contar_ocurrencias(texto, palabra))

