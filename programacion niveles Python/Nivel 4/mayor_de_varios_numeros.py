def mayor_de_varios_numeros(*numeros):
    if not numeros:
        return None
    return max(numeros)


# Ejemplo de uso:
print("Mayor:", mayor_de_varios_numeros(18, 25, 42, 2, 12, 30))  
