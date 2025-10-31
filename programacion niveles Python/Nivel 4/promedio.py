def promedio(*args):
    if len(args) == 0:
        raise ValueError("Se requieren al menos un número para calcular el promedio.")
    return sum(args) / len(args)

# main
if __name__ == "__main__":
    entrada = input("Ingrese números separados por comas para calcular el promedio: ")
    nums = [float(x.strip()) for x in entrada.split(",") if x.strip() != ""]
    print("Promedio:", promedio(*nums))


