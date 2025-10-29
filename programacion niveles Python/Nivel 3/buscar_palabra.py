def buscar_palabra(cadena, palabra):
    if palabra in cadena:
        return True
    else:
        return False


# Ejemplo de uso:
texto =  input("Ingrese el texto: ")
palabra = input("Ingrese la palabra:")
resultado1 = buscar_palabra(texto, palabra)
print("¿Está palabra en la cadena?:", resultado1)
palabra = input("Ingrese otra palabra:")
resultado2 = buscar_palabra(texto,palabra)
print("¿Está palabra en la cadena?:", resultado2)



