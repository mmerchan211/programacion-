def buscar_palabra(cadena, palabra):
    
    if palabra in cadena:
        return True
    else:
        return False


# Ejemplo de uso:
texto = "Me encanta el pastel red velvet"
resultado1 = buscar_palabra(texto, "velvet")
resultado2 = buscar_palabra(texto, "flores")

print("¿Está 'velvet' en la cadena?:", resultado1)
print("¿Está 'flores' en la cadena?:", resultado2)

