def calcular_mediana(*args):
    if len(args) == 0:
        raise ValueError("Se requieren al menos un número.")
    lista = sorted(args)
    n = len(lista)
    mid = n // 2
    if n % 2 == 1:
        return lista[mid]
    else:
        return (lista[mid - 1] + lista[mid]) / 2

# main
if __name__ == "__main__":
    entrada = input(" Ingrese números separados por comas para calcular la mediana: ")
    nums = [float(x.strip()) for x in entrada.split(",") if x.strip() != ""]
    print("Mediana:", calcular_mediana(*nums))
