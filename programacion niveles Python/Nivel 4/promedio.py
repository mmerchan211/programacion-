def promedio(*numeros):
    
    if len(numeros) == 0:
        return None
    return sum(numeros) / len(numeros)


# Ejemplo de uso:
print("Promedio:", promedio(2.5, 3.6, 1, 4))  
