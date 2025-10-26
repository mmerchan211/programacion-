import math

radio = float(input("Ingresa el radio del cilindro: "))
altura = float(input("Ingresa la altura del cilindro: "))

# Calcular el área
area = (2 * math.pi * radio**2) + (2 * math.pi * radio * altura)

# Mostrar el resultado
print(f"El área del cilindro es: {area:.2f}")