def multiplicar_lista(lista, numero):
    return [x * numero for x in lista]

# main
if __name__ == "__main__":
    entrada = input("Ingrese números separados por comas (lista): ")
    lista = [float(x.strip()) for x in entrada.split(",") if x.strip() != ""]
    factor = float(input("Ingrese el número por el cual multiplicar la lista: "))
    resultado = multiplicar_lista(lista, factor)
    print(" Lista multiplicada:", resultado)
