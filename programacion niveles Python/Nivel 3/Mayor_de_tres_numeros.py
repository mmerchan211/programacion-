def mayor_de_tres_numeros(numero1: float, numero2: float, numero3: float) -> float:
    return max(numero1, numero2, numero3)

# main
if __name__ == "__main__":
    a = float(input("Ingrese el primer número: "))
    b = float(input("Ingrese el segundo número: "))
    c = float(input("Ingrese el tercer número: "))
    mayor = mayor_de_tres_numeros(a, b, c)
    print("El número mayor es:", mayor)
