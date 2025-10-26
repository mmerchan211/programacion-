import random

def num_aleatorio():
    # Generar un número aleatorio entre 1 y 100
    numero_secreto = random.randint(1, 100)
    
    print("Bienvenido al juego de adivinanza")
    print("He generado un número entre 1 y 100. intenta adivinar cual es")
    
    while True:
        try:
            intento = int(input("Ingresa tu número: "))
            
            if intento < 1 or intento > 100:
                print("Por favor, ingresa un número entre 1 y 100.")
                continue
            
            if intento < numero_secreto:
                print("El número que ingresaste es menor que el número secreto.")
            elif intento > numero_secreto:
                print("El número que ingresaste es mayor que el número secreto.")
            else:
                print("¡Felicitaciones, adivinaste el número!")
                break
                
        except ValueError:
            print("Por favor, ingresa un número válido.")


if __name__ == "__main__":
    num_aleatorio()