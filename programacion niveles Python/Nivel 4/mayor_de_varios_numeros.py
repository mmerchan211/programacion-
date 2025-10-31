def mayor_de_varios_numeros(*args):
    if len(args) == 0:
        raise ValueError("Se requieren al menos un número.")
    return max(args)

# main
if __name__ == "__main__":
    entrada = input("Ingrese números separados por comas para encontrar el mayor: ")
    nums = [float(x.strip()) for x in entrada.split(",") if x.strip() != ""]
    print("Mayor:", mayor_de_varios_numeros(*nums))
