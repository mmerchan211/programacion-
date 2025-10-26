def calcular_mediana(*numeros):
    if not numeros:
        return None
    lista = sorted(numeros)
    n = len(lista)
    mitad = n // 2
    if n % 2 == 0:
        return (lista[mitad - 1] + lista[mitad]) / 2
    else:
        return lista[mitad]


# Ejemplo de uso:
print("Mediana:", calcular_mediana(25, 5, 15, 30, 35, 40))  
